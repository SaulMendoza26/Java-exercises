package org.example.crud.service;

import org.example.crud.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentCRUD {
    Student createStudent(Student student);
    Student findStudent(String enrollmentCode);
    List<Student> findAllStudent();
    String updateStudent(String enrollmentCode,Student student);
    String deleteStudent(String enrollmentCode);
}
