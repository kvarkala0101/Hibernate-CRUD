package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class updateClient {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tran = session.beginTransaction();
		
		// exception scenario
		
		session.get(Student.class, 111);
		
		Student stu = new Student();
		stu.setId(111);
		stu.setName("kvarkala");
		stu.setEmail("varkala@reddit.com");
		stu.setAddress("New jersey");
		
		session.update(stu);
		
		// to overcome the above excetion use merge(object) method
		
		tran.commit(); // query will execute here
		session.close();
		sf.close();
		
	}
}
