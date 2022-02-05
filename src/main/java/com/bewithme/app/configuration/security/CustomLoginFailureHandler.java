package com.bewithme.app.configuration.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomLoginFailureHandler implements AuthenticationFailureHandler{

	private String defaultFailureUrl;
	
	private boolean forwardToDestination = false;
	
	private boolean allowSessionCreation = true;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	private UserDetailsServiceImpl userService;
	
	public final String AUTHENTICATION_EXCEPTION = "SPRING_SECURITY_AUTHENTICATION_EXCEPTION";
	
	public CustomLoginFailureHandler(String defaultFailureUrl) {
		setDefaultFailureUrl(defaultFailureUrl);
	}
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		if (this.defaultFailureUrl == null) {
            if (log.isTraceEnabled()) {
                log.trace("Sending 401 Unauthorized error since no failure URL is set");
            }
            else {
                log.debug("Sending 401 Unauthorized error");
            }
            response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
            return;
        }
        saveException(request, exception);
        if (this.forwardToDestination) {
            log.debug("Forwarding to " + this.defaultFailureUrl);
            request.getRequestDispatcher(this.defaultFailureUrl).forward(request, response);
        }
        else {
            log.debug("Redirect to " + this.defaultFailureUrl);
            this.redirectStrategy.sendRedirect(request, response, this.defaultFailureUrl);
        }
	}
	protected final void saveException(HttpServletRequest request, AuthenticationException exception) {

        String authnExceptionMassage = "로그인이 실패하였습니다.";

        if (exception instanceof AuthenticationServiceException) {
            authnExceptionMassage = "존재하지 않는 사용자입니다";

        } else if(exception instanceof UsernameNotFoundException) {
            authnExceptionMassage = "존재하지 않는 사용자입니다.";

        } else if(exception instanceof BadCredentialsException) {
            try {
                userService.setBadCredentialsByUsername(request.getParameter("username"));
            } catch (UsernameNotFoundException une) {
                authnExceptionMassage = "잘못된 ID 또는 비밀번호 입니다.";
            }

        } else if(exception instanceof LockedException) {
            authnExceptionMassage = "ID가 잠김 상태입니다.";

        } else if(exception instanceof DisabledException) {
            authnExceptionMassage = "사용할 수 없는 사용자ID 입니다.";

        } else if(exception instanceof AccountExpiredException) {
            authnExceptionMassage = "휴지 상태인 사용자입니다.";

        } else {
            authnExceptionMassage = exception.getMessage();
        }
        if (this.forwardToDestination) {
            log.debug("Forwarding Attribut : " + WebAttributes.AUTHENTICATION_EXCEPTION);

            request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
            request.setAttribute(this.AUTHENTICATION_EXCEPTION, authnExceptionMassage);
            return;
        }
        HttpSession session = request.getSession(false);
        if (session != null || this.allowSessionCreation) {
            log.debug("redirect Attribut : " + WebAttributes.AUTHENTICATION_EXCEPTION);
            request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
            request.getSession().setAttribute(this.AUTHENTICATION_EXCEPTION, authnExceptionMassage);
        }
    }

    public void setDefaultFailureUrl(String defaultFailureUrl) {
        Assert.isTrue(UrlUtils.isValidRedirectUrl(defaultFailureUrl),
                () -> "'" + defaultFailureUrl + "' is not a valid redirect URL");
        this.defaultFailureUrl = defaultFailureUrl;
    }

    protected boolean isUseForward() {
        return this.forwardToDestination;
    }

    public void setUseForward(boolean forwardToDestination) {
        this.forwardToDestination = forwardToDestination;
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return this.redirectStrategy;
    }

    protected boolean isAllowSessionCreation() {
        return this.allowSessionCreation;
    }

    public void setAllowSessionCreation(boolean allowSessionCreation) {
        this.allowSessionCreation = allowSessionCreation;
    }

    public void setUserServive(UserDetailsServiceImpl userService) {
        this.userService = userService;
    }
	
}
