package com.bewithme.app.member.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bewithme.app.configuration.security.UserDetails;
import com.bewithme.app.member.model.MateInfoDto;
import com.bewithme.app.member.model.MemberCondition;
import com.bewithme.app.member.service.MatchingService;
import com.bewithme.app.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mates")
@RequiredArgsConstructor
public class MateController {

	private final MemberService memberService;
	private final MatchingService matchingService;
	
	@GetMapping
	public List<MateInfoDto> readMateInfo(MemberCondition memberCondition) {
		return memberService.readMateInfo(memberCondition);
	}
	
	@PostMapping("/want/{id}")
	public ResponseEntity<Void> requestMatching(@AuthenticationPrincipal UserDetails member, @PathVariable Long id) {
		matchingService.requestMatching(member.getUser().getMemberBasic(), id);
		return ResponseEntity.accepted().build();
	}
}
