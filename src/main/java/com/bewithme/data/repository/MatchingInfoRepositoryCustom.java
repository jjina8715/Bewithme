package com.bewithme.data.repository;

import java.util.List;

public interface MatchingInfoRepositoryCustom {
	
	List<Long> findMyMate(Long id);
}