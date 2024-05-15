import java.util.List;

public abstract class SectionDecorator implements Section {
    protected Section decoratedSection;

    public SectionDecorator(Section decoratedSection) {
        this.decoratedSection = decoratedSection;
    }

    @Override
    public String getSectionId() {
        return decoratedSection.getSectionId();
    }

    @Override
    public Course getCourse() {
        return decoratedSection.getCourse();
    }

    @Override
    public List<Student> getEnrolledStudents() {
        return decoratedSection.getEnrolledStudents();
    }

    @Override
    public void enrollStudent(Student student) throws DuplicateException , CourseException{
        decoratedSection.enrollStudent(student);
    }

    @Override
    public void removeStudent(Student student) {
        decoratedSection.removeStudent(student);
    }
}