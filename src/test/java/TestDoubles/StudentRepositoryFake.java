package TestDoubles;

import app.Student;
import app.StudentRepository;
import java.util.ArrayList;

public class StudentRepositoryFake implements StudentRepository {

    ArrayList<Student> students = new ArrayList<>();

    @Override
    public Student getStudentByDNI(String DNI) {
        for (Student student : students) {
            if (student.checkDNI(DNI)) return student;
        }
        return null;
    }

    @Override
    public void saveStudent(Student student) {
        students.add(student);
    }
}
