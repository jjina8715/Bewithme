package com.bewithme.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameType {
	
	TYPE_01("TYPE_01", "즐겜"), 
	TYPE_02("TYPE_02", "빡겜"),  
	TYPE_03("TYPE_03", "여포"),
	TYPE_04("TYPE_04", "존버");
	
	private String code;
	private String desc;
}
