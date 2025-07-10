package org.example.crud.view_console;

import org.example.crud.model.ConnectionDataBase;
import org.example.crud.model.Student;
import org.example.crud.service.StudentService;

import java.sql.Connection;
import java.util.Scanner;

public class AppStudent {
    private static final Scanner input = new Scanner(System.in);
    private static String[] args;

    private static void menu(Connection connection){

        StudentService studentService = new StudentService(connection
        );

        int condition=0;
        do{
            System.out.println("Student Registration Application.");
            System.out.println("1. Create Student");
            System.out.println("2. Read a Student");
            System.out.println("3. Read All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            int choose = input.nextInt();
            input.nextLine(); // Consume the newline character left by nextInt()
            switch (choose){
                case 1 -> createStudent(studentService);
                case 2 -> readStudent(studentService);
                case 3-> readAStudents(studentService);
                case 4 -> updateStudent(studentService);
                case 5 -> deleteStudent(studentService);
                case 6 -> {
                    condition = 6;
                    System.out.println("Exiting the application. Thank you for using it!");
                    input.close();
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }while (condition !=6);
    }
    private static void createStudent(StudentService studentService) {
        System.out.println("Creating a new student...");
        // Logic to create a student
        Student student = new Student();
        System.out.println("Enter student code enrollment: ");
        String codeEnrollment = input.nextLine();
        if(studentService.isStudentExists(codeEnrollment)){
            System.out.println("A student with this enrollment code already exists. Please try again with a different code.");
            return;
        }
        System.out.print("Enter student name: ");
        String name = input.nextLine();
        System.out.println("Enter student last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter student age: ");
        int age = input.nextInt();
        student.setEnrollmentCode(codeEnrollment);
        student.setName(name);
        student.setLastName(lastName);
        student.setAge(age);
        studentService.createStudent(student);

    }
    private static void readStudent(StudentService studentService) {
        System.out.println("Reading a student...");
        // Logic to read a student
        System.out.print("Enter student code enrollment: ");
        String codeEnrollment = input.nextLine();
        Student student = studentService.findStudent(codeEnrollment);
        if (student != null) {
            System.out.println("Student found: " + student.getName() + " " + student.getLastName());
        } else {
            System.out.println("Student not found.");
        }
    }
    private static void readAStudents(StudentService studentService){
        System.out.println("Reading all students...");
        System.out.println("+----+-----------------+-----------------+-----+-------------------+");
        System.out.println("| Enrollment Code  | Name            | Last Name       | Age |");
        System.out.println("+----+-----------------+-----------------+-----+-------------------+");
        for(Student student : studentService.findAllStudent()) {
            System.out.printf("| %-17s | %-15s | %-15s | %-3d |\n",
                    student.getEnrollmentCode(), student.getName(), student.getLastName(), student.getAge());
        }
        System.out.println("+----+-----------------+-----------------+-----+-------------------+");
    }
    private static void updateStudent(StudentService studentService) {
        System.out.println("Updating a student...");
        // Logic to update a student
        System.out.print("Enter student code enrollment: ");
        String codeEnrollment = input.nextLine();
        Student student = studentService.findStudent(codeEnrollment);
        if (student != null) {
            System.out.print("Enter new name: ");
            String name = input.nextLine();
            System.out.print("Enter new last name: ");
            String lastName = input.nextLine();
            System.out.print("Enter new age: ");
            int age = input.nextInt();
            student.setName(name);
            student.setLastName(lastName);
            student.setAge(age);
            studentService.updateStudent(codeEnrollment,student);
        } else {
            System.out.println("Student not found.");
        }
    }
    private static void deleteStudent(StudentService studentService) {
        System.out.println("Deleting a student...");
        // Logic to delete a student
        System.out.print("Enter student code enrollment: ");
        String codeEnrollment = input.nextLine();
        Student student = studentService.findStudent(codeEnrollment);
        if (student != null) {
            studentService.deleteStudent(codeEnrollment);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
    public static  void main(String[] args){


        try(Connection connection = ConnectionDataBase.getConnection()){
            menu(connection);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
