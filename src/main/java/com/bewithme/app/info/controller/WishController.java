package com.bewithme.app.info.controller;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bewithme.app.auth.dto.UserDetails;
import com.bewithme.app.info.model.MemberWishDto;
import com.bewithme.app.info.service.WishService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/info/wish")
@RestController
public class WishController {
	
	private final WishService wishService;
	
	@GetMapping("/{id}")
	public MemberWishDto getWish(@AuthenticationPrincipal UserDetails member) {
		var memberBasic = member.getUser().getMemberBasic();
		return wishService.getByMember(memberBasic);
	}
	
	@PostMapping
	public String postWish(@AuthenticationPrincipal UserDetails member, MemberWishDto memberWishDto) {
		
		var memberBasic = member.getUser().getMemberBasic();
		try {
		//wishService.createMemberwish(memberBasic, memberWishDto);
		}
		catch(Exception e) {
			log.error(e.getMessage());;
			return "";
		}
		return "" ;
	}
	
	@PutMapping
	public String putWish(@AuthenticationPrincipal UserDetails member, MemberWishDto memberWishDto) {
		var memberBasic = member.getUser().getMemberBasic();
		try {
		wishService.updateMemberwish(memberBasic, memberWishDto);
		}
		catch(Exception e) {
			return "";
		}
		return "" ;
	}
	
}
