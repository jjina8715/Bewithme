package com.bewithme.data.type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LolTier {
	
	TIER_L01("IRON","아이언"),
	TIER_L02("BRONZE","브론즈"),
	TIER_L03("SILVER","실버"),
	TIER_L04("GOLD","골드"),
	TIER_L05("PLATINUM","플래티넘"),
	TIER_L06("DIAMOND","다이아"),	
	TIER_L07("MASTER","마스터"),
	TIER_L08("GRANDMASTER","그랜드마스터"),
	TIER_L09("CHALLENGER","챌린저");
	
	private String code;
	private String desc;
}
