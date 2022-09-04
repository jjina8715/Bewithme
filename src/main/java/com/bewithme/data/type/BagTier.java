package com.bewithme.data.type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BagTier {

	TIER_B01("BRONZE","브론즈"),
	TIER_B02("SILVER","실버"),
	TIER_B03("GOLD","골드"),
	TIER_B04("PLATINUM","플랫티넘"),
	TIER_B05("DIAMOND","다이아"),
	TIER_B06("CROWN","크라운"),
	TIER_B07("ACE","에이스"),
	TIER_B08("CONQUEROR","정복자");
	
	private String code;
	private String desc;
}
