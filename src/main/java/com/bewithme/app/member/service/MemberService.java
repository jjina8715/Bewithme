package com.bewithme.app.member.service;

import org.springframework.stereotype.Service;

import com.bewithme.app.member.model.MemberInfoDto;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.repository.MemberAuthRepository;
import com.bewithme.data.repository.MemberBasicRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private MemberAuthRepository memberAuthRepo;
	private MemberBasicRepository memberBasicRepo;
	

	public void updateMemberInfo(Long id, MemberInfoDto memberInfoDto) {
		MemberBasicEntity memberBasic = memberAuthRepo.getById(id).getMemberBasic();
		memberBasic.setNickname(memberInfoDto.getNickname());
		memberBasic.setGender(memberInfoDto.getGender());
		memberBasic.setBirth(memberInfoDto.getBirth());
		memberBasic.setAccessTime(memberInfoDto.getAccessTime());
		memberBasic.setAboutMe(memberInfoDto.getAboutMe());
		memberBasic.setDiscordUrl(memberInfoDto.getDiscordUrl());
		memberBasic.setPhoneNumber(memberInfoDto.getPhoneNumber());
		
		memberBasicRepo.save(memberBasic);
	}
	
}
