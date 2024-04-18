public class LabCourseSectionCreator extends CourseSectionCreator {
    @Override
    public CourseSection createCourseSection(String subject, String number, String name, String id, String days,
            String startTime, String building, String room) {
        return new CourseSection(subject, number, name, id, days, startTime, building, room);
    }
}
