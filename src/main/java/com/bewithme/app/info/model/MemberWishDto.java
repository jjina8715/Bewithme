package com.bewithme.app.info.model;

import com.bewithme.data.entity.MateWishEntity;

import lombok.Builder;
import lombok.Data;

@Data
public class MemberWishDto {
	private Long id;
	private String gender;
	private String ageGroup;
	private String accessTime;
	private String gameType;
	
	@Builder
	public MemberWishDto(Long id, String gender, String ageGroup, String accessTime, String gameType) {
		this.id = id;
		this.gender = gender;
		this.ageGroup = ageGroup;
		this.accessTime = accessTime;
		this.gameType = gameType;
	}
	public MemberWishDto(MateWishEntity mateWish) {
		this.id = mateWish.getId();
		this.gender = mateWish.getGender();
		this.ageGroup = mateWish.getAgeGroup();
		this.accessTime = mateWish.getAcessTime();
		this.gameType = mateWish.getGameType();
	}
}