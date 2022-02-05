package com.bewithme.app.configuration.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bewithme.data.entity.MemberAuthEntity;
import com.bewithme.data.repository.MemberAuthRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final MemberAuthRepository userRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		MemberAuthEntity member = userRepo.findByAuthId(username)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("[%s]는 존재하지 않는 아이디입니다.", username)));
		boolean isEnabled = true;
		boolean isNonExpired = true;
		boolean passwordNonExpired = true;
		boolean isNonLocked = true;
		return new UserDetails(member, isEnabled, isNonExpired, passwordNonExpired, isNonLocked);
	}
	
	@Transactional
	public int setBadCredentialsByUsername(String authId) throws UsernameNotFoundException{
		
		userRepo.findByAuthId(authId).orElseThrow(() -> new UsernameNotFoundException(String.format("[%s]는 존재하지 않는 아이디입니다.", authId)));
		
		return 0;
	}
	
	@Transactional
	public boolean setAuthnSuccessByUsername(String authId) {
		try {
			MemberAuthEntity member = userRepo.findByAuthId(authId)
					.orElseThrow(() -> new UsernameNotFoundException(String.format("[%s]는 존재하지 않는 아이디입니다.", authId)));
			//member.getMemberBasic().setLastLogin(LocalDateTime.now());
			userRepo.save(member);
			
			return true;
		} catch(UsernameNotFoundException ex) {
			//log.debug("setAuthnSuccessByUsername : {}", ex.getMessage());
			
			return false;
		}
	}
}
