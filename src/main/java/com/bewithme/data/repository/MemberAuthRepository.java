package com.bewithme.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bewithme.data.entity.MemberAuthEntity;

public interface MemberAuthRepository extends JpaRepository<MemberAuthEntity, Long>{

	Optional<MemberAuthEntity> findByAuthId(String authId);

}
