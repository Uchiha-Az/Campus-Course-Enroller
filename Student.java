import java.util.Arrays;
import java.util.Date;

//student class extends Person
public class Student extends Person
{
    private String id;
    private CourseSection [] sections = new CourseSection[5];
    private int numberEnrolled;

    //default constructor
    public Student() {
        this("0000");
    }
    //designated constructor
    public Student (String id)
    {
        this.id = id;
        for (int i =0; i<sections.length; i++)
        {
            sections[i] = new CourseSection();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addCourse(CourseSection cs) throws CourseException, DuplicateException
    {
        try {
            for (int i=0; i<numberEnrolled; i++)
            {
                if (sections[i].getSubject().equals(cs.getSubject()) &&
                        sections[i].getNumber().equals(cs.getNumber()))
                {
                    throw new DuplicateException("Duplicate Classes Enrolled!: ", cs);
                }
            }
            sections[numberEnrolled] = cs;
            numberEnrolled++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new CourseException("Too many Classes!");
        }
    }

    @Override
    public String toString() {
        return
                super.toString() +
                "Id: " + id + '\n' +
                "Sections: " + '\n' + Arrays.toString(sections) .replace(",", "")  //remove the commas
                        .replace("[", "")  //remove the right bracket
                        .replace("]", "")  //remove the left bracket
                        .trim()  + '\n';

    }
}
