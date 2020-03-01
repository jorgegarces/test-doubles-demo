import app.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class StudentServiceShould {
    protected AddStudentDTO adultStudent = new AddStudentDTO();
    protected AddStudentDTO youngStudent = new AddStudentDTO();

    @Mock
    StudentRepository studentRepository;

    @Before
    public void Init() {
        MockitoAnnotations.initMocks(this);

        adultStudent.name = "Adult Student";
        adultStudent.age = 18;
        adultStudent.DNI = "00000000A";

        youngStudent.name = "Underage Student";
        youngStudent.age = 17;
        youngStudent.DNI = "11111111A";
    }

    @Test
    public void grant_access_to_students_aged_18_and_older() {
        //  Arrange
        StudentService studentService = new StudentService(studentRepository);
        when(studentRepository.getStudentByDNI("1")).thenReturn(Student.create(adultStudent));
        //  Act
        AccessMessage accessStatus = studentService.checkAccess("1");
        //  Assert
        Assert.assertEquals(AccessMessage.ACCESS_GRANTED, accessStatus);
    }

    @Test
    public void deny_access_to_underage_students() {
        //  Arrange
        StudentService studentService = new StudentService(studentRepository);
        when(studentRepository.getStudentByDNI("1")).thenReturn(Student.create(youngStudent));
        //  Act
        AccessMessage accessStatus = studentService.checkAccess("1");
        //  Assert
        Assert.assertEquals(AccessMessage.ACCESS_DENIED, accessStatus);
    }

    @Test
    public void grant_access_to_students_aged_18_and_older_using_a_fake_repo() {

        StudentRepositoryFake studentRepositoryFake = new StudentRepositoryFake(adultStudent);
        StudentService studentService = new StudentService(studentRepositoryFake);

        AccessMessage accessStatus = studentService.checkAccess("1");

        Assert.assertEquals(AccessMessage.ACCESS_GRANTED, accessStatus);
    }

    @Test
    public void command_repository_to_save_a_new_student() {
        //  Arrange
        StudentService studentService = new StudentService(studentRepository);
        //  Act
        studentService.addStudentToRepository(Student.create(adultStudent));
        //  Assert
        verify(studentRepository).saveStudent(Student.create(adultStudent));
    }

    @Test
    public void command_repository_to_save_new_students() {
        StudentRepositorySpy studentRepositorySpy = new StudentRepositorySpy();
        StudentService studentService = new StudentService(studentRepositorySpy);

        studentService.addStudentToRepository(Student.create(adultStudent));
        studentService.addStudentToRepository(Student.create(youngStudent));

        Assert.assertEquals(2, studentRepositorySpy.saveCount());
    }
}