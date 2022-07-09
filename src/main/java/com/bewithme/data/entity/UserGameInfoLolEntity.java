package com.bewithme.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_game_info_lol")
public class UserGameInfoLolEntity {
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private MemberBasicEntity memberBasic;

	@Id
	@Column(name = "summoner_id", length = 30)
	private String summonerId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "characer_id")
	private GameCharacterEntity gameCharacter;
	
	@Column(name = "role", columnDefinition = "char(4)")
	private String role;

	@Column(name = "position", columnDefinition = "char(4)")
	private String position;
	
	@Column(name = "level")
	private Integer level;

	@Column(name = "tier", columnDefinition = "char(4)")
	private String server;

	@Column(name = "game_type", columnDefinition = "char(4)")
	private String game_type;
}