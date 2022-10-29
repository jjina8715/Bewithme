package com.bewithme.data.type;

import java.util.Arrays;
import java.util.function.Function;

import com.bewithme.app.info.model.MemberGameInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.thymeleaf.util.StringUtils;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Game {
	
	LOL("league of legends", "리그 오브 레전드", 
			s -> String.format("%s", s.getGameType())),
	BAG("battlegrounds", "배틀그라운드",  
			s -> String.format("%s", s.getGameType()));
	
	private String engName;
	private String korName;
	private Function<MemberGameInfo, String> gameComment;
	
	public String getCode() {
		return this.name();
	}

	public static Game of(String code) throws NotFoundException {
		return Arrays.stream(values())
				.filter(e -> StringUtils.equals(e.getCode(), code))
				.findFirst()
				.orElseThrow(() -> new NotFoundException(code));
	}

}
