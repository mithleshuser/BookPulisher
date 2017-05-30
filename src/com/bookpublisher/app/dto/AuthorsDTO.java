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
public class AuthorsDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int author_id;
	private String author_name;
	private int author_ratings;
	
	@ManyToMany(cascade=CascadeType.ALL)  
	@JoinTable(name="author_book", joinColumns=@JoinColumn(name="author_id"), inverseJoinColumns=@JoinColumn(name="book_id"))
	private Set<BookDTO> books ;
	
	@ManyToMany(mappedBy="authors")
	private Set<PublisherDTO> publisher;
	

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getAuthor_name() {
		return author_name;
	}

	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

	public int getAuthor_ratings() {
		return author_ratings;
	}

	public void setAuthor_ratings(int author_ratings) {
		this.author_ratings = author_ratings;
	}
	
	public Set<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(Set<BookDTO> books) {
		this.books = books;
	}

	
	public Set<PublisherDTO> getPublisher() {
		return publisher;
	}

	public void setPublisher(Set<PublisherDTO> publisher) {
		this.publisher = publisher;
	}
}
