package com.bewithme.app.member.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.bewithme.app.member.model.MemberInfoDto;
import com.bewithme.data.entity.MatchingInfoEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.repository.MatchingInfoRepository;
import com.bewithme.data.repository.MemberBasicRepository;
import com.bewithme.data.type.StatCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatchingService {

	private final MemberBasicRepository memberBasicRepo;
	private final MatchingInfoRepository matchinginfoRepo;
	
	public MemberInfoDto requestMatching(MemberBasicEntity requester, Long requesteeId) throws NoSuchElementException{
		var requestee = memberBasicRepo.findById(requesteeId).orElseThrow();
		matchinginfoRepo.save(MatchingInfoEntity.builder()
				.requester(requester)
				.requestee(requestee)
				.stat(StatCode.C02.getCode())
				.build());
		return new MemberInfoDto(requestee);
	}
}
