package com.bewithme.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

	MALE("m", "남성"),
	FEMALE("f", "여성");
	
	private String code;
	private String desc;
}
