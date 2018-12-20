package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class PersistClient {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tran = session.beginTransaction();
		
		Student stu = new Student();
		stu.setId(444);
		stu.setName("kumar");
		stu.setEmail("varkala@yahoo.com");
		stu.setAddress("New york");
		
		session.persist(stu);
		// save can execute without transaction boundaries
		// persist can execute within transaction boundaries
		
		tran.commit(); // query will execute here
		session.close();
		sf.close();
		
		System.out.println("data insertion successfull");
	}
}
