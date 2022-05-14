package com.bewithme.data.type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GameType {
	
	JEULGEM("TYPE_01", "즐겜"),
	PAKGEM("TYPE_02", "빡겜"),  
	YEOPO("TYPE_03", "여포"),
	JOHNVER("TYPE_04", "존버");
	
	private String code;
	private String desc;
}
