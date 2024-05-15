import java.util.ArrayList;
import java.util.List;

public class CourseSection extends Course implements Section {
    private String sectionId;
    private String days;
    private String startTime;
    private String building;
    private String room;
    private List<Student> enrolledStudents;


    public CourseSection(){

    }


    public CourseSection(String courseId, String courseName, String sectionId, String days, String startTime, String building, String room) {
        super(courseId, courseName); // Calls the constructor of the parent class (Course)
        this.sectionId = sectionId;
        this.days = days;
        this.startTime = startTime;
        this.building = building;
        this.room = room;
        this.enrolledStudents = new ArrayList<>();
    }



    @Override
    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
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
    }

    @Override
    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
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
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
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
}
