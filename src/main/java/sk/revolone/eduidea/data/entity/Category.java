package sk.revolone.eduidea.data.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@OneToOne
	private Category parentCategory;

	@OneToMany(mappedBy="category")
	private Set<Idea> ideas;
	
	public Category()
	{
		
	}
	
	public Category(Integer idIn)
	{
		this.id = idIn;
	}
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Set<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(Set<Idea> ideas) {
		this.ideas = ideas;
	}
	
	
}
