package com.bewithme.app.member.model;

import com.bewithme.data.type.Gender;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberInfoDto {

	private String name;
	private String nickname;
	private String gender;
	private String birth;
	private String aboutMe;
	private String discordUrl;
	private String phoneNumber;
	private String accessTime;
	
	//description
	private Gender genderDesc;
	private String accessTimeDesc;
	
	public Gender getGenderDesc() {
		return Gender.valueOf(gender);
	}
	
	@Builder
	public MemberInfoDto(String name, String nickname, String gender, String birth, 
			String aboutMe, String discordUrl, String phoneNumber, String accessTime) {
	
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.birth = birth;
		this.aboutMe = aboutMe;
		this.discordUrl = discordUrl;
		this.phoneNumber = phoneNumber;
		this.accessTime = accessTime;
	}
}
