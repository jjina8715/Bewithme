package com.bewithme.data.type;

import lombok.Getter;

@Getter
public enum Role {
	
	ROLE_ADMIN("관리자"), 
	ROLE_USER("사용자"); 

	Role(String description) {
		this.description = description;
	}

	private String description;

}
