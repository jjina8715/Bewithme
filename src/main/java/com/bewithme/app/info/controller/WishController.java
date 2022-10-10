package com.bewithme.app.info.controller;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bewithme.app.auth.dto.UserDetails;
import com.bewithme.app.info.model.MemberWishDto;
import com.bewithme.app.info.service.WishService;

@RequestMapping("/info/wish")
@Controller
public class WishController {
	
	private final WishService wishService;
	
	@GetMapping()
	public MemberWishDto getWish(@AuthenticationPrincipal UserDetails member) {
		var authId = member.getUser().getMemberBasic();
		return wishService.getByMember(member);
	}
	
	@PutMapping()
	public String createWish(@Valid MemberWishDto memberWishDto) {
		MemberWishDto memberWish = memberWishDto;
		
		return "index";
	}
	
	@GetMapping
	public MemberInfoDto getMemberInfo(@AuthenticationPrincipal UserDetails member) {
		var memberBasic = member.getUser().getMemberBasic();
		var memberInfo = new MemberInfoDto(memberBasic);
		memberInfo.setEmail(member.getUsername());
		return memberInfo;
	}
}
