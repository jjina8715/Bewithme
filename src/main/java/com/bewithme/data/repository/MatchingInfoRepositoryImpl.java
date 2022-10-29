package com.bewithme.data.repository;


import static com.bewithme.data.entity.QMatchingInfoEntity.matchingInfoEntity;
import static com.bewithme.data.type.StatCode.*;

import java.util.List;
import java.util.stream.Collectors;

import com.bewithme.data.entity.MatchingInfoEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MatchingInfoRepositoryImpl implements MatchingInfoRepositoryCustom{

	private final JPAQueryFactory jpaQueryFactory;

	private List<MatchingInfoEntity> findMyMate(Long id) {
		 return jpaQueryFactory.select(matchingInfoEntity)
				.from(matchingInfoEntity)
				.where(matchingInfoEntity.requester.id.eq(id)
						.or(matchingInfoEntity.requestee.id.eq(id))
						.and(matchingInfoEntity.stat.eq(C01.getCode())))
				.fetch();
	}

	public List<Long> findMyMateId(Long id) {
		return findMyMate(id)
				.stream()
				.map(e -> e.getRequestee().equals(id) ? e.getRequester().getId() : e.getRequestee().getId())
				.collect(Collectors.toList());
	}

	public List<MemberBasicEntity> findMyMateInfo(Long id) {
		return findMyMate(id)
				.stream()
				.map(e -> e.getRequestee().equals(id) ? e.getRequester() : e.getRequestee())
				.collect(Collectors.toList());
	}
}
