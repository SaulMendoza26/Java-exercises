package org.example.crud.service;

import org.example.crud.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService implements StudentCRUD {
    private final Connection connection;

    public StudentService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Student createStudent(Student student) {

        String createStudent = "INSERT INTO students (enrollmentCode,name,lastName,age) values (?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(createStudent);) {
            preparedStatement.setString(1, student.getEnrollmentCode());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setInt(4, student.getAge());
            if (!preparedStatement.execute()) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student findStudent(String enrollmentCode) {
        String findStudent = "Select * from students where enrollmentCode=?";
        Student student = new Student();
        try (PreparedStatement preparedStatement = connection.prepareStatement(findStudent)
        ) {

            preparedStatement.setString(1, enrollmentCode);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    student.setEnrollmentCode(resultSet.getString("enrollmentCode"));
                    student.setName(resultSet.getString("name"));
                    student.setLastName(resultSet.getString("lastName"));
                    student.setAge(resultSet.getInt("age"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> findAllStudent() {
        List<Student> students = new ArrayList<>();
        String query = "select * from students";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultset = preparedStatement.executeQuery()) {
            while (resultset.next()) {
                Student student = new Student();
                student.setEnrollmentCode(resultset.getString("enrollmentCode"));
                student.setName(resultset.getString("name"));
                student.setLastName(resultset.getString("lastName"));
                student.setAge(resultset.getInt("age"));
                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public String updateStudent(String enrollmentCode, Student student) {
        String updateSql = "update students set name=?,lastName=?,age=? where enrollmentCode=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, enrollmentCode);
            int update = preparedStatement.executeUpdate();
            if (update > 0) {
                return "Your change was successfully made.";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "An error occurred.";
    }

    @Override
    public String deleteStudent(String enrollmentCode) {
        String sqlDelete = "Delete from students where enrollmentCode =?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {
            preparedStatement.setString(1, enrollmentCode);
            int delete = preparedStatement.executeUpdate();
            if (delete > 0) {
                return "It has been successfully deleted.";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "An error occurred.";
    }

    public boolean isStudentExists(String enrollmentCode) {
        String query = "SELECT COUNT(*) FROM students WHERE enrollmentCode = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, enrollmentCode);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}