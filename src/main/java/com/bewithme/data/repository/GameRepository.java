package com.bewithme.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bewithme.data.entity.GameEntity;

public interface GameRepository extends JpaRepository<GameEntity, Integer>{
	
}
