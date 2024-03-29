package com.bewithme.app.info.service;

import java.util.Collections;

import javax.validation.Valid;

import javassist.NotFoundException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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

	 public void login(UserDto userDto) {
	 log.info("userDto="+userDto.toString());
    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDto.getEmail(),
            userDto.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")));
    SecurityContextHolder.getContext().setAuthentication(token); // AuthenticationManager를 쓰는 방법이 정석적인 방ㅇ법
    }
	 
	@Transactional
	public void updateMemberInfo(Long id, MemberInfoDto memberInfoDto) {
		var memberBasic = memberAuthRepo.getById(id).getMemberBasic();
		memberBasic.updateMemberInfo(memberInfoDto);
	}

	public MemberAuthEntity createMember(@Valid UserDto userDto) throws Exception {
		isExistUsername(userDto.getEmail());

		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		var userBasic =  memberBasicRepo.save(userDto.toBasicEntity());
log.info("userBasic={}", userBasic);
		MemberAuthEntity user = userDto.toEntity(userBasic);
		userDto.toWishEntity(userBasic);
		
log.info("member={}",user);
log.info("memberBasic={}",user.getMemberBasic());
		
		return memberAuthRepo.save(user);
	}
	
	public boolean isExistUsername(String username) throws UserAlreadyExistsException{
		memberAuthRepo.findByAuthId(username).ifPresent(s -> { throw new UserAlreadyExistsException("이미 존재하는 이메일입니다."); });
		
		return true;
	}

	public MemberInfoDto getMemberInfo(Long id) throws NotFoundException {
		var memberBasic = memberBasicRepo.findById(id).orElseThrow(() -> new RuntimeException("정보를 불러올 수 없습니다."));
		return new MemberInfoDto(memberBasic);
	}
	
}
