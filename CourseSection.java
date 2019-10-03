public class CourseSection extends Course
{
    private String id;
    private String days;
    private String startTime;
    private String building;
    private String room;

    public CourseSection () {

    }

    public CourseSection (String subject, String number, String name,
                         String id, String days, String startTime, String building,
                         String room) {
        super(subject, number, name);
        this.id = id;
        this.days = days;
        this.startTime = startTime;
        this.building = building;
        this.room = room;
    }

    public CourseSection(Course c, String id, String days, String startTime, String building, String room) {
        this.id = id;
        this.days = days;
        this.startTime = startTime;
        this.building = building;
        this.room = room;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
        return
                super.toString() +
                " " + id +
                " " + days +
                " " + startTime +
                " " + building +
                " " + room;
    }
}
