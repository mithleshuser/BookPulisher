package com.bookpublisher.app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class LoginDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int login_id;
	private String email;
	private String password;
	private String login_rendompwd;
	private String login_security_option;
	
/*	@OneToOne
	@PrimaryKeyJoinColumn
	private CustomerDTO custdto;*/
	
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogin_rendompwd() {
		return login_rendompwd;
	}
	public void setLogin_rendompwd(String login_rendompwd) {
		this.login_rendompwd = login_rendompwd;
	}
	public String getLogin_security_option() {
		return login_security_option;
	}
	public void setLogin_security_option(String login_security_option) {
		this.login_security_option = login_security_option;
	}
	/*public CustomerDTO getCustdto() {
		return custdto;
	}
	public void setCustdto(CustomerDTO custdto) {
		this.custdto = custdto;
	}*/

	
	
	
}
