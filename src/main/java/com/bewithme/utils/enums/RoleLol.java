package com.bewithme.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleLol {
	
	ROLE_L01("TANK", "탱커"), 
	ROLE_L02("MARKSMAN", "원딜"),  
	ROLE_L03("SUPPORT", "서포트");
//	ROLE_L04("MAGE", ""),
//	ROLE_L05("Assassin",""),
//	ROLE_L06("FIGHTER","")
	
	private String code;
	private String desc;
}
