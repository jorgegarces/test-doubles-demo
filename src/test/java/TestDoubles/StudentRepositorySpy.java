package TestDoubles;

import app.Student;
import app.StudentRepository;

public class StudentRepositorySpy implements StudentRepository {

    int savedStudentsCounter = 0;

    public boolean savedStudents(int expectedSavedStudents) {
        return expectedSavedStudents == savedStudentsCounter;
    }

    @Override
    public Student getStudentByDNI(String DNI) {
        return null;
    }

    @Override
    public void saveStudent(Student student) {
        savedStudentsCounter++;
    }
}
