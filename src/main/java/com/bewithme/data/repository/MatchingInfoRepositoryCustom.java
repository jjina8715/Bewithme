package com.bewithme.data.repository;

import com.bewithme.data.entity.MemberBasicEntity;

import java.util.List;

public interface MatchingInfoRepositoryCustom {

	List<Long> findMyMateId(Long id);
	List<MemberBasicEntity> findMyMateInfo(Long id);
}