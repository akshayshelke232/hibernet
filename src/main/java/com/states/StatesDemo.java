package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernet.Certificate;
import com.hibernet.Student;

public class StatesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//hibernate states
		//TRansient,Persistent,Detached,Removed
		System.out.println("Example :");
		SessionFactory f = new Configuration().configure().buildSessionFactory();

		//creating student obj
		Student s = new Student();
		s.setId(111);
		s.setCity("city111");
		s.setName("name111");
		s.setCerti(new Certificate("java","3month"));
		//s is in transient state  // not in DB or session obj
		
		Session session = f.openSession();
		Transaction tx = session.beginTransaction();
		session.save(s); 
		//s in persistent state -session,database
		s.setName("akshay");
		
		
		tx.commit();
		session.close();

		s.setName("shelke");
		
		
		f.close();
		
	}

}
