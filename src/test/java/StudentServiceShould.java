import app.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class StudentServiceShould {
    protected AddStudentDTO adultStudent = new AddStudentDTO();
    protected AddStudentDTO youngStudent = new AddStudentDTO();

    @Mock
    StudentRepository studentRepository;

    public StudentServiceShould() {
    }

    @Before
    public void Init() {
        MockitoAnnotations.initMocks(this);

        adultStudent.name = "Arota";
        adultStudent.age = 18;
        adultStudent.DNI = "22222222B";

        youngStudent.name = "Arita";
        youngStudent.age = 17;
        youngStudent.DNI = "33333333B";
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
}
