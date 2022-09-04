package com.bewithme.data.repository;


import static com.bewithme.data.entity.QMatchingInfoEntity.matchingInfoEntity;

import java.util.List;
import java.util.stream.Collectors;

import com.bewithme.data.entity.MatchingInfoEntity;
import com.bewithme.data.type.StatCode;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MatchingInfoRepositoryImpl implements MatchingInfoRepositoryCustom{

	private final JPAQueryFactory jpaQueryFactory;

	public List<Long> findMyMate(Long id) {
		List<MatchingInfoEntity> matchingInfo = jpaQueryFactory.select(matchingInfoEntity)
				.from(matchingInfoEntity)
				.where(matchingInfoEntity.requester.id.eq(id)
						.or(matchingInfoEntity.requestee.id.eq(id))
						.and(matchingInfoEntity.stat.eq(StatCode.C01.getCode())))
				.fetch();
		
		return matchingInfo.stream()
				.map(e -> e.getRequestee().equals(id) ? e.getRequester().getId() : e.getRequestee().getId())
				.collect(Collectors.toList());
	}
}
