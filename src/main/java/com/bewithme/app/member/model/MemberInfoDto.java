package com.bewithme.app.member.model;

import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.type.Gender;

import lombok.Builder;
import lombok.Data;

@Data
public class MemberInfoDto {

	private Long id;
	private String name;
	private String nickname;
	private String gender;
	private String birth;
	private String aboutMe;
	private String discordUrl;
	private String phoneNumber;
	
	
	
	//description
	private Gender genderDesc;
	
	public Gender getGenderDesc() {
		return Gender.valueOf(gender);
	}
	
	@Builder
	public MemberInfoDto(Long id, String name, String nickname, String gender, String birth, 
			String aboutMe, String discordUrl, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.birth = birth;
		this.aboutMe = aboutMe;
		this.discordUrl = discordUrl;
		this.phoneNumber = phoneNumber;
	}
	
	public MemberInfoDto(MemberBasicEntity memberBasic) {
		this.id = memberBasic.getId();
		this.name = memberBasic.getName();
		this.nickname = memberBasic.getNickname();
		this.gender = memberBasic.getGender();
		this.birth = memberBasic.getBirth();
		this.aboutMe = memberBasic.getAboutMe();
		this.discordUrl = memberBasic.getDiscordUrl();
		this.phoneNumber = memberBasic.getPhoneNumber();
	}
}
