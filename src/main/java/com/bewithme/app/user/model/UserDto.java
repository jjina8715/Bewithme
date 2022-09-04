package com.bewithme.app.user.model;

import com.bewithme.data.entity.MemberBasicEntity;

import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {

	private Long id;
	private String name;
	private String nickname;
	
	
	@Builder
	public UserDto(Long id, String name, String nickname) {
		this.id = id;
		this.name = name;
		this.nickname = nickname;

	}
	
	public UserDto(MemberBasicEntity memberBasic) {
		this.id = memberBasic.getId();
		this.name = memberBasic.getName();
		this.nickname = memberBasic.getNickname();
	}
}
