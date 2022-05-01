package com.bewithme.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bewithme.data.entity.GameCharacterEntity;

public interface GameCharacterRepository extends JpaRepository<GameCharacterEntity, Long>{

}
