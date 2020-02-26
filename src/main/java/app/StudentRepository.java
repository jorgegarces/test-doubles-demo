package app;

public interface StudentRepository {
    Student getStudentByDNI(String DNI);
    void saveStudent(Student student);
}