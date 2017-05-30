package com.bookpublisher.app.service;

import com.bookpublisher.app.dto.CustomerDTO;
import com.bookpublisher.app.dto.LoginDTO;
import com.bookpublisher.app.dto.PublisherDTO;

public interface CustomerService {
	
	public String add(CustomerDTO user);
	
	public LoginDTO login(LoginDTO user) throws NullPointerException;

	public int addPublishedForm(PublisherDTO p_obj);

}
