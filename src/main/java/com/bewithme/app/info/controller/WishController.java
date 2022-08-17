package com.bewithme.app.info.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bewithme.app.info.model.MemberWishDto;

@RequestMapping("/info/wish")
@Controller
public class WishController {
	
	//private final MemberService memberService;
	
	@GetMapping
	public String getWish() {
		return "wish";
	}
	
	@PostMapping
	public String createWish(@Valid MemberWishDto wishDto) {
		return "index";
	}
}
