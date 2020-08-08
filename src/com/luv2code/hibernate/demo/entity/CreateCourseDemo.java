package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			System.out.println("process started");
			
			session.beginTransaction();
			
			Course course1 = new Course("Cricket - A maestro game");
			Course course2 = new Course("Cooking - Gives great pleasure");
			
			
			int id =1;
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			tempInstructor.add(course1);
			tempInstructor.add(course2);
			
			session.save(course1);
			session.save(course2);
					
			session.getTransaction().commit();
			
			System.out.println("Process finished successfully");
			
		} finally {
			session.close();
			factory.close();
		}
		}
}
