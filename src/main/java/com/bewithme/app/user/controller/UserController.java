package com.bewithme.app.user.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bewithme.app.auth.dto.UserDetails;
import com.bewithme.app.user.model.UserDetailDto;
import com.bewithme.app.user.model.UserDto;
import com.bewithme.app.user.model.UserSearchCondition;
import com.bewithme.app.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller()
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping
	public List<UserDto> findUsers(@AuthenticationPrincipal UserDetails member, UserSearchCondition condition) {
		return userService.findUsers(member.getUser().getMemberBasic().getId(), condition);
	}
	
	@GetMapping("/{id}") 
	public UserDetailDto findUserDetail(@PathVariable Long id) {
		return userService.findUserDetail(id);
	}
	 
}