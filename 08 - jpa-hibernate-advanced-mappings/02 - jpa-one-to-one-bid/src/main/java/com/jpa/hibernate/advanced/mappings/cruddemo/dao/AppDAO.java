package com.jpa.hibernate.advanced.mappings.cruddemo.dao;

import com.jpa.hibernate.advanced.mappings.cruddemo.entity.Instructor;
import com.jpa.hibernate.advanced.mappings.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
}
