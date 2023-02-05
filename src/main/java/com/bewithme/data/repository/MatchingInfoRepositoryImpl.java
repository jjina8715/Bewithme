package com.bewithme.data.repository;


import static com.bewithme.data.entity.QMatchingInfoEntity.matchingInfoEntity;
import static com.bewithme.data.type.StatCode.*;
import static com.querydsl.core.types.Projections.constructor;

import java.util.List;
import java.util.stream.Collectors;

import com.bewithme.app.mate.model.MateDto;
import com.bewithme.app.mate.model.MateDto.Mate;
import com.bewithme.data.entity.MatchingInfoEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.type.StatCode;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MatchingInfoRepositoryImpl implements MatchingInfoRepositoryCustom{

	private final JPAQueryFactory jpaQueryFactory;

	private List<MatchingInfoEntity> findMyMates(Long memberId) {
		 return jpaQueryFactory.select(matchingInfoEntity)
				.from(matchingInfoEntity)
				.where(matchingInfoEntity.requester.id.eq(memberId)
						.or(matchingInfoEntity.requestee.id.eq(memberId))
						.and(matchingInfoEntity.stat.eq(C01.getCode())))
				.fetch();
	}

	public List<Long> findMyMateMemberId(Long id) {
		return findMyMates(id)
				.stream()
				.map(e -> e.getRequestee().getId().equals(id) ? e.getRequester().getId() : e.getRequestee().getId())
				.collect(Collectors.toList());
	}

	public List<MateDto> findMyMateInfo(Long memberId) {
		var list = jpaQueryFactory.select(constructor(MateDto.class,
						matchingInfoEntity.id, Expressions.asString("").as("nickname"),
						matchingInfoEntity.stat,
						constructor(Mate.class, matchingInfoEntity.requester.id, matchingInfoEntity.requester.nickname),
						constructor(Mate.class, matchingInfoEntity.requestee.id, matchingInfoEntity.requestee.nickname)
						))
				.from(matchingInfoEntity)
				.where(matchingInfoEntity.requester.id.eq(memberId)
						.or(matchingInfoEntity.requestee.id.eq(memberId))
						.and(matchingInfoEntity.stat.in(C01.getCode(), C02.getCode())))
				.fetch();
		 list.stream().forEach(e -> {
			 var mate = e.getRequestee().getId().equals(memberId) ? e.getRequester() : e.getRequestee();
			 e.setNickname(mate.getNickname());
			 e.setStat(StatCode.valueOf(e.getStat()).getMatchCode());
		 });
		 return list;
	}

}
