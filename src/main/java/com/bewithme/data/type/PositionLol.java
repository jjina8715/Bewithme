package com.bewithme.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PositionLol {
	
	POSITION_L01("TOP", "탑"), 
	POSITION_L02("MID", "미드"),  
	POSITION_L03("BOTTOM", "바텀"),
	POSITION_L04("JUNGLE", "정글");
	
	private String code;
	private String desc;
}
