package com.bewithme.app.user.model;

import com.bewithme.data.entity.MemberBasicEntity;

import com.bewithme.data.type.Game;
import javassist.NotFoundException;
import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {

	private Long id;
	private String nickname;
	private String gameName;
	
	@Builder
	public UserDto(Long id, String gameName, String nickname) {
		this.id = id;
		this.gameName = gameName;
		this.nickname = nickname;

	}
	
	public UserDto(MemberBasicEntity memberBasic) {
		this.id = memberBasic.getId();
		this.nickname = memberBasic.getNickname();
		var game = Game.of(memberBasic.getFavoriteGame());
		this.gameName = game == null ? "" : game.getKorName();
	}
}
