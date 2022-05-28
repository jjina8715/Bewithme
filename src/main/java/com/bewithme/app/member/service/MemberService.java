package com.bewithme.app.member.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bewithme.app.member.model.MemberCondition;
import com.bewithme.app.member.model.MemberInfoDto;
import com.bewithme.data.entity.MemberAuthEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.entity.mapper.MemberAuthMapper;
import com.bewithme.data.repository.MemberAuthRepository;
import com.bewithme.data.repository.MemberBasicRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberAuthRepository memberAuthRepo;
	private final MemberBasicRepository memberBasicRepo;
	private final MemberAuthMapper memberAuthMapper;
	
	public List<MemberInfoDto> readItems(MemberCondition memberCondition) {
		List<MemberAuthEntity> list = memberAuthRepo.findAll();
		return list.stream().map(memberAuthMapper::toDto).collect(Collectors.toList());
	}

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
