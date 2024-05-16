import java.util.List;

public class PriorityEnrollmentStrategy implements EnrollmentStrategy {
    @Override
    public void enrollStudent(CourseSection courseSection, Student student) throws DuplicateException, CourseException {
        List<Student> enrolledStudents = courseSection.getEnrolledStudents();
        for (Student enrolledStudent : enrolledStudents) {
            if (enrolledStudent.getId().equals(student.getId())) {
                throw new DuplicateException("Duplicate Classes Enrolled!", courseSection);
            }
        }
        // Insert the student in order based on name (lexicographical order)
        int i = 0;
        while (i < enrolledStudents.size() && student.getFirstName().compareTo(enrolledStudents.get(i).getFirstName()) > 0) {
            i++;
        }
        enrolledStudents.add(i, student);
        courseSection.notifyObservers("New student enrolled: " + student.getFirstName() + " " + student.getLastName());
    }
}
