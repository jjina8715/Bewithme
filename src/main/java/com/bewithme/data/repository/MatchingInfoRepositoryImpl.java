package com.bewithme.data.repository;


import static com.bewithme.data.entity.QMatchingInfoEntity.matchingInfoEntity;
import static com.bewithme.data.type.StatCode.*;

import java.util.List;
import java.util.stream.Collectors;

import com.bewithme.app.mate.model.MateDto;
import com.bewithme.data.entity.MatchingInfoEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MatchingInfoRepositoryImpl implements MatchingInfoRepositoryCustom{

	private final JPAQueryFactory jpaQueryFactory;

	public List<MatchingInfoEntity> findMyMates(Long memberId) {
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
		return findMyMates(memberId)
				.stream()
				.map(e -> {
					var mateBasic = e.getRequestee().getId().equals(memberId) ? e.getRequester() : e.getRequestee();
					return new MateDto(e.getId(), mateBasic.getNickname());
				}).collect(Collectors.toList());
	}
}
