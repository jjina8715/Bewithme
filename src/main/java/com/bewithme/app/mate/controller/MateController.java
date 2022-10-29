package com.bewithme.app.mate.controller;

import com.bewithme.app.mate.model.MateDto;
import com.bewithme.app.mate.service.MateService;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.bewithme.app.auth.dto.UserDetails;
import com.bewithme.app.mate.service.MatchingService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/mate")
@RequiredArgsConstructor
public class MateController {
	private final MatchingService matchingService;
	private final MateService mateService;

	@PostMapping("/want/{id}")
	public ResponseEntity<Void> requestMatching(@AuthenticationPrincipal UserDetails member, @PathVariable Long id) {
		matchingService.requestMatching(member.getUser().getMemberBasic(), id);
		return ResponseEntity.accepted().build();
	}
	
	@GetMapping
	public ResponseEntity<List<MateDto>> findMates(@AuthenticationPrincipal UserDetails member) {
		return ResponseEntity.ok(mateService.findMates(member.getUser().getMemberBasic()));
	}
}
