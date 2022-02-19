package com.bewithme.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatCode {
	
	C00("C00", "취소", "탈퇴"), 
	C01("C01", "승인", "정상"), 
	C02("C02", "대기", "휴면");
	
	private String code;
	private String matchCode;
	private String accountCode;
}
