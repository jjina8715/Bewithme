package com.bewithme.data.type;

import java.util.function.Function;

import com.bewithme.app.info.model.MemberGameInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Game {
	
	LOL("league of legends", "리그 오브 레전드", 
			s -> {return String.format("%s", s.getGameType());}),
	BAG("battlegrounds", "배틀그라운드",  
			s -> {return String.format("%s", s.getGameType());});
	
	private String engName;
	private String korName;
	private Function<MemberGameInfo, String> gameComment;
	
	public String getCode() {
		return this.name();
	}
}
