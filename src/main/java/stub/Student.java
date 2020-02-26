package stub;

public class Student {
    private final int age;

    public Student(int age) {
        this.age = age;
    }

    public boolean checkAge() {
        return this.age >= 18;
    }
}
