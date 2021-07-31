package com.jsp.manytomany.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.jsp.manytomany.dto.BankDto;
import com.jsp.manytomany.dto.CustomerDto;

public class HibernateUtil {
	static SessionFactory sf = null;

	static {
		if(sf==null) {

			Configuration cfg = new Configuration();

			Properties prop = new Properties();
			prop.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
			prop.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernaterelation");
			prop.put(Environment.USER,"root");
			prop.put(Environment.PASS,"root");
			prop.put(Environment.SHOW_SQL,true);
			prop.put(Environment.FORMAT_SQL,true);
			prop.put(Environment.HBM2DDL_AUTO,"update");
			prop.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, true);
			
			cfg.addProperties(prop);
			cfg.addAnnotatedClass(BankDto.class);
			cfg.addAnnotatedClass(CustomerDto.class);
			sf = cfg.buildSessionFactory();

		}
}
	public static SessionFactory getsF() {
		return sf;
	}
}	
