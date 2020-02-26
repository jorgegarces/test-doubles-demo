import app.AccessMessage;
import app.Student;
import app.StudentRepository;
import app.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceShould {

    @Mock
    StudentRepository studentRepository;

    @Test
    public void grant_access_to_students_aged_18_and_older() {
        //  Arrange
        MockitoAnnotations.initMocks(this);
        StudentService studentService = new StudentService(studentRepository);
        when(studentRepository.getStudentByDNI("1")).thenReturn(new Student("Ara", 18, "1"));
        //  Act
        AccessMessage accessStatus = studentService.checkAccess("1");
        //  Assert
        Assert.assertEquals(AccessMessage.ACCESS_GRANTED, accessStatus);
    }
}
