package com.bewithme.app.mate.service;

import com.bewithme.app.mate.model.MateDto;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.repository.MatchingInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MateService {

    private final MatchingInfoRepository matchingInfoRepo;

    public List<MateDto> findMates(MemberBasicEntity member) {
        return matchingInfoRepo.findMyMateInfo(member.getId())
                .stream().map(mate ->
                        new MateDto(mate.getId(), mate.getNickname())
                ).collect(Collectors.toList());
    }
}
