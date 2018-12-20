package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class DeleteClient {

public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tran = session.beginTransaction();
		
		// just primary key is fine
		Student stu = new Student();
		stu.setId(444);
		
		
		session.delete(stu);
	
		
		tran.commit(); // query will execute here
		session.close();
		sf.close();
		
	}
}
