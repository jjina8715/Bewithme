package com.bewithme.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@Entity
public class MemberBasicEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 30)
	private String name;

	@Column(name = "nickname", nullable = false, length = 15)
	private String nickname;

	@Column(name = "gender", nullable = false, columnDefinition = "char(1)")
	private Character gender;

	@Column(name = "birth", columnDefinition = "char(8)")
	private String birth;

	@Column(name = "access_time", columnDefinition = "char(4)")
	private String accessTime;

	@Column(name = "about_me", length = 100)
	private String aboutMe;

	@Column(name = "discord_url", length = 255)
	private String discordUrl;

	@Column(name = "phone_number", columnDefinition = "char(11)")
	private String phoneNumber;

	@Column(name = "last_login")
	private LocalDateTime lastLogin;
}
