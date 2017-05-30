package com.bookpublisher.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table
public class FilePropertiseDTO {
	@Id
	@GenericGenerator(name="INC",strategy="increment")
	@GeneratedValue(generator="INC")
	private int id;
	@Column
	private String fname;
	@Column
	private String flocation;
	@Column
	private long fsize;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getFsize() {
		return fsize;
	}
	public void setFsize(long fsize) {
		this.fsize = fsize;
	}
	public String getFname() {

		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFlocation() {
		return flocation;
	}
	public void setFlocation(String flocation) {
		this.flocation = flocation;
	}

	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}
	private Date fdate;
}
