package com.bewithme.data.type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RoleLol {
	
	TANK("TANK", "탱커"), 
	MARKSMAN("MARKSMAN", "원딜"),  
	CONTROLLER("CONTROLLER", "서포트"),
	MAGE("MAGE", "마법사"),
	SLAYER("SLAYER","암살자"),
	FIGHTER("FIGHTER","전사");
	
	private String code;
	private String desc;
}
