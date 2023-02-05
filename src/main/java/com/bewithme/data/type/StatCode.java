package com.bewithme.data.type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatCode {
	
	C00("C00", "취소", "탈퇴"),
	C01("C01", "승인", "정상"),
	C02("C02", "대기", "휴면");
	
	private String code;
	private String matchCode;
	private String accountCode;
}
