import java.util.ArrayList;
import java.util.List;

public class CourseSection extends Course implements Section, Subject {
    private String sectionId;
    private String days;
    private String startTime;
    private String building;
    private String room;
    private List<Student> enrolledStudents;
    private List<Observer> observers;


    public CourseSection(){
        super("", "");
        this.sectionId = "";
        this.days = "";
        this.startTime = "";
        this.building = "";
        this.room = "";
        this.enrolledStudents = new ArrayList<>();
        this.observers = new ArrayList<>();
    }


    public CourseSection(String courseId, String courseName, String sectionId, String days, String startTime, String building, String room) {
        super(courseId, courseName); // Calls the constructor of the parent class (Course)
        this.sectionId = sectionId;
        this.days = days;
        this.startTime = startTime;
        this.building = building;
        this.room = room;
        this.enrolledStudents = new ArrayList<>();
        this.observers = new ArrayList<>();
    }



    @Override
    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
        notifyObservers("Section ID changed to: " + sectionId);
    }


    @Override
    public Course getCourse() {
        return this;
    }

    @Override
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    @Override
    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        notifyObservers("New student enrolled: " + student.getFirstName() + " " + student.getLastName());
    }

    @Override
    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
        notifyObservers("Student removed: " + student.getFirstName() + " " + student.getLastName());
    }
    // Additional getters and setters for other properties
    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
        notifyObservers("Building changed to: " + building);
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
        notifyObservers("Room changed to: " + room);
    }

    @Override
    public String toString() {
        return "CourseSection{" +
                "courseId='" + getCourseId() + '\'' +
                ", courseName='" + getCourseName() + '\'' +
                ", sectionId='" + sectionId + '\'' +
                ", days='" + days + '\'' +
                ", startTime='" + startTime + '\'' +
                ", building='" + building + '\'' +
                ", room='" + room + '\'' +
                '}';
    }


    // Observer methods
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
