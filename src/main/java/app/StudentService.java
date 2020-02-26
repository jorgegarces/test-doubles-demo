package app;

public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public AccessMessage checkAccess(String DNI) {
        Student student = studentRepository.getStudentByDNI(DNI);
        if (student.checkAge()) return AccessMessage.ACCESS_GRANTED;
        return AccessMessage.ACCESS_DENIED;
    }
}