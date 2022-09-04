package com.bewithme.data.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberBasicRepositoryImpl implements MemberBasicRepositoryCutom{

	private final JPAQueryFactory jpaQueryFactory;
	

}
