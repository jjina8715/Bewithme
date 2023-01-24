package com.bewithme.app.info.controller;

import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bewithme.app.auth.dto.UserDetails;
import com.bewithme.app.info.model.MemberInfoDto;
import com.bewithme.app.info.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/info")
@RequiredArgsConstructor
public class InfoController {
	
	private final MemberService memberService;
	
	@GetMapping
	@ResponseBody
	public MemberInfoDto getMemberInfo(@AuthenticationPrincipal UserDetails member) throws NotFoundException {
		return memberService.getMemberInfo(member.getUser().getMemberBasic().getId());
	}
	
	@PutMapping
	@ResponseBody
	public ResponseEntity<Void> updateMemberInfo(@AuthenticationPrincipal UserDetails member, @RequestBody MemberInfoDto memberInfoDto) {
		memberService.updateMemberInfo(member.getUser().getId(), memberInfoDto);
		return ResponseEntity.accepted().build();
	}
}