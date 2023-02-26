package com.bewithme.app.info.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bewithme.app.auth.dto.UserDto;
import com.bewithme.app.info.model.MemberWishDto;
import com.bewithme.data.entity.MateWishEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.repository.MateWishRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class WishService {

	private final MateWishRepository mateWishRepo;

	@Transactional(readOnly = true)
	public MemberWishDto getByMember(MemberBasicEntity member) {
		MateWishEntity mateWish = mateWishRepo.findByMemberBasic(member).orElse(new MateWishEntity());
		return new MemberWishDto(mateWish);
	}

//	@Transactional
//	public void createMemberwish(MemberBasicEntity memberBasic, MemberWishDto memberWishDto) throws Exception {
//		mateWishRepo.save(memberWishDto.toEntity(memberBasic));
//	}
	
	@Transactional
	public void createMemberwish(MemberBasicEntity memberBasic, UserDto userDto) throws Exception {

log.info("userDto={}",userDto.toString());
log.info("member={}",memberBasic);
		var mateWish = userDto.toWishEntity(memberBasic);
log.info("mateWish={}",mateWish.toString());
		mateWishRepo.save(mateWish);
	}
	
	@Transactional
	public void updateMemberwish(MemberBasicEntity memberBasic, MemberWishDto memberWishDto) throws Exception {
		memberWishDto.updateMemberWish(memberWishDto);
	}
}
