package com.bewithme.app.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bewithme.app.user.model.UserDto;
import com.bewithme.app.user.model.UserSearchCondition;
import com.bewithme.data.repository.MemberAuthRepository;
import com.bewithme.data.repository.MemberBasicRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final MemberAuthRepository memberAuthRepo;
	private final MemberBasicRepository memberBasicRepo;

	public List<UserDto> findUsers(Long id, UserSearchCondition condition) {
		
		return new ArrayList<>();
	}
}
