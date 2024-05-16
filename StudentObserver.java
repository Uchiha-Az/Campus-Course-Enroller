public class StudentObserver implements Observer {
    private String studentId;

    public StudentObserver(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for student " + studentId + ": " + message);
    }
}
