package com.bewithme.app.auth.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bewithme.app.auth.dto.UserDto;
import com.bewithme.app.info.service.MemberService;
import com.bewithme.common.exception.UserAlreadyExistsException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class AuthContoller{
	
	private final MemberService memberService;
	
	@RequestMapping("/signin")
	public String loginForm() {
		return "signin";
	}
	
	@GetMapping("/signup")
	public String dispSignup() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid UserDto userDto, BindingResult errors) {
		if(errors.hasErrors()) {
            return "signup";
        }

		try {
			memberService.createMember(userDto);
		} catch (UserAlreadyExistsException e) {
			errors.addError(new ObjectError("error_email", e.getMessage()));
		}
		return "signin";
	}
}