package com.bewithme.app.info.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bewithme.app.info.model.MemberInfoDto;
import com.bewithme.app.info.model.MemberWishDto;
import com.bewithme.data.entity.MateWishEntity;
import com.bewithme.data.entity.MemberAuthEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.repository.MateWishRepository;
import com.bewithme.data.repository.MemberBasicRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class WishService {

	private final MateWishRepository mateWishRepo;

	@Transactional(readOnly = true)
	public MemberWishDto getByMember(MemberBasicEntity member) {
		MateWishEntity mateWish = mateWishRepo.findByMemberBasic(member);
		return new MemberWishDto(mateWish);
	}

	@Transactional
	public void createMemberwish(MemberBasicEntity memberBasic, MemberWishDto memberWishDto) throws Exception {
		mateWishRepo.save(memberWishDto.toEntity(memberBasic));
	}
	
	@Transactional
	public void updateMemberwish(MemberBasicEntity memberBasic, MemberWishDto memberWishDto) throws Exception {
		memberWishDto.updateMemberWish(memberWishDto);
	}
}
