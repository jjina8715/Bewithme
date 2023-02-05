package com.bewithme.app.info.model;

import com.bewithme.data.entity.MateWishEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.type.Gender;
import com.bewithme.data.type.StatCode;

import javassist.NotFoundException;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberWishDto {
	private Long id;
	private String gender;
	private String ageGroup;
	private String accessTime;
	private String gameType;
	
	@Builder
	public MemberWishDto(Long id, String gender, String ageGroup, String accessTime, String gameType) {
		this.id = id;
		this.gender = gender;
		this.ageGroup = ageGroup;
		this.accessTime = accessTime;
		this.gameType = gameType;
	}
	public MemberWishDto(MateWishEntity mateWish) {
		this.id = mateWish.getId();
		this.gender = mateWish.getGender();
		this.ageGroup = mateWish.getAgeGroup();
		this.accessTime = mateWish.getAccessTime();
		this.gameType = mateWish.getGameType();
	}
	
	public MateWishEntity toEntity(MemberBasicEntity memberBasic) throws Exception{
		return MateWishEntity.builder()
				.memberBasic(memberBasic)
				.gender(Gender.ofName(gender).getCode())				
				.ageGroup(ageGroup)
				.accessTime(accessTime)
				.gameType(gameType)
				.build();
	}
	public void updateMemberWish(MemberWishDto memberWishDto) {
		this.gender = memberWishDto.getGender();
		this.ageGroup = memberWishDto.getAgeGroup();
		this.accessTime = memberWishDto.getAccessTime();
		this.gameType = memberWishDto.getGameType();
	}

}