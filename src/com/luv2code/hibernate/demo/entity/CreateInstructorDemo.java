package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

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
			
			InstructorDetail instructorDetail = new InstructorDetail();
			
			instructorDetail.setYoutubeChannel("Instagram cooking page");
			instructorDetail.setHobby("Cooking");
			
			Instructor instructor = new Instructor();
			
			instructor.setFirst_name("sahithi");
			instructor.setLast_name("parepally");
			instructor.setEmail("sahithiamity@gmail.com");
			instructor.setInstructorDetail(instructorDetail);
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			
			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Process finished successfully");
			
		} finally {
			session.close();
			factory.close();
		}
		}
}
