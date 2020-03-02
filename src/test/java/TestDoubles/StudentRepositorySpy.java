package TestDoubles;

import app.Student;
import app.StudentRepository;

public class StudentRepositorySpy implements StudentRepository {

    private int savedStudentsCounter = 0;
    private Student lastSavedStudent;

    public boolean savedStudents(int expectedSavedStudents) {
        return expectedSavedStudents == savedStudentsCounter;
    }

    public Student getLastSavedStudent() {
        return lastSavedStudent;
    }

    @Override
    public Student getStudentByDNI(String DNI) {
        return null;
    }

    @Override
    public void saveStudent(Student student) {
        lastSavedStudent = student;
        savedStudentsCounter++;
    }

}
