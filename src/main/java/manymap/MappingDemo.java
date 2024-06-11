package manymap;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		System.out.println(factory);
		
		Emp e1=new Emp();
		Emp e2=new Emp();
		
		e1.seteId(1);
		e1.setEname("ABC");
		
		e2.seteId(2);
		e2.setEname("DEF");
		
		Project p1=new Project();
		Project p2=new Project();
		
		p1.setPid(11);
		p1.setPname("project1");
		
		p2.setPid(12);
		p2.setPname("project2");
		
		List<Emp> listEmp= new ArrayList<Emp>();
		List<Project> listProject= new ArrayList<Project>();
		
		listEmp.add(e1);
		listEmp.add(e2);
		
		listProject.add(p1);
		listProject.add(p2);
		
		e1.setProjects(listProject);
		p2.setEmps(listEmp);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		
		tx.commit();
		s.close();
		factory.close();

	}

}
