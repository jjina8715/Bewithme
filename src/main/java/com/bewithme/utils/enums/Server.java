package com.bewithme.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Server {
	
	SERVER_B01("STEAM", "스팀"), 
	SERVER_B02("KAKAO", "카카오");
	
	private String code;
	private String desc;
	
}
