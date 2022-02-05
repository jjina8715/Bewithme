package com.bewithme.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bewithme.data.entity.MemberAuthEntity;

@Repository
public interface MemberAuthRepository extends JpaRepository<MemberAuthEntity, Integer>{

	Optional<MemberAuthEntity> findByAuthId(String authId);

}
