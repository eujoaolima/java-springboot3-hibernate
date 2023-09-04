package com.jpa.hibernate.advanced.mappings.cruddemo;

import com.jpa.hibernate.advanced.mappings.cruddemo.dao.AppDAO;
import com.jpa.hibernate.advanced.mappings.cruddemo.entity.Instructor;
import com.jpa.hibernate.advanced.mappings.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
		System.out.println("Server running :)");
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			// createInstructor(appDAO);
			// findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting instructor...");
		appDAO.deleteInstructorById(theId);
		System.out.println("Instructor deleted");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor...");

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("The instructor: " + tempInstructor);
		System.out.println("Details: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor tempInstructor = new Instructor("Bob", "o Bobo", "bob@gmail.com");
//
//		InstructorDetail tempInstructorDetail = new InstructorDetail(
//				"http://youtube.com/lucasmontano",
//				"Batata"
//		);

		Instructor tempInstructor = new Instructor("Will", "Iam", "will@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://youtube.com/manodeyvin",
				"Potato"
		);

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("Saving isntructor...");
		appDAO.save(tempInstructor);
		System.out.println("Instructor saved!");
	}

}
