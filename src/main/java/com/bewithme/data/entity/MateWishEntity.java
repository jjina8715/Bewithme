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

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Builder
@Data
@EqualsAndHashCode(of = { "id" })
@Table(name = "mate_wish")
public class MateWishEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private MemberBasicEntity memberBasic;

	@Column(name = "gender", columnDefinition = "char(1)")
	private String gender;

	@Column(name = "age_group", columnDefinition = "char(4)")
	private String ageGroup;

	@Column(name = "access_time", columnDefinition = "char(4)")
	private String acessTime;

	@Column(name = "game_type", length = 255)
	private String gameType;
}
