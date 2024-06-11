package com.hibernet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        SessionFactory factory= new Configuration().configure().buildSessionFactory();
        System.out.println(factory);
        
        //creating student
        Student st = new Student();
        st.setId(1);
        st.setName("Akshay");
        st.setCity("thane");
        System.out.println(st);
        
        //creating object of adrress 
        Address ad = new Address();
        ad.setStreet("Street1");
        ad.setCity("city1");
        ad.setOpen(true);
        ad.setX(1.4);
        ad.setAddedDate(new Date());
        
        //readng image
        FileInputStream fis= new FileInputStream("src/main/java/imgs895.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        Session session = factory.openSession();
        session.beginTransaction(); 
        session.save(st);
        session.save(ad);
        session.getTransaction().commit();
        
        System.out.println("done");
        
        session.close();
        factory.close();
        
    }
}
