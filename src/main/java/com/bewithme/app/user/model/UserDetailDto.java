package com.bewithme.app.user.model;

import lombok.Data;

@Data
public class UserDetailDto {
	private Long id;
	private String name;
	private String nickname;
	private String gender;
	private String birth;
	private String aboutMe;
	private String discordUrl;
	private GameInfo game;

	@Data
	public class GameInfo {
		private String gameName;
		private String comment;
	}
}
