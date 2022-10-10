package com.bewithme.app.info.model;

import com.bewithme.data.entity.MateWishEntity;
import com.bewithme.data.entity.MemberBasicEntity;

import lombok.Builder;
import lombok.Data;

@Data
public class MemberWishDto {
	private Long id;
	private String email;
	private String gender;
	private String ageGroup;
	private String accessTime;
	private String gameType;
	
	@Builder
	public MemberWishDto(Long id, String email, String gender, 
			String ageGroup, String accessTime, String gameType) {
		this.id = id;
		this.email = email;
		this.gender = gender;
		this.ageGroup = ageGroup;
		this.accessTime = accessTime;
		this.gameType = gameType;
	}
//todo
	public MemberWishDto(MateWishEntity mateWish) {
	}
}