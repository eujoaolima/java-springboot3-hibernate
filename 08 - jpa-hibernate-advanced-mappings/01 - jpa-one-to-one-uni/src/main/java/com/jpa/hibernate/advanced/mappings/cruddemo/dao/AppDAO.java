package com.jpa.hibernate.advanced.mappings.cruddemo.dao;

import com.jpa.hibernate.advanced.mappings.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
