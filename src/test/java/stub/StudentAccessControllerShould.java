package stub;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentAccessControllerShould {
    @Mock
    RepoInterface repoInterface;

    @Test
    public void grant_access_to_students_aged_18_and_older(){
        //  Arrange
        MockitoAnnotations.initMocks(this);
        StudentAccessController studentAccessController = new StudentAccessController(repoInterface);
        when(repoInterface.getStudent(1)).thenReturn(new Student(18));
        //  Act
        String studentResult = studentAccessController.checkAccess(1);
        //  Assert
        Assert.assertEquals("Access Granted", studentResult);
    }

    @Test
    public void deny_access_to_underage_students(){
        //  Arrange
        MockitoAnnotations.initMocks(this);
        StudentAccessController studentAccessController = new StudentAccessController(repoInterface);
        when(repoInterface.getStudent(1)).thenReturn(new Student(17));
        //  Act
        String studentResult = studentAccessController.checkAccess(1);
        //  Assert
        Assert.assertEquals("Access Denied", studentResult);
    }
}
