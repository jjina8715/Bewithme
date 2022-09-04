package com.bewithme.app.configuration.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.bewithme.app.auth.dto.UserDetails;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	private UserDetailsServiceImpl userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		UserDetails userDetail = (UserDetails) authentication.getPrincipal();
		
		if(userService != null) {
			boolean isSuccess = userService.setAuthnSuccessByUsername(userDetail.getUsername());
			log.debug("AuthenticationSuccess User Setting [{}] : {}", userDetail.getUsername(), isSuccess);
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
