package app;

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
}
