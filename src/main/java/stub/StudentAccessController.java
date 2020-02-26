package stub;

public class StudentAccessController {
    private RepoInterface repoInterface;

    public StudentAccessController(RepoInterface repoInterface) {
        this.repoInterface = repoInterface;
    }

    public String checkAccess(int studentId) {
        Student student = repoInterface.getStudent(studentId);
        if (student.checkAge()) return "Access Granted";
        return "Access Denied";
    }
}