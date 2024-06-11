package com.hibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		System.out.println(factory);

		Student s1 = new Student();
		s1.setName("ABC");
		s1.setCity("CITY_A");
		s1.setId(123);

		Certificate c1 = new Certificate();
		c1.setCourse("Course 1");
		c1.setDuration("3Month");

		s1.setCerti(c1);

		Student s2 = new Student();
		s2.setName("DEF");
		s2.setCity("CITY_B");
		s2.setId(124);

		Certificate c2 = new Certificate();
		c2.setCourse("Course 2");
		c2.setDuration("4Month");

		s2.setCerti(c2);

        Session session = factory.openSession();
        session.beginTransaction(); 
        session.save(s1);
        session.save(s2);
        session.getTransaction().commit();
        
        System.out.println("done");
        
        session.close();
        factory.close();
	}

}
