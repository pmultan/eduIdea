package sk.revolone.eduidea.data.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class UserLogged extends
		org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	private String email;

	public UserLogged(String username, String lowerCase, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities, String email) {
		super(username, lowerCase, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
