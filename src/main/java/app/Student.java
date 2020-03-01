package app;

import java.util.Objects;

public class Student {
    private String name;
    private final int age;
    private String DNI;

    private Student(String name, int age, String DNI) {
        this.name = name;
        this.age = age;
        this.DNI = DNI;
    }

    public static Student create(AddStudentDTO studentData) {
        return new Student(studentData.name, studentData.age, studentData.DNI);
    }

    public boolean checkAge() {
        return this.age >= 18;
    }

    public boolean checkDNI(String DNI) {
        return this.DNI.equals(DNI);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                name.equals(student.name) &&
                DNI.equals(student.DNI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, DNI);
    }
}