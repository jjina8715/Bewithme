package com.bewithme.app.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.bewithme.data.entity.GameInfoEntity;
import com.bewithme.data.repository.GameInfoRepository;
import org.springframework.stereotype.Service;

import com.bewithme.app.user.model.UserDetailDto;
import com.bewithme.app.user.model.UserDto;
import com.bewithme.app.user.model.UserSearchCondition;
import com.bewithme.data.repository.MatchingInfoRepository;
import com.bewithme.data.repository.MemberBasicRepository;
import com.bewithme.data.type.StatCode;

import lombok.RequiredArgsConstructor;

import static com.bewithme.data.type.StatCode.*;

@RequiredArgsConstructor
@Service
public class UserService {

	private final MemberBasicRepository memberBasicRepo;
	private final MatchingInfoRepository matchingInfoRepo;
	private final GameInfoRepository gameInfoRepository;

	public List<UserDto> findUsers(Long id, UserSearchCondition condition) {
		// 1. 사용중인 user 조회 stat = 사용중, order by lastLogin
		var users = memberBasicRepo.findByStatOrderByLastLoginDesc(C01.getCode());
		// 2. mate 조회 후 user 조회에서 제외 
		var mates = matchingInfoRepo.findMyMateId(id);
		
		if(!mates.isEmpty()) {
			users = new ArrayList<>(users);
			users.removeIf(user -> mates.contains(user.getId()));
		}
		return users.stream()
				.map(UserDto::new)
				.collect(Collectors.toList());
	}

	public UserDetailDto findUserDetail(Long id) throws Exception {
		// 1. basic info
		var userInfo = memberBasicRepo.findById(id).orElseThrow();
		var userDetail = new UserDetailDto(userInfo);
		// 2. game info
		var gameInfo = gameInfoRepository.findByMemberBasic(userInfo).orElse(new GameInfoEntity());
		userDetail.setGameInfo(gameInfo);
		
		return userDetail;
	}
}
