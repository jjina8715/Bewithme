package com.bewithme.data.type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Game {
	
	LOL("league of legends", "리그 오브 레전드"),
	BAG("battlegrounds", "배틀그라운드");
	
	private String engName;
	private String korName;
	
	public String getCode() {
		return this.name();
	}
}
