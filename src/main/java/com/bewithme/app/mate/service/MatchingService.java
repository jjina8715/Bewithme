package com.bewithme.app.mate.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.bewithme.data.entity.MatchingInfoEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.repository.MatchingInfoRepository;
import com.bewithme.data.repository.MemberBasicRepository;
import com.bewithme.data.type.StatCode;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import static com.bewithme.data.type.StatCode.C02;

@Service
@RequiredArgsConstructor
public class MatchingService {

	private final MemberBasicRepository memberBasicRepo;
	private final MatchingInfoRepository matchingInfoRepo;
	
	public void requestMatching(MemberBasicEntity requester, Long requesteeId) throws NoSuchElementException{
		var requestee = memberBasicRepo.findById(requesteeId).orElseThrow();
		// TODO 이미 신청한 유저 입니다.
		matchingInfoRepo.save(MatchingInfoEntity.builder()
				.requester(requester)
				.requestee(requestee)
				.stat(C02.getCode())
				.build());
	}

	@Transactional
	public void approveRequest(MemberBasicEntity memberBasic, Long mateId) {
		var request = matchingInfoRepo.findById(mateId).orElseThrow();
		if(!request.isWaited() || request.getRequestee().getId() != memberBasic.getId()) return;
		request.approveRequest();
	}

}
