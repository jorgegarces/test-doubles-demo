package app;

public class Student {
    private String name;
    private final int age;
    private String DNI;

    public Student(String name, int age, String DNI) {
        this.name = name;
        this.age = age;
        this.DNI = DNI;
    }

    public boolean checkAge() {
        return this.age >= 18;
    }
}
