package com.bewithme.app.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bewithme.app.auth.dto.UserDetails;
import com.bewithme.app.member.model.MemberInfoDto;
import com.bewithme.app.member.service.MemberService;
import com.bewithme.data.entity.MemberBasicEntity;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {
	
	private final MemberService memberService;
	
	@GetMapping
	public MemberInfoDto getMemberInfo(@AuthenticationPrincipal UserDetails member) {
		MemberBasicEntity memberBasic = member.getUser().getMemberBasic();
		return new MemberInfoDto(memberBasic);
	}
	
	@PutMapping
	public ResponseEntity<Void> updateMemberInfo(@AuthenticationPrincipal UserDetails member, MemberInfoDto memberInfoDto) {
		memberService.updateMemberInfo(member.getUser().getId(), memberInfoDto);
		return ResponseEntity.accepted().build();
	}
}