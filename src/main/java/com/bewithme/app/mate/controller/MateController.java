package com.bewithme.app.mate.controller;

import com.bewithme.app.mate.model.MateDto;
import com.bewithme.app.mate.service.MateService;
import com.bewithme.app.user.model.UserDetailDto;
import org.apache.catalina.User;
import org.apache.coyote.Response;
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

	@GetMapping("/{id}")
	public ResponseEntity<UserDetailDto> findMateInfo(@AuthenticationPrincipal UserDetails member, @PathVariable("id") Long mateId) throws Exception {
		return ResponseEntity.ok(mateService.findMateInfo(member.getUser().getMemberBasic(), mateId));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> approveRequest(@AuthenticationPrincipal UserDetails member, @PathVariable("id") Long mateId) {
		matchingService.approveRequest(member.getUser().getMemberBasic(), mateId);
		return ResponseEntity.accepted().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> cancelMate(@AuthenticationPrincipal UserDetails member, @PathVariable("id") Long mateId) {
		mateService.cancelMate(member.getUser().getMemberBasic(), mateId);
		return ResponseEntity.accepted().build();
	}
}
