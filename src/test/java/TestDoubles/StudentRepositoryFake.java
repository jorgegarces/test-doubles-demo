package TestDoubles;

import app.Student;
import app.StudentRepository;

public class StudentRepositoryFake implements StudentRepository {

    private Student student;

    @Override
    public Student getStudentByDNI(String DNI) {
      if (student.checkDNI(DNI)) return student;
       return null;
    }

    @Override
    public void saveStudent(Student student) {
        this.student = student;
    }
}
