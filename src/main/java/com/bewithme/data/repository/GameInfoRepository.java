package com.bewithme.data.repository;

import com.bewithme.data.entity.GameInfoEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameInfoRepository extends JpaRepository<GameInfoEntity, Long> {
    Optional<GameInfoEntity> findByMemberBasic(MemberBasicEntity memberBasic);
}
