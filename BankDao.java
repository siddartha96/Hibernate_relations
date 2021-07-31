package com.jsp.onetomay.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.jsp.onetomany.util.HibernateUtil;
import com.jsp.onetomay.dto.BankDto;
import com.jsp.onetomay.dto.CustomerDto;

public class BankDao {
	SessionFactory sf = HibernateUtil.getSF();

	public void saveBank() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		BankDto bank = new BankDto();
		bank.setB_name("ca");
		bank.setB_branch("RajajiNagar");
		bank.setIFSC("SBI004");

		List<CustomerDto> custList = new ArrayList<CustomerDto>();
		CustomerDto cust1 = new CustomerDto();
		cust1.setC_name("siddarth");
		cust1.setC_accNo("1234");
		cust1.setC_accType("Savings");
		custList.add(cust1);
		

		//		CustomerDto cust2 = new CustomerDto();
		//		cust2.setC_name("seenu");
		//		cust2.setC_accNo("12344");
		//		cust2.setC_accType("Savings");
		//		custList.add(cust2);
		//		
		//		CustomerDto cust3 = new CustomerDto();
		//		cust3.setC_name("Ashok");
		//		cust3.setC_accNo("1234679");
		//		cust3.setC_accType("Savings");
		//		custList.add(cust3);
		//		
		cust1.setBank(bank);
		session.save(bank);
		bank.setCustList(custList);

		tx.commit();

	}

	public void getBankDetails() {

		
		Session session = sf.openSession();
		Transaction tx  = session.beginTransaction();

		BankDto bank = session.get(BankDto.class, 1);
		System.out.println(" BAnk Name"+bank.getB_name());

		bank.getCustList().forEach(System.out::println);

		//		for(CustomerDto cust :bank.getCustList()){
		//			System.out.println("CustName"+cust.getC_name());
		//		}
		tx.commit();
	}

	public void getCustomerDetails() {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		CustomerDto cust = session.get(CustomerDto.class, 2);
		System.out.println("customer name " + cust.getC_name());
		BankDto bank = cust.getBank();
		System.out.println(bank.getB_name());
		

     }
	
	
}