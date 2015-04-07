package sk.revolone.eduidea.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
 
@Entity
public class Role {
	
	@Id
	private Long id;
	
	@OneToOne
	private User user;
	private Integer role_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getRole() {
		return role_id;
	}
	public void setRole(Integer role) {
		this.role_id = role;
	}
	
	
}