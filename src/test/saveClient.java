package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class saveClient {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tran = session.beginTransaction();
		
		Student stu = new Student();
		stu.setId(111);
		stu.setName("kvarkala");
		stu.setEmail("varkala@gmail.com");
		stu.setAddress("New jersey");
		
		int pk = (Integer)session.save(stu);
		System.out.println("stored primary key is :"+pk);
		
		tran.commit(); // query will execute here
		session.close();
		sf.close();
		
		System.out.println("data insertion successfull");
	}
}
