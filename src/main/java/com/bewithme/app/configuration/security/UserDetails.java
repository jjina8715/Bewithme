package com.bewithme.app.configuration.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.bewithme.data.entity.MemberAuthEntity;

import lombok.Getter;

@Getter
public class UserDetails extends User{

private static final long serialVersionUID = 54361460258288529L;
	
	private MemberAuthEntity user;
			
	public UserDetails(MemberAuthEntity user){
		this(user, true, true, true, true);
	}
		
    public UserDetails(MemberAuthEntity user, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked) {

        super(user.getAuthId(), user.getAuthValue(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
                AuthorityUtils.createAuthorityList(user.getAuthRole()));

        this.user = user;

    }
}
