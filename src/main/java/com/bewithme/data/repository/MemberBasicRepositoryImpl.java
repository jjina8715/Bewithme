package com.bewithme.data.repository;

import static com.bewithme.data.entity.QMemberBasicEntity.memberBasicEntity;
import static com.bewithme.data.entity.QMatchingInfoEntity.matchingInfoEntity;

import java.util.List;

import com.bewithme.app.mate.model.MateInfoDto;
import com.bewithme.app.member.model.MemberCondition;
import com.bewithme.data.type.StatCode;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberBasicRepositoryImpl implements MemberBasicRepositoryCutom{

	private final JPAQueryFactory jpaQueryFactory;
	
	@Override
	public List<MateInfoDto> readItems(MemberCondition memberCondition) {
		return jpaQueryFactory.select(Projections.bean(MateInfoDto.class, 
				memberBasicEntity.id,
				memberBasicEntity.nickname,
				memberBasicEntity.gender,
				memberBasicEntity.accessTime,
				memberBasicEntity.aboutMe,
				memberBasicEntity.discordUrl
			))
			.from(memberBasicEntity, matchingInfoEntity)
			.where(memberBasicEntity.id.eq(matchingInfoEntity.requestee.id)
					.and(matchingInfoEntity.requester.id.eq(memberBasicEntity.id))
					.and(matchingInfoEntity.stat.eq(StatCode.C01.getCode()))
			)
			.orderBy(matchingInfoEntity.createdDate.asc())
			.fetch();
	}
}
