package com.jsp.onetomany.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jsp.onetomany.dto.HallTicket;
import com.jsp.onetomany.dto.UserDto;
import com.jsp.onetomany.util.HibernateUtil;

public class UserDao {
	
SessionFactory sf = HibernateUtil.getSF();
	
	public void saveUser() {
		
		
		UserDto user = new UserDto();
		user.setAddress("Bangalore");
		user.setAge(24);
		user.setName("siddarth");
		
		
		HallTicket hall = new HallTicket();
		
		hall.setCenter("Rajajinagar");
		hall.setSubjectcode("MCA006T");
		hall.setUSNNO("17SKSAC015");
		
		Session session = sf.openSession();
		Transaction tx  = session.beginTransaction();
		
		
		//user.setHallticket(hall);
		//hall.setUser(user);
		
		session.save(user);
		session.save(hall);
		
		tx.commit();
		
}
	
	public void getUserAndHallTicketWithUSerObject() {
		Session session = sf.openSession();
		Transaction tx  = session.beginTransaction();
		
		UserDto user = session.get(UserDto.class, 1);
		
		System.out.println("USer NAme "+user.getName());
		HallTicket hall = user.getHallticket();
		System.out.println("Hall No"+hall.getUSNNO());
		tx.commit();
		
	}
	
	public void getUserAndHallTicketWithHallObject(){
		Session session = sf.openSession();
		Transaction tx  = session.beginTransaction();
		
		HallTicket hall = session.get(HallTicket.class, 1);
		System.out.println("Hall No"+hall.getUSNNO());
		
		UserDto user = hall.getUser();
		System.out.println("USer NAme "+user.getName());
		
		tx.commit();
		
		
		
	}

	

}
