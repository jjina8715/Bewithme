package com.bewithme.app.configuration.security;

import javax.validation.Valid;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bewithme.app.auth.dto.UserDetails;
import com.bewithme.app.auth.dto.UserDto;
import com.bewithme.common.exception.UserAlreadyExistsException;
import com.bewithme.data.entity.MemberAuthEntity;
import com.bewithme.data.entity.MemberBasicEntity;
import com.bewithme.data.repository.MemberAuthRepository;
import com.bewithme.data.repository.MemberBasicRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final MemberAuthRepository userAuthRepo;
	private final MemberBasicRepository userBasicRepo;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		MemberAuthEntity member = userAuthRepo.findByAuthId(username)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("[%s]는 존재하지 않는 아이디입니다.", username)));
		boolean isEnabled = true;
		boolean isNonExpired = true;
		boolean passwordNonExpired = true;
		boolean isNonLocked = true;
		return new UserDetails(member, isEnabled, isNonExpired, passwordNonExpired, isNonLocked);
	}
	
	@Transactional
	public int setBadCredentialsByUsername(String authId) throws UsernameNotFoundException{
		
		userAuthRepo.findByAuthId(authId).orElseThrow(() -> new UsernameNotFoundException(String.format("[%s]는 존재하지 않는 아이디입니다.", authId)));
		
		return 0;
	}
	
	@Transactional
	public boolean setAuthnSuccessByUsername(String authId) {
		try {
			MemberAuthEntity member = userAuthRepo.findByAuthId(authId)
					.orElseThrow(() -> new UsernameNotFoundException(String.format("[%s]는 존재하지 않는 아이디입니다.", authId)));
			//member.getMemberBasic().setLastLogin(LocalDateTime.now());
			userAuthRepo.save(member);
			
			return true;
		} catch(UsernameNotFoundException ex) {
			//log.debug("setAuthnSuccessByUsername : {}", ex.getMessage());
			
			return false;
		}
	}
	
	@Transactional
	public MemberAuthEntity createMember(@Valid UserDto userDto) throws UserAlreadyExistsException {
		isExistUsername(userDto.getEmail());
	 
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		MemberAuthEntity user = userDto.toEntity();
		MemberBasicEntity memberBasic = userBasicRepo.save(user.getMemberBasic());
		user.setMemberBasic(memberBasic);
		
		return userAuthRepo.save(user);
	}
	
	public boolean isExistUsername(String username) throws UserAlreadyExistsException{
		userAuthRepo.findByAuthId(username).ifPresent(s -> new UserAlreadyExistsException("이미 존재하는 이메일입니다."));			
		
		return true;
	}
}