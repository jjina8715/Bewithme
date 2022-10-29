package com.bewithme.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Entity
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "game_info")
public class GameInfoEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private MemberBasicEntity memberBasic;
	
	@Column(name = "game", length = 10, nullable = false)
	private String game;

	@Column(name = "comment", nullable = false, length = 255)
	private String comment;

	public GameInfoEntity() {

	}
}
