package com.bookpublisher.app.dao;

import com.bookpublisher.app.dto.CustomerDTO;
import com.bookpublisher.app.dto.LoginDTO;
import com.bookpublisher.app.dto.PublisherDTO;

public interface CustomerDAO {
	
	public String add(CustomerDTO user);
	
	public LoginDTO login(LoginDTO user) throws NullPointerException;

	public int addPublishedForm(PublisherDTO p_obj);

}
