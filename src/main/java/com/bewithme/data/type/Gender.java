package com.bewithme.data.type;

import com.fasterxml.jackson.annotation.JsonFormat;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.thymeleaf.util.StringUtils;

import java.util.Arrays;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {

	MALE("m", "male"),
	FEMALE("f", "female"),
	ETC("e", "etc");
	
	private String code;
	private String desc;
	
	public static Gender of(String code) throws NotFoundException {
		return Arrays.stream(values()).filter(e -> StringUtils.equals(e.code, code))
				.findFirst().orElseThrow(() -> new NotFoundException(code));
	}
}
