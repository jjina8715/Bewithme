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
@Table(name = "game_character")
public class GameCharacterEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "game", length = 10, nullable = false)
	private String game;

	@Column(name = "character_name", length = 30)
	private String characterName;

	@Column(name = "character_image_path", length = 255)
	private String gameImagePath;
}