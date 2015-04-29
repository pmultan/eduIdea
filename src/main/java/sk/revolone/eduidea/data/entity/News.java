package sk.revolone.eduidea.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * News entity - Part of skeleton application 
 */

@Entity
public class News {
	
	@Id 
	@GeneratedValue
	private Integer Id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateCreated;
	private Long UserCreated;
	private String Title;
	
	@Column(columnDefinition="TEXT")
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
