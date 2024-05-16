public class SeondTest {

    public static void main(String[] args) throws DuplicateException, CourseException {
        testFactoryMethodPattern();
        testDecoratorPattern();
        testAdapterPattern();
        testObserverPattern();
        testStrategyPattern();

    }


    private static void testFactoryMethodPattern() {
        System.out.println("Testing Factory Method Pattern:");

        // Create instances of factory creators
        CourseSectionCreator lectureCreator = new LectureCourseSectionCreator();
        CourseSectionCreator labCreator = new LabCourseSectionCreator();

        // Create course sections using the factory methods
        CourseSection lectureSection = lectureCreator.createCourseSection("CSC101", "Introduction to Computer Science", "FJT01", "MWF", "10AM", "Building A", "Room 101");
        CourseSection labSection = labCreator.createCourseSection("CSC101", "Introduction to Computer Science Lab", "LAB01", "TTH", "2PM", "Building B", "Room 102");

        // Print the created course sections
        System.out.println("Created Lecture Section: " + lectureSection);
        System.out.println("Expected: CourseSection{courseId='CSC101', courseName='Introduction to Computer Science', sectionId='FJT01', days='MWF', startTime='10AM', building='Building A', room='Room 101'}");
        System.out.println("Created Lab Section: " + labSection);
        System.out.println("Expected: CourseSection{courseId='CSC101', courseName='Introduction to Computer Science Lab', sectionId='LAB01', days='TTH', startTime='2PM', building='Building B', room='Room 102'}\n");
    }


    private static void testDecoratorPattern() throws DuplicateException, CourseException {
        System.out.println("\n"+"Testing Decorator Pattern:");

        // Create a CourseSection object
        CourseSection courseSection = new CourseSection("CSC101", "Introduction to Computer Science", "FJT01", "MWF", "10AM", "Building A", "Room 101");

        // Decorate it with CapacityDecorator with a capacity limit of 2
        CapacityDecorator decoratedSection = new CapacityDecorator(courseSection, 2);

        // Create student objects
        Student student1 = new Student("2143980");
        student1.setFirstName("Abdulaziz");
        student1.setLastName("Alshamrani");

        Student student2 = new Student("2040849");
        student2.setFirstName("Faris");
        student2.setLastName("Alshamrani");

        Student student3 = new Student("2142640");
        student3.setFirstName("Ahmad");
        student3.setLastName("Saadi");

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
        System.out.println("Expected: Abdulaziz Alshamrani, Faris Alshamrani");
    }



    private static void testAdapterPattern() {
        System.out.println("\n"+"Testing Adapter Pattern:");
        // Create an Address object
        Address address = new Address("Sultan bin Salman St", "Jeddah", "Makkah", "62704");

        // Adapt it using AddressAdapter
        ExternalAddress externalAddress = new AddressAdapter(address);

        // Verify the adapted address provides the expected full address string
        System.out.println("Adapted address: " + externalAddress.getFullAddress());
        System.out.println("Expected: Sultan bin Salman St, Jeddah, Makkah 62704");
        System.out.println();
    }


    private static void testObserverPattern() throws DuplicateException, CourseException {
        System.out.println("\n"+"Testing Observer Pattern:");

        // Create a CourseSection object
        CourseSection courseSection = new CourseSection("CSC102", "Data Structures", "FJT02", "TTH", "11AM", "Building B", "Room 202");

        // Create observer objects
        StudentObserver observer1 = new StudentObserver("2143980");
        StudentObserver observer2 = new StudentObserver("2040849");

        // Attach observers to the course section
        courseSection.attach(observer1);
        courseSection.attach(observer2);

        // Create student objects
        Student student1 = new Student("2143980");
        student1.setFirstName("Abdulaziz");
        student1.setLastName("Shamrani");

        Student student2 = new Student("2040849");
        student2.setFirstName("Faris");
        student2.setLastName("Alshamrani");

        // Enroll students and verify observers are notified
        courseSection.enrollStudent(student1);
        courseSection.enrollStudent(student2);

        // Change sectionId, building, and room to trigger notifications
        courseSection.setSectionId("FJT03");
        courseSection.setBuilding("Building C");
        courseSection.setRoom("Room 303");

        // Expected output
        System.out.println("\nExpected:");
        System.out.println("Notification for student 2143980: New student enrolled: Abdulaziz Alshamrani");
        System.out.println("Notification for student 2040849: New student enrolled: Abdulaziz Alshamrani");
        System.out.println("Notification for student 2143980: New student enrolled: Faris Alshamrani");
        System.out.println("Notification for student 2040849: New student enrolled: Faris Alshamrani");
        System.out.println("Notification for student 2143980: Section ID changed to: FJT03");
        System.out.println("Notification for student 2040849: Section ID changed to: FJT03");
        System.out.println("Notification for student 2143980: Building changed to: Building C");
        System.out.println("Notification for student 2040849: Building changed to: Building C");
        System.out.println("Notification for student 2143980: Room changed to: Room 303");
        System.out.println("Notification for student 2040849: Room changed to: Room 303");

    }







    private static void testStrategyPattern() throws DuplicateException, CourseException {
        System.out.println("\nTesting Strategy Pattern:");

        // Create a CourseSection object
        System.out.println("\n");
        CourseSection courseSection = new CourseSection("CSC103", "Algorithms", "FJT03", "MWF", "9AM", "Building D", "Room 404");

        // Set different enrollment strategies and test them
        EnrollmentStrategy standardStrategy = new StandardEnrollmentStrategy();
        EnrollmentStrategy priorityStrategy = new PriorityEnrollmentStrategy();

        // Create student objects
        Student student1 = new Student("2143980");
        student1.setFirstName("Abdulaziz");
        student1.setLastName("Alshamrani");

        Student student2 = new Student("2040849");
        student2.setFirstName("Faris");
        student2.setLastName("Alshamrani");

        Student student3 = new Student("1003");
        student3.setFirstName("Ahmad");
        student3.setLastName("Saadi");


        // Use the standard strategy
        courseSection.setEnrollmentStrategy(standardStrategy);
        courseSection.enrollStudent(student1);
        courseSection.enrollStudent(student2);
        courseSection.enrollStudent(student3);

        // Output enrolled students using standard strategy
        System.out.println("Enrolled students with Standard Strategy:");
        for (Student student : courseSection.getEnrolledStudents()) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
        System.out.println();

        // Use the priority strategy
        courseSection = new CourseSection("CSC103", "Algorithms", "FJT03", "MWF", "9AM", "Building D", "Room 404");
        courseSection.setEnrollmentStrategy(priorityStrategy);
        courseSection.enrollStudent(student1);
        courseSection.enrollStudent(student2);
        courseSection.enrollStudent(student3);


        // Output enrolled students using priority strategy
        System.out.println("Enrolled students with Priority Strategy:");
        for (Student student : courseSection.getEnrolledStudents()) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }
        System.out.println();
    }


}


