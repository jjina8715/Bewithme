package com.bewithme.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bewithme.data.entity.MemberBasicEntity;

public interface MemberBasicRepository extends JpaRepository<MemberBasicEntity, Long>{

}