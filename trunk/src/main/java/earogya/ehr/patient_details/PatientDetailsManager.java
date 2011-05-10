package main.java.earogya.ehr.patient_details;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PatientDetailsManager {
	
	public Boolean insertPatientDetails()
	{
		Boolean isSuccess=false;
		Session session = null;
		try{
			// This step will read hibernate.cfg.xml and prepare hibernate for use
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			 session =sessionFactory.openSession();
				//Create new instance of Contact and set values in it by reading them from form object
			 	System.out.println("Inserting Record");
				Person person = new Person();
				//person.setId(6);
				person.setFirstName("Ureka");
				person.setMiddleName("Sanjeewani");
				person.setSurname("Wijekoon");
				session.save(person);
				System.out.println("Done");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			// Actual contact insertion will happen at this step
		session.flush();
			session.close();

			}
		
		return isSuccess;
	}

}
