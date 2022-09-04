package com.bewithme.data.type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BagServer {
	
	STEAM("STEAM", "스팀"), 
	KAKAO("KAKAO", "카카오");
	
	private String code;
	private String desc;
	
}
