package com.bookpublisher.app.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class PublisherDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int publishar_id;
	private String publishar_name;
	private int publishar_ratings;
	
	@ManyToMany(cascade=CascadeType.ALL)  
	@JoinTable(name="publishar_author", joinColumns=@JoinColumn(name="author_id"), inverseJoinColumns=@JoinColumn(name="publishar_id"))
	private Set<AuthorsDTO> authors;

	public int getPublishar_id() {
		return publishar_id;
	}

	public void setPublishar_id(int publishar_id) {
		this.publishar_id = publishar_id;
	}

	public int getPublishar_ratings() {
		return publishar_ratings;
	}

	public void setPublishar_ratings(int publishar_ratings) {
		this.publishar_ratings = publishar_ratings;
	}
	public String getPublishar_name() {
		return publishar_name;
	}

	public void setPublishar_name(String publishar_name) {
		this.publishar_name = publishar_name;
	}

	public Set<AuthorsDTO> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<AuthorsDTO> authors) {
		this.authors = authors;
	}

}
