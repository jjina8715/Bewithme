package com.bewithme.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "user_game_info_bag")
public class UserGameInfoBagEntity {
	@OneToOne(fetch = FetchType.LAZY)
	@Column(name = "user_id")
	private MemberBasicEntity memberBasic;

	@Id
	@Column(name = "nickname", length = 16)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String nickname;
	
	@Column(name = "tier", columnDefinition = "char(4)")
	private String tier;

	@Column(name = "rp")
	private Integer rp;

	@Column(name = "server", columnDefinition = "char(4)")
	private String server;

	@Column(name = "game_type", columnDefinition = "char(4)")
	private String game_type;
}
