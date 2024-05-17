# Course Enrollment System

## Overview

This project serves as the final project for the Design Patterns class. It is a Course Enrollment System designed to manage and enroll students in various course sections. The system incorporates multiple design patterns, including Singleton, Factory Method, Adapter, Decorator, Observer, and Strategy, to enhance flexibility, scalability, and maintainability.

This project serves as the final project for the Design Patterns class. It is a Course Enrollment System designed to manage and enroll students in various course sections. The project is a refactoring of a forked repository that was a simple project. The original project can be found [here](https://github.com/duehringadam/CSCJava). The system incorporates multiple design patterns, including Singleton, Factory Method, Adapter, Decorator, Observer, and Strategy, to enhance flexibility, scalability, and maintainability.


## Project Transformation

The project underwent significant **refactoring** to transition from an ordinary codebase to an efficient and robust system. The refactoring process involved the strategic application of design patterns to improve the project's capabilities, including its maintainability, scalability, and readability.

### Key Refactoring Steps:

- **Singleton Pattern**: Ensures a single instance of the `DataStore` class to manage course data consistently.
- **Factory Method Pattern**: Provides a flexible way to create different types of course sections (Lecture and Lab).
- **Adapter Pattern**: Adapts the `Address` class to be compatible with an external address system.
- **Decorator Pattern**: Adds additional responsibilities to course sections dynamically, such as enforcing a capacity limit.
- **Observer Pattern**: Notifies students of changes in course sections, such as section ID, building, or room changes.
- **Strategy Pattern**: Allows the selection of different enrollment strategies at runtime, enhancing flexibility and decoupling the enrollment behavior from the student class.


## Design Patterns

### Singleton Pattern

- **Intent**: Ensure a class has only one instance and provide a global point of access to it.
- **Implementation in Project**: The `DataStore` class uses the Singleton pattern to manage course sections. It ensures that only one instance of the data store exists, providing consistent access to course data throughout the application.
- **Key Role in the Project**: Manages course data consistently and efficiently, preventing data conflicts.

### Factory Method Pattern

- **Intent**: Define an interface for creating an object, but let subclasses alter the type of objects that will be created.
- **Implementation in Project**: Implemented by creating `CourseSectionCreator`, `LectureCourseSectionCreator`, and `LabCourseSectionCreator` classes to handle the creation of different course sections.
- **Key Role in the Project**: Simplifies the creation process for different types of course sections, ensuring flexibility and scalability.

### Adapter Pattern

- **Intent**: Convert the interface of a class into another interface that clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
- **Implementation in Project**: The `AddressAdapter` class adapts the `Address` class to the `ExternalAddress` interface.
- **Key Role in the Project**: Allows integration with external systems without modifying the existing codebase.

### Decorator Pattern

- **Intent**: Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
- **Implementation in Project**: The `CapacityDecorator` class adds a capacity constraint to course sections.
- **Key Role in the Project**: Enhances the course section functionality dynamically by enforcing enrollment limits.

### Observer Pattern

- **Intent**: Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- **Implementation in Project**: The `CourseSection` class notifies `StudentObserver` instances of changes.
- **Key Role in the Project**: Keeps students informed about changes in course sections, ensuring they have up-to-date information.

### Strategy Pattern

- **Intent**: Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from the clients that use it.
- **Implementation in Project**: Implemented by creating different enrollment strategies (e.g., `SimpleEnrollmentStrategy` and `PriorityEnrollmentStrategy`) and applying them to students.
- **Key Role in the Project**: Allows the selection of different enrollment strategies at runtime, enhancing flexibility and decoupling the enrollment behavior from the student class.

## Installation

1. Clone the repository:
```sh
git clone <repository-url>
```

2. Navigate to the project directory:
```sh
cd course-enrollment-system 
```

3. Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse).


## Usage
### Running the Tests
You can run the tests provided in the TestClass to verify the implementation of the design patterns.

## Test Methods
- testSingletonPattern: Verifies that the DataStore class follows the Singleton pattern.
- testFactoryMethodPattern: Verifies the creation of course sections using the Factory Method pattern.
- testAdapterPattern: Verifies the functionality of the Adapter pattern.
- testDecoratorPattern: Verifies the functionality of the Decorator pattern.
- testObserverPattern: Verifies the functionality of the Observer pattern.
- testStrategyPattern: Verifies the functionality of the Strategy pattern.


### Sample Test Output
```
Testing Singleton Pattern:
Is DataStore a singleton? true
Expected: true

Testing Factory Method Pattern:
Created Lecture Section: CourseSection{courseId='CSC101', courseName='Introduction to Computer Science', sectionId='FJT01', days='MWF', startTime='10AM', building='Building A', room='Room 101'}
Expected: CourseSection{courseId='CSC101', courseName='Introduction to Computer Science', sectionId='FJT01', days='MWF', startTime='10AM', building='Building A', room='Room 101'}
Created Lab Section: CourseSection{courseId='CSC101', courseName='Introduction to Computer Science Lab', sectionId='LAB01', days='TTH', startTime='2PM', building='Building B', room='Room 102'}
Expected: CourseSection{courseId='CSC101', courseName='Introduction to Computer Science Lab', sectionId='LAB01', days='TTH', startTime='2PM', building='Building B', room='Room 102'}

Testing Adapter Pattern:
Adapted address: 123 Main St, Springfield, IL 62704
Expected: 123 Main St, Springfield, IL 62704

Testing Decorator Pattern:
Expected exception: Section is full!
Enrolled students in course section:
John Doe
Jane Smith
Expected: John Doe, Jane Smith

Testing Observer Pattern:
Notification for student 1001: New student enrolled: John Doe
Notification for student 1002: New student enrolled: John Doe
Notification for student 1001: New student enrolled: Jane Smith
Notification for student 1002: New student enrolled: Jane Smith
Notification for student 1001: Section ID changed to: FJT03
Notification for student 1002: Section ID changed to: FJT03
Notification for student 1001: Building changed to: Building C
Notification for student 1002: Building changed to: Building C
Notification for student 1001: Room changed to: Room 303
Notification for student 1002: Room changed to: Room 303
Notification for student 1002: Building changed to: Building D

Testing Strategy Pattern:
Enrolling student with Simple Enrollment Strategy
Student John Doe enrolled in: CSC101 Introduction to Computer Science
Enrolling student with Priority Enrollment Strategy
Student Jane Smith enrolled in: CSC102 Data Structures
Expected: Students enrolled according to their respective strategies
```


## Contributing
Contributions are welcome! Please open an issue or submit a pull request if you have suggestions for improvements or new features.

## License
This project is licensed under the MIT License. See the LICENSE file for details.
