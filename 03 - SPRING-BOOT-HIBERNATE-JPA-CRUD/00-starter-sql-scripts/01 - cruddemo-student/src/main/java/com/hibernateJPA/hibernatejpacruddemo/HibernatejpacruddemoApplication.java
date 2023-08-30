package com.hibernateJPA.hibernatejpacruddemo;

import com.hibernateJPA.hibernatejpacruddemo.dao.StudentDAO;
import com.hibernateJPA.hibernatejpacruddemo.Entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernatejpacruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatejpacruddemoApplication.class, args);
		System.out.println("Server running :)");
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//
			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

			// queryForStudent(studentDAO);

			// queryForStudentByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);
			
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		studentDAO.deleteAll();
		System.out.println("All students deleted");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 4;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
		System.out.println("Student deleted");
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student student = studentDAO.findById(studentId);

		System.out.println("Updating student...");
		student.setFirstName("Scooby");

		studentDAO.update(student);

		System.out.println("Updated student: " + student);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		System.out.println("----- Lista de estudantes -----");
		for (Student student : theStudents) {
			System.out.println(student);
		}
		System.out.println("----- Fim da lista -----");
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> theStudentList = studentDAO.findAll();

		System.out.println("----- Lista de estudantes -----");
		for (Student student : theStudentList) {
			System.out.println(student);
		}
		System.out.println("----- Fim da lista -----");
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();

		System.out.println("Saved student. Generated id: " + theId);
		System.out.println("Retrieving student with id: "+ theId);

		Student myStudent = studentDAO.findById(theId);
		System.out.println("Found the student:" + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John", "Duck", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
