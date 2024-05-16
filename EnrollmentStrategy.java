public interface EnrollmentStrategy {
    void enrollStudent(CourseSection courseSection, Student student) throws DuplicateException, CourseException;
}
