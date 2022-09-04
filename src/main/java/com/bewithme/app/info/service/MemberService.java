package com.bewithme.app.info.service;

import javax.validation.Valid;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bewithme.app.auth.dto.UserDto;
import com.bewithme.app.info.model.MemberInfoDto;
import com.bewithme.common.exception.UserAlreadyExistsException;
import com.bewithme.data.entity.MemberAuthEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.repository.MemberAuthRepository;
import com.bewithme.data.repository.MemberBasicRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service
public class MemberService {

	private final PasswordEncoder passwordEncoder;
	private final MemberAuthRepository memberAuthRepo;
	private final MemberBasicRepository memberBasicRepo;

	@Transactional
	public void updateMemberInfo(Long id, MemberInfoDto memberInfoDto) {
		var memberBasic = memberAuthRepo.getById(id).getMemberBasic();
		memberBasic.updateMemberInfo(memberInfoDto);
	}

	public MemberAuthEntity createMember(@Valid UserDto userDto) throws UserAlreadyExistsException {
		isExistUsername(userDto.getEmail());
		
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		MemberBasicEntity userBasic = memberBasicRepo.save(userDto.toBasicEntity());
log.info("userBasic={}", userBasic);
		
		MemberAuthEntity user = userDto.toEntity(userBasic);
	//	user.setAuthId(userDto.getEmail());
	//	user.setAuthValue(user.getAuthValue());
		
log.info("member={}",user);
log.info("memberBasic={}",user.getMemberBasic());
//		MemberBasicEntity memberBasic = memberBasicRepo.save(user.getMemberBasic());
		
		return memberAuthRepo.save(user);
	}
	
	public boolean isExistUsername(String username) throws UserAlreadyExistsException{
		memberAuthRepo.findByAuthId(username).ifPresent(s -> new UserAlreadyExistsException("이미 존재하는 이메일입니다."));			
		
		return true;
	}

}
