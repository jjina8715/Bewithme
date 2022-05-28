package com.bewithme.app.member.service;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bewithme.app.auth.dto.UserDto;
import com.bewithme.app.member.model.MemberInfoDto;
import com.bewithme.data.entity.MemberAuthEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.repository.MemberAuthRepository;
import com.bewithme.data.repository.MemberBasicRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private MemberAuthRepository memberAuthRepo;
	private MemberBasicRepository memberBasicRepo;
	private final PasswordEncoder passwordEncoder;

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
	public void memberAuthEntity(@Valid UserDto userDto) {
		
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		MemberAuthEntity user = userDto.toEntity();
		
		return memberAuthRepo.save(user);
	}
}
