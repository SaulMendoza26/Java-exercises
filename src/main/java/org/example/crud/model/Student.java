package org.example.crud.model;

public class Student {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private String enrollmentCode;

    public String getEnrollmentCode() {
        return enrollmentCode;
    }

    public void setEnrollmentCode(String enrollmentCode) {
        this.enrollmentCode = enrollmentCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return String.format(
                "+----+-----------------+-----------------+-----+-------------------+\n" +
                        "| Enrollment Code  | Name            | Last Name       | Age |\n" +
                        "+----+-----------------+-----------------+-----+-------------------+\n" +
                        " | %-17s | %-15s | %-15s | %-3d| \n" +
                        "+----+-----------------+-----------------+-----+-------------------+",
                enrollmentCode, name, lastName, age
        );
    }
}
