public class CapacityDecorator extends SectionDecorator {
    private int capacity;

    public CapacityDecorator(Section decoratedSection, int capacity) {
        super(decoratedSection);
        this.capacity = capacity;
    }

    @Override
    public void enrollStudent(Student student) throws DuplicateException, CourseException{
        if (decoratedSection.getEnrolledStudents().size() < capacity) {
            decoratedSection.enrollStudent(student);
        } else {
            System.out.println("Section is full!");
        }
    }
}