package com.bewithme.data.repository;

import com.bewithme.app.mate.model.MateDto;
import com.bewithme.data.entity.MatchingInfoEntity;

import java.util.List;

public interface MatchingInfoRepositoryCustom {
	List<Long> findMyMateMemberId(Long id);
	List<MateDto> findMyMateInfo(Long id);
}