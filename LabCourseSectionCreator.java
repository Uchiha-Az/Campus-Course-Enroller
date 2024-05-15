public class LabCourseSectionCreator extends CourseSectionCreator {
    @Override
    public CourseSection createCourseSection(String courseId, String courseName, String sectionId, String days, String startTime, String building, String room) {
        return new CourseSection(courseId, courseName, sectionId, days, startTime, building, room);
    }
}