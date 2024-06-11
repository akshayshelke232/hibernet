package com.hibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		System.out.println(factory);

		Session session = factory.openSession();
//		session.beginTransaction();
		
		Student student = (Student)session.load(Student.class, 1);
		System.out.println(student);
		
		Address address = (Address)session.get(Address.class, 1);
		System.out.println(address.getStreet());
		
		session.close();
		factory.close();
	}

}
