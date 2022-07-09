package com.bewithme.app.member.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bewithme.app.member.model.MateInfoDto;
import com.bewithme.app.member.model.MemberCondition;
import com.bewithme.app.member.model.MemberInfoDto;
import com.bewithme.data.repository.MemberAuthRepository;
import com.bewithme.data.repository.MemberBasicRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberAuthRepository memberAuthRepo;
	private final MemberBasicRepository memberBasicRepo;
	
	public List<MateInfoDto> readMateInfo(MemberCondition memberCondition) {
		return memberBasicRepo.readItems(memberCondition);
	}

	public void updateMemberInfo(Long id, MemberInfoDto memberInfoDto) {
		var memberBasic = memberAuthRepo.getById(id).getMemberBasic();
		memberBasic.setNickname(memberInfoDto.getNickname());
		memberBasic.setGender(memberInfoDto.getGender());
		memberBasic.setBirth(memberInfoDto.getBirth());
		memberBasic.setAboutMe(memberInfoDto.getAboutMe());
		memberBasic.setDiscordUrl(memberInfoDto.getDiscordUrl());
		memberBasic.setPhoneNumber(memberInfoDto.getPhoneNumber());
		
		memberBasicRepo.save(memberBasic);
	}
	
	public List<MemberInfoDto> findUsers(Long id, MemberCondition condition) {
		
		return new ArrayList<>();
	}
}
