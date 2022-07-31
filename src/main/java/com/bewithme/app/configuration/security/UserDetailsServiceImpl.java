package com.bewithme.app.configuration.security;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bewithme.app.auth.dto.UserDetails;
import com.bewithme.data.entity.MemberAuthEntity;
import com.bewithme.data.repository.MemberAuthRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final MemberAuthRepository userAuthRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		log.info("username={}", username);
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
	
}