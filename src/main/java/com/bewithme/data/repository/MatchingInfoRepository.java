package com.bewithme.data.repository;

import com.bewithme.data.entity.MemberBasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bewithme.data.entity.MatchingInfoEntity;

import java.util.List;

public interface MatchingInfoRepository extends JpaRepository<MatchingInfoEntity, Long>, MatchingInfoRepositoryCustom{

}
