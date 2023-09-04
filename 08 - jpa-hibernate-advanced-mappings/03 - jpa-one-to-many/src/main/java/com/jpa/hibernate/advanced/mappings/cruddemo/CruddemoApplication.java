package com.jpa.hibernate.advanced.mappings.cruddemo;

import com.jpa.hibernate.advanced.mappings.cruddemo.dao.AppDAO;
import com.jpa.hibernate.advanced.mappings.cruddemo.entity.Course;
import com.jpa.hibernate.advanced.mappings.cruddemo.entity.Instructor;
import com.jpa.hibernate.advanced.mappings.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);
			// deleteInstructorDetail(appDAO);

			// createInstructorWithCourses(appDAO);
			// findInstructorWithCourses(appDAO);
			// findCoursesForInstructor(appDAO);
			// findInstructorWithCoursesJoinFetch(appDAO);

			// updateInstructor(appDAO);
			// updateCourse(appDAO);

			// deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting course...");
		appDAO.deleteCourseById(theId);
		System.out.println("Course deleted");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Finding course id: " + theId);

		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("Enjoy the Simple things");

		appDAO.update(tempCourse);

		System.out.println("Course updated");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Updating instructor id: " + theId);
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Instructor found");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		// find instructor
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Passou aqui 1");
		System.out.println("tempInstructor: " + tempInstructor);

		System.out.println("Passou aqui 2");

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor...");

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Instructor name: " + tempInstructor.getFirstName() + ' ' + tempInstructor.getLastName());
		System.out.println("Courses: " + tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Bob", "o Bobo", "bob@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail(
				"http://youtube.com/bobobobo",
				"Potato"
		);

		tempInstructor.setInstructorDetail(tempInstructorDetail);


		Course tempCourse1 = new Course("Spring Boot 3, Spring 6 & Hibernate for Beginners");
		Course tempCourse2 = new Course("Java COMPLETO 2023 Programação Orientada a Objetos");
		Course tempCourse3 = new Course("Curso de SQL Completo - Aplicado ao Mercado de Trabalho");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);

		System.out.println("Saving instructor...");
		appDAO.save(tempInstructor);
		System.out.println("Instructor saved!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting InstructorDetail...");
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("InstructorDetail deleted");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor...");

		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("The instructor channel: " + tempInstructorDetail.getYoutube_channel());
		System.out.println("Hobby: " + tempInstructorDetail.getHobby());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
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
