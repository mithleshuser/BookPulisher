package com.bookpublisher.app.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookpublisher.app.dto.CustomerDTO;
import com.bookpublisher.app.dto.LoginDTO;
import com.bookpublisher.app.dto.PublisherDTO;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String add(CustomerDTO user) {
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
		return user.getU_id();
	}

	@Override
	public LoginDTO login(LoginDTO user) throws NullPointerException {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("from LoginDTO where email=:user_email and password=:user_pwd");
		System.out.println("1111");
		query.setString("user_email",user.getEmail());
		query.setString("user_pwd",user.getPassword());
		System.out.println("2222");
		LoginDTO user1=(LoginDTO)query.uniqueResult();
		System.out.println("3333");
		transaction.commit();
		System.out.println("4444");
		session.close();
		System.out.println("5555");
		return user1;
		
		/*Query query = s1.createQuery("from RegDTO where uemail=:e_mail and upassword=:e_Pwd");
		query.setString("e_mail", regdto.getUemail());
		query.setString("e_Pwd", regdto.getUpassword());
		RegDTO validUser = (RegDTO) query.uniqueResult();
		tx.commit();
		s1.close();
		return validUser;*/
	}

	@Override
	public int addPublishedForm(PublisherDTO p_obj) {
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(p_obj);
		transaction.commit();
		session.close();
		
		int num =  p_obj.getPublishar_id();
		return num;
	}





}
