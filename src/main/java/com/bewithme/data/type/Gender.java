package com.bewithme.data.type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {

	MALE("m", "male"),
	FEMALE("f", "female"),
	ETC("e", "etc");
	
	private String code;
	private String desc;
	
	public static Gender of(String gender) {
		for(var item: Gender.values()) {
			if(gender.toUpperCase().equals(item.name()))
				return item;
		}
		return ETC;
	}
}
