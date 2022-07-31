package com.bewithme.app.user.model;

import lombok.Data;

@Data
public class UserDetailDto<T> {
	private Long id;
	private String name;
	private String nickname;
	private String gender;
	private String birth;
	private String aboutMe;
	private String discordUrl;
	private String phoneNumber;
	
	//description
	private String genderDesc;
	private T gameInfo;
}
