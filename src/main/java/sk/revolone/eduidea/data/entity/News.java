package sk.revolone.eduidea.data.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
 * News entity - Part of skeleton application 
 */

@Entity
public class News {
	
	@Id
	@GeneratedValue
	private Integer Id;
	
	private Date DateCreated;
	private Long UserCreated;
	private String Title;
	private String Text;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Date getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		DateCreated = dateCreated;
	}
	public Long getUserCreated() {
		return UserCreated;
	}
	public void setUserCreated(Long userCreated) {
		UserCreated = userCreated;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
}
