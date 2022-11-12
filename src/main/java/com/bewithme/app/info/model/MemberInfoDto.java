package com.bewithme.app.info.model;

import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.type.Gender;

import javassist.NotFoundException;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberInfoDto {

	private Long id;
	private String nickname;
	private String name;
	private String gender;
	private String birth;
	private String phoneNumber;
	private String aboutMe;
	private String discordUrl;
	
	//description
	private String genderDesc;
	
	@Builder
	public MemberInfoDto(Long id, String name, String nickname, String gender, String birth,
			String aboutMe, String discordUrl, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.genderDesc = Gender.valueOf(gender).getDesc();
		this.birth = birth;
		this.aboutMe = aboutMe;
		this.discordUrl = discordUrl;
		this.phoneNumber = phoneNumber;
	}
	
	public MemberInfoDto(MemberBasicEntity memberBasic) throws NotFoundException {
		this.id = memberBasic.getId();
		this.name = memberBasic.getName();
		this.nickname = memberBasic.getNickname();
		this.gender = memberBasic.getGender();
		this.genderDesc = Gender.of(gender).getDesc();
		this.birth = memberBasic.getBirth();
		this.aboutMe = memberBasic.getAboutMe();
		this.discordUrl = memberBasic.getDiscordUrl();
		this.phoneNumber = memberBasic.getPhoneNumber();
	}
}