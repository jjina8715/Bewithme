package com.bewithme.data.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bewithme.app.info.model.MemberInfoDto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "member_basic")
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
	private String gender;

	@Column(name = "birth", columnDefinition = "char(8)")
	private String birth;

	@Column(name = "access_time", columnDefinition = "char(4)")
	private String accessTime;

	@Column(name = "about_me", length = 100)
	private String aboutMe;

	@Column(name = "discord_url")
	private String discordUrl;

	@Column(name = "phone_number", columnDefinition = "char(11)")
	private String phoneNumber;

	@Column(name = "stat", columnDefinition = "char(4)")
	private String stat;
	
	@Column(name = "favorite_game", length = 10)
	private String favoriteGame;
	
	@Column(name = "last_login")
	private LocalDateTime lastLogin;
	
	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin=lastLogin;
	}
	
	@Builder
	public MemberBasicEntity(Long id, String name, String nickname, String gender, String birth, String accessTime, 
			String aboutMe, String discordUrl, String phoneNumber, String stat, String favoriteGame, LocalDateTime lastLogin) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.birth = birth;
		this.accessTime = accessTime;
		this.aboutMe = aboutMe;
		this.discordUrl = discordUrl;
		this.phoneNumber = phoneNumber;
		this.lastLogin = lastLogin;
		this.stat = stat;
		this.favoriteGame = favoriteGame;
	}
	
	public void updateMemberInfo(MemberInfoDto memberInfoDto) {
		this.nickname = memberInfoDto.getNickname();
		this.gender = memberInfoDto.getGender();
		this.birth = memberInfoDto.getBirth();
		this.aboutMe = memberInfoDto.getAboutMe();
		this.discordUrl = memberInfoDto.getDiscordUrl();
		this.phoneNumber = memberInfoDto.getPhoneNumber();
	}
	
}
