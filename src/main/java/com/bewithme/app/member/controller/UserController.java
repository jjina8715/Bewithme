package com.bewithme.app.member.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bewithme.app.configuration.security.UserDetails;
import com.bewithme.app.member.model.MemberCondition;
import com.bewithme.app.member.model.MemberInfoDto;
import com.bewithme.app.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller("user")
@RequiredArgsConstructor
public class UserController {

	private final MemberService memberService;
	@GetMapping
	public List<MemberInfoDto> findUsers(@AuthenticationPrincipal UserDetails member, MemberCondition condition) {
		
		return memberService.findUsers(member.getUser().getMemberBasic().getId(), condition);
	}
}
