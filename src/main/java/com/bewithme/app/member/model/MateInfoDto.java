package com.bewithme.app.member.model;

import com.bewithme.data.type.Gender;

import lombok.Builder;
import lombok.Data;

@Data
public class MateInfoDto {
	private String id;
	private String nickname;
	private String gender;
	private String birth;
	private String aboutMe;
	private String discordUrl;
	private String accessTime;
	
	//description
	private Gender genderDesc;
	private String accessTimeDesc;
	
	public Gender getGenderDesc() {
		return Gender.valueOf(gender);
	}

	@Builder
	public MateInfoDto(String id, String nickname, String gender, String birth, 
			String aboutMe, String discordUrl, String accessTime) {
		this.id = id;
		this.nickname = nickname;
		this.gender = gender;
		this.birth = birth;
		this.aboutMe = aboutMe;
		this.discordUrl = discordUrl;
		this.accessTime = accessTime;
	}
}
