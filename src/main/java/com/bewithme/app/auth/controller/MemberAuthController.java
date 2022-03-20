package com.bewithme.app.auth.controller;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
@Controller
public class MemberAuthController {
	
	private final UserDetailsService memeberService;

	@RequestMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String dispSignup() {
		return "signup";
	}
	
//	@PostMapping("/signup")
//	public String signup(@Valid UserDto userDto, BindingResult errors) {
//		if(errors.hasErrors()) {
//            //model.addAttribute("member", userDto);
//            //model.addAllAttributes(memAuthService.validateHandling(errors));
//            return "register";
//        }
//
//		try {
//	log.info("----------userDto : {}", userDto);
//			userService.signup(userDto);
//		} catch (UserAlreadyExistsException e) {
//			errors.addError(new ObjectError("error_email", e.getMessage()));
//		}
//		return "login";
//	}
}
