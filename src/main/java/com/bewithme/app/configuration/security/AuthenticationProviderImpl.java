package com.bewithme.app.configuration.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bewithme.app.auth.dto.UserDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@Component
public class AuthenticationProviderImpl implements AuthenticationProvider{
	
	private final UserDetailsServiceImpl userService;
	
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException{
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;
		String email = (String)token.getPrincipal();
		String pwd = (String)token.getCredentials();
		UserDetails userDetailsImpl = userService.loadUserByUsername(email);
		log.info("email={} password={}",email,pwd);
		if(!passwordEncoder.matches(userDetailsImpl.getPassword(), pwd)) {
			throw new BadCredentialsException(userDetailsImpl.getUsername()+" Invaild password");
		}
		
		
		return new UsernamePasswordAuthenticationToken(userDetailsImpl, pwd, userDetailsImpl.getAuthorities());
 	}
	
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
