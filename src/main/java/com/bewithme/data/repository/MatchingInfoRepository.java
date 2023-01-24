package com.bewithme.data.repository;

import com.bewithme.data.entity.MemberBasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bewithme.data.entity.MatchingInfoEntity;

import java.util.List;
import java.util.Optional;

public interface MatchingInfoRepository extends JpaRepository<MatchingInfoEntity, Long>, MatchingInfoRepositoryCustom{
    Optional<MatchingInfoEntity> findByRequesterAndRequesteeAndStat(MemberBasicEntity requester, MemberBasicEntity requestee, String stat);
}
