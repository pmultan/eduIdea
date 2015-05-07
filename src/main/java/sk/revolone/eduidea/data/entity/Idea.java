package sk.revolone.eduidea.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Idea {

	// TODO: Collabolators, Votes

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	private User author;

	@Column(columnDefinition = "TEXT")
	private String text;

	private String title;

	private Integer expectedVotes;

	private Integer complexityLvl;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;

	@ManyToOne
	private Category category;

	@PrePersist
	protected void onCreate() {
		this.setDateCreated(new Date());
	}

	public Integer getId() {
		return id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getExpectedVotes() {
		return expectedVotes;
	}

	public void setExpectedVotes(Integer expectedVotes) {
		this.expectedVotes = expectedVotes;
	}

	public Integer getComplexityLvl() {
		return complexityLvl;
	}

	public void setComplexityLvl(Integer complexityLvl) {
		this.complexityLvl = complexityLvl;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
