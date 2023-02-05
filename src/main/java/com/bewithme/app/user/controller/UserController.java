package com.bewithme.app.user.controller;

import java.util.List;

import org.mapstruct.Mapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.bewithme.app.auth.dto.UserDetails;
import com.bewithme.app.user.model.UserDetailDto;
import com.bewithme.app.user.model.UserDto;
import com.bewithme.app.user.model.UserSearchCondition;
import com.bewithme.app.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@GetMapping
	@ResponseBody
	public List<UserDto> findUsers(@AuthenticationPrincipal UserDetails member, UserSearchCondition condition) {
		return userService.findUsers(member.getUser().getMemberBasic().getId(), condition);
	}
	
	@GetMapping("/{id}") 
	public String findUserDetail(@PathVariable Long id, Model model) throws Exception{
		model.addAttribute("user", userService.findUserDetail(id));
		return "elements.html";
	}

}