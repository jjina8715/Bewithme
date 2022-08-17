package com.bewithme.app.info.model;

import lombok.Builder;
import lombok.Data;

@Data
public class MemberWishDto {
	private Long id;
	private String name;
	private String gender;
	private String ageGroup;
	private String accessTime;
	private String gameType;
	
	@Builder
	public MemberWishDto(Long id, String name, String gender, 
			String ageGroup, String accessTime, String gameType) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.ageGroup = ageGroup;
		this.accessTime = accessTime;
		this.gameType = gameType;
	}
}