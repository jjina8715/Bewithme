package com.bewithme.data.repository;

import static com.bewithme.data.entity.QMemberAuthEntity.memberAuthEntity;
import static com.bewithme.data.entity.QMemberBasicEntity.memberBasicEntity;

import java.util.List;

import com.bewithme.app.member.model.MemberCondition;
import com.bewithme.app.member.model.MemberInfoDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberAuthRepositoryImpl implements MemberAuthRepositoryCutom{

	private final JPAQueryFactory jpaQueryFactory;
	
	@Override
	public List<MemberInfoDto> readItems(MemberCondition memberCondition) {
		return jpaQueryFactory.select(Projections.bean(MemberInfoDto.class, 
				memberBasicEntity.id,
				memberBasicEntity.nickname,
				memberBasicEntity.gender,
				memberBasicEntity.accessTime,
				memberBasicEntity.aboutMe,
				memberBasicEntity.discordUrl
			))
			.from(memberAuthEntity, memberBasicEntity)
			.where(memberBasicEntity.id.eq(memberCondition.getId()))
			.fetch();
	}

}
