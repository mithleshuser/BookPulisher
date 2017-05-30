package com.bookpublisher.app.dto;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class BookDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int book_id;
	private String book_name;
	private String book_edition;
	private int book_ratings;
	
	@ManyToMany(mappedBy="books")
	private Set<AuthorsDTO> authors;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_edition() {
		return book_edition;
	}

	public void setBook_edition(String book_edition) {
		this.book_edition = book_edition;
	}

	public int getBook_ratings() {
		return book_ratings;
	}

	public void setBook_ratings(int book_ratings) {
		this.book_ratings = book_ratings;
	}
	
	public Set<AuthorsDTO> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<AuthorsDTO> authors) {
		this.authors = authors;
	} 
}
