package sk.revolone.eduidea.data.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity
public class User implements CustomUser{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(unique=true)
	private String email;
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String username;
	private String password;
	
	@OneToOne(mappedBy="user", cascade={CascadeType.ALL})
	private Role role;
	
	private Boolean isActivated;
	
	@Type(type = "uuid-char")
	private UUID activationKey;
	
	public UUID getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(UUID activationKey) {
		this.activationKey = activationKey;
	}

	public Boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
 
	
}
