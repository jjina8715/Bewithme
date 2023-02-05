package com.bewithme.app.mate.service;

import com.bewithme.app.mate.model.MateDto;
import com.bewithme.app.user.model.UserDetailDto;
import com.bewithme.data.entity.GameInfoEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.repository.GameInfoRepository;
import com.bewithme.data.repository.MatchingInfoRepository;
import com.bewithme.data.repository.MemberBasicRepository;
import com.bewithme.data.type.StatCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.bewithme.data.type.StatCode.C01;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MateService {

    private final MatchingInfoRepository matchingInfoRepo;
    private final MemberBasicRepository memberBasicRepo;
    private final GameInfoRepository gameInfoRepository;

    public List<MateDto> findMates(MemberBasicEntity member) {
        return matchingInfoRepo.findMyMateInfo(member.getId());
    }

    public void cancelMate(MemberBasicEntity member, Long mateId) {
        var mate = matchingInfoRepo.findById(mateId).orElseThrow();
        if(!mate.isMyMate(member.getId())) return;
        mate.cancelMate();
    }

    public UserDetailDto findMateInfo(MemberBasicEntity member, Long mateId) throws Exception {
        var myId = member.getId();
        System.out.println(myId);
        var mate = matchingInfoRepo.findById(mateId).orElseThrow();
        if(!mate.isApproved() && !mate.isMyMate(myId)) throw new RuntimeException("mate 정보를 찾을 수 없습니다");
        
        var mateInfo = StringUtils.equals(mate.getRequestee(), myId)
                ? mate.getRequester() : mate.getRequestee();

        var gameInfo = gameInfoRepository.findByMemberBasic(mateInfo).orElse(new GameInfoEntity());
        var userDetail = new UserDetailDto(mateInfo);
        userDetail.setGameInfo(gameInfo);

        return userDetail;
    }
}
