package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class SelectClient {

public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Object obj = session.get(Student.class, 111); // here the query will executed
		Student stu = (Student)obj;
		
		/*
		 * 
		 * Object obj = session.load(Student.class, 111);
		 * Student stu = (Student)obj;
		 * Syso(stu.getId());
		 * Syso(stu.getName()); --> at this line query will executed
		 * 
		 * 
		 */
		
		
		session.delete(stu);
	
	
		session.close();
		sf.close();
		
	}
}
