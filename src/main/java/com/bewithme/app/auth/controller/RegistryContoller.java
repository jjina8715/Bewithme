package com.bewithme.app.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bewithme.data.entity.MemberAuthEntity;
import com.bewithme.data.repository.MemberAuthRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class RegistryContoller {
	
	private final MemberAuthRepository userRepo;
	// private final BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/signup")
	public String signupForm(Model model) {
		//model.addAtrribute("member", new MemberAuthEntity());
		return "signup";
	}
}