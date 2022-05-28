package com.bewithme.data.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ServerBag {
	
	STEAM("STEAM", "스팀"), 
	KAKAO("KAKAO", "카카오");
	
	private String code;
	private String desc;
	
}
