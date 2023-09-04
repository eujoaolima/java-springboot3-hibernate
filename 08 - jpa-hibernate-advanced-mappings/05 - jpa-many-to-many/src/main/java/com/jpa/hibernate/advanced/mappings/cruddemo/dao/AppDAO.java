package com.jpa.hibernate.advanced.mappings.cruddemo.dao;

import com.jpa.hibernate.advanced.mappings.cruddemo.entity.Course;
import com.jpa.hibernate.advanced.mappings.cruddemo.entity.Instructor;
import com.jpa.hibernate.advanced.mappings.cruddemo.entity.InstructorDetail;
import com.jpa.hibernate.advanced.mappings.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentsByCourseID(int theId);

    Student findStudentAndCoursesByStudentId(int theId);

    void update(Student tempStudent);

    void deleteStudentById(int theId);
}
