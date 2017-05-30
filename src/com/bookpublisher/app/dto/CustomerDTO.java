package com.bookpublisher.app.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class CustomerDTO {
	@Id
	@GenericGenerator(name = "custom_id", strategy = "com.bookpublisher.app.util.CustomIdentifier1")
	@GeneratedValue(generator = "custom_id")
	private String u_id;
	private String name;
	private String u_address;
	private String u_pnonNo;
	private String u_qualification;
	private Date reg_date;
	
	@OneToOne(cascade=CascadeType.ALL)
	private LoginDTO login;



	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public String getU_pnonNo() {
		return u_pnonNo;
	}

	public void setU_pnonNo(String u_pnonNo) {
		this.u_pnonNo = u_pnonNo;
	}

	public String getU_qualification() {
		return u_qualification;
	}

	public void setU_qualification(String u_qualification) {
		this.u_qualification = u_qualification;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public LoginDTO getLogin() {
		return login;
	}

	public void setLogin(LoginDTO login) {
		this.login = login;
	}
}
