package com.bookpublisher.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookpublisher.app.dao.CustomerDAO;
import com.bookpublisher.app.dto.CustomerDTO;
import com.bookpublisher.app.dto.LoginDTO;
import com.bookpublisher.app.dto.PublisherDTO;

@Service
public class CustomerServiceIpml implements CustomerService {
	
	@Autowired
	private CustomerDAO userDao;

	@Override
	public String add(CustomerDTO user) {
		return userDao.add(user);
	}

	@Override
	public LoginDTO login(LoginDTO user) {
		
		return userDao.login(user);
	}

	@Override
	public int addPublishedForm(PublisherDTO p_obj) {
		return userDao.addPublishedForm(p_obj);
	}



}
