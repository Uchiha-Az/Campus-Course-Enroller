public class DuplicateException extends Exception
{
    public DuplicateException (String message, CourseSection c)
    {
        super(message + " " + c.getSectionId());
    }

}
