package sk.revolone.eduidea.viewmodel;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import sk.revolone.eduidea.utils.validation.*;

@FieldMatch.List({
    @FieldMatch(first = "email", second = "emailConfirmation"),
})

public class SignUpViewModel extends BaseViewModel {
	
	@NotNull
	@Email
	@NotEmpty
	private String email;
	@NotNull
	@Email
	@NotEmpty
	private String emailConfirmation;
	@NotEmpty
	private String username;
	@NotEmpty
	private String firstname;
	@NotEmpty
	private String lastname;
	@NotEmpty
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailConfirmation() {
		return emailConfirmation;
	}

	public void setEmailConfirmation(String emailConfirmation) {
		this.emailConfirmation = emailConfirmation;
	}
	
	
}
