import app.AddStudentDTO;
        import app.Student;
        import app.StudentRepository;

public class StudentRepositoryFake implements StudentRepository {

    private final AddStudentDTO student;

    public StudentRepositoryFake(AddStudentDTO student) {
        this.student = student;
    }

    @Override
    public Student getStudentByDNI(String DNI) {
        return app.Student.create(student);
    }

    @Override
    public void saveStudent(Student student) {
    }
}