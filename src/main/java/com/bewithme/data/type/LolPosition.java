package com.bewithme.data.type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LolPosition {
	
	TOP("TOP", "탑"), 
	MID("MID", "미드"),  
	BOTTOM("BOTTOM", "바텀"),
	JUNGLE("JUNGLE", "정글");
	
	private String code;
	private String desc;
}
