package com.bewithme.app.member.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bewithme.app.configuration.security.UserDetails;
import com.bewithme.app.member.model.MateInfoDto;
import com.bewithme.app.member.model.MemberCondition;
import com.bewithme.app.member.model.MemberInfoDto;
import com.bewithme.app.member.service.MatchingService;
import com.bewithme.app.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller("/mate")
@RequiredArgsConstructor
public class MateController {

	private final MemberService memberService;
	private final MatchingService matchingService;
	
	@GetMapping
	public List<MateInfoDto> readMateInfo(MemberCondition memberCondition) {
		return memberService.readMateInfo(memberCondition);
	}
	
	@PostMapping("/want/{id}")
	public MemberInfoDto requestMatching(@AuthenticationPrincipal UserDetails member, @PathVariable Long id) {
		return matchingService.requestMatching(member.getUser().getMemberBasic(), id);
	}
}
