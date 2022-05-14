package com.bewithme.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PositionLol {
	
	TOP("TOP", "탑"), 
	MID("MID", "미드"),  
	BOTTOM("BOTTOM", "바텀"),
	JUNGLE("JUNGLE", "정글");
	
	private String code;
	private String desc;
}
