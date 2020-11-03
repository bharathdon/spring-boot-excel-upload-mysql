package com.abc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tutorial")
public class Tutorial {

	@Id
	private Integer id;
	private String title;
	private String description;
	private Boolean published;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getPublished() {
		return published;
	}
	public void setPublished(Boolean published) {
		this.published = published;
	}
	
	public Tutorial() {
		// TODO Auto-generated constructor stub
	}
	public Tutorial(Integer id, String title, String description, Boolean published) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.published = published;
	}
	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", description=" + description + ", published=" + published
				+ "]";
	}
	
	
	
}
