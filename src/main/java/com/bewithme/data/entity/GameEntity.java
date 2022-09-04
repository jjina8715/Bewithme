package com.bewithme.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(of = { "id" })
@Table(name = "game")
public class GameEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "game_name", length = 255, nullable = false)
	private String gameName;
	
	@Column(name = "game_image_path", length = 255)
	private String gameImagePath;
}