import java.util.List;

public class StandardEnrollmentStrategy implements EnrollmentStrategy {
    @Override
    public void enrollStudent(CourseSection courseSection, Student student) throws DuplicateException, CourseException {
        List<Student> enrolledStudents = courseSection.getEnrolledStudents();
        for (Student enrolledStudent : enrolledStudents) {
            if (enrolledStudent.getId().equals(student.getId())) {
                throw new DuplicateException("Duplicate Classes Enrolled!", courseSection);
            }
        }
        enrolledStudents.add(student);
        courseSection.notifyObservers("New student enrolled: " + student.getFirstName() + " " + student.getLastName());
    }
}
