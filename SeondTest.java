public class SeondTest {

    public static void main(String[] args) throws DuplicateException, CourseException {
        testDecoratorPattern();
        testAdapterPattern();
    }




    private static void testDecoratorPattern() throws DuplicateException, CourseException {
        System.out.println("Testing Decorator Pattern:");

        // Create a CourseSection object
        CourseSection courseSection = new CourseSection("CSC101", "Introduction to Computer Science", "FJT01", "MWF", "10AM", "Building A", "Room 101");

        // Decorate it with CapacityDecorator with a capacity limit of 2
        CapacityDecorator decoratedSection = new CapacityDecorator(courseSection, 2);

        // Create student objects
        Student student1 = new Student("1001");
        student1.setFirstName("John");
        student1.setLastName("Doe");

        Student student2 = new Student("1002");
        student2.setFirstName("Jane");
        student2.setLastName("Smith");

        Student student3 = new Student("1003");
        student3.setFirstName("Alice");
        student3.setLastName("Johnson");

        // Enroll two students successfully
        decoratedSection.enrollStudent(student1);
        decoratedSection.enrollStudent(student2);

        // Attempt to enroll a third student and verify the capacity constraint is enforced
        try {
            decoratedSection.enrollStudent(student3);
        } catch (CourseException e) {
            System.out.println("Expected exception: " + e.getMessage());
        }

        // Output enrolled students
        System.out.println("Enrolled students in course section:");
        for (Student student : decoratedSection.getEnrolledStudents()) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
        System.out.println("Expected: John Doe, Jane Smith");
    }



    private static void testAdapterPattern() {
        System.out.println("Testing Adapter Pattern:");
        // Create an Address object
        Address address = new Address("123 Main St", "Springfield", "IL", "62704");

        // Adapt it using AddressAdapter
        ExternalAddress externalAddress = new AddressAdapter(address);

        // Verify the adapted address provides the expected full address string
        System.out.println("Adapted address: " + externalAddress.getFullAddress());
        System.out.println("Expected: 123 Main St, Springfield, IL 62704");
        System.out.println();
    }
}
