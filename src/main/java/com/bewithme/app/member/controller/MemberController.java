package com.bewithme.app.member.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.bewithme.app.configuration.security.UserDetails;
import com.bewithme.app.member.model.MemberCondition;
import com.bewithme.app.member.model.MemberInfoDto;
import com.bewithme.app.member.service.MemberService;
import com.bewithme.data.entity.MemberBasicEntity;

@Controller()
public class MemberController {
	
	private MemberService memberService;
	
	@GetMapping("/members")
	public List<MemberInfoDto> getMembersInfo(MemberCondition memberCondition) {
		return memberService.readItems(memberCondition);
	}
	
	@GetMapping("/member")
	public MemberInfoDto getMemberInfo(@AuthenticationPrincipal UserDetails member) {
		MemberBasicEntity memberBasic = member.getUser().getMemberBasic();
		MemberInfoDto memberInfo = MemberInfoDto.builder()
				.aboutMe(memberBasic.getAboutMe())
				.accessTime(memberBasic.getAccessTime())
				.birth(memberBasic.getBirth())
				.discordUrl(memberBasic.getDiscordUrl())
				.gender(memberBasic.getGender().toString())
				.name(memberBasic.getName())
				.nickname(memberBasic.getNickname())
				.phoneNumber(memberBasic.getPhoneNumber())
				.build();
		return memberInfo;
	}
	
	@PutMapping("/member")
	public ResponseEntity<String> updateMemberInfo(@AuthenticationPrincipal UserDetails member, MemberInfoDto memberInfoDto) {
		memberService.updateMemberInfo(member.getUser().getId(), memberInfoDto);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
}
