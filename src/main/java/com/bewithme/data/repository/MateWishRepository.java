package com.bewithme.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bewithme.data.entity.MateWishEntity;
import com.bewithme.data.entity.MemberAuthEntity;
import com.bewithme.data.entity.MemberBasicEntity;

public interface MateWishRepository extends JpaRepository<MateWishEntity, Long>{
	
	MateWishEntity findByMemberBasic(MemberBasicEntity member);

}
