package com.bewithme.app.mate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bewithme.app.auth.dto.UserDetails;
import com.bewithme.app.mate.service.MatchingService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mate")
@RequiredArgsConstructor
public class MateController {
	private final MatchingService matchingService;

	
	@PostMapping("/want/{id}")
	public ResponseEntity<Void> requestMatching(@AuthenticationPrincipal UserDetails member, @PathVariable Long id) {
		matchingService.requestMatching(member.getUser().getMemberBasic(), id);
		return ResponseEntity.accepted().build();
	}
}
