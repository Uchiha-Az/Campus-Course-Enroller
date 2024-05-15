import java.util.List;

public interface    Section {
    String getSectionId();
    Course getCourse();
    List<Student> getEnrolledStudents();
    void enrollStudent(Student student) throws DuplicateException, CourseException;
    void removeStudent(Student student);
}