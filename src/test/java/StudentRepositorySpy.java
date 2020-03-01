import app.Student;
import app.StudentRepository;

public class StudentRepositorySpy implements StudentRepository {

    private int counter = 0;

    public int saveCount() {
        return this.counter;
    }

    @Override
    public Student getStudentByDNI(String DNI) {
        return null;
    }

    @Override
    public void saveStudent(Student student) {
        this.counter++;
    }
}
