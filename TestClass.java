
//this program was created by ADAM DUEHRING
//this program will allow the user to enter in information about themselves and register for course selections.

import java.util.Scanner;

public class TestClass
{
    public static void main(String[] args) throws java.text.ParseException
    {

        Scanner userinput  = new Scanner(System.in);
        //get user id
        System.out.println("Thank you for choosing GTCC! \n" +
                "Please enter your student ID: ");
        //set student1 and put user input into id
        Student student1 = new Student(userinput.next());

        //checks if the id doesn't match any actual number or if its empty
        while (!student1.getId().matches(".*\\d.*") || student1.getId().matches(""))
        {
            System.out.println("Please Enter a Number!: ");
            student1.setId(userinput.nextLine());
        }
        userinput.nextLine();


        //user name
        System.out.println("Enter your first name: ");
        student1.setFirstName(userinput.nextLine());

        //checks if matches any actual number or if its empty
        while (student1.getFirstName().matches(".*\\d.*") || student1.getFirstName().matches(""))
        {
            System.out.println("Please Enter a Non-numeric value!: ");
            student1.setFirstName(userinput.nextLine());
        }


        //user last name
        System.out.println("Enter Your Last Name: ");
        student1.setLastName(userinput.next());

        //checks if matches any actual number or if its empty
        while (student1.getLastName().matches(".*\\d.*") || student1.getLastName().matches(""))
        {
            System.out.println("Please Enter a Non-numeric value!: ");
            student1.setLastName(userinput.next());
        }
        userinput.nextLine();

        //user address
        System.out.println("Enter Your Street Address: ");
        Address ad2 = new Address();
        ad2.setStreet(userinput.nextLine());

        //checks if street is empty
        while (ad2.getStreet().isEmpty())
        {
            System.out.println("Please Enter an Address: ");
            ad2.setStreet(userinput.nextLine());
        }

        //user city
        System.out.println("Enter Your City: ");
        ad2.setCity(userinput.nextLine());

        //checks if matches any actual number or if its empty
        while (ad2.getCity().matches(".*\\d.*") || ad2.getStreet().matches(""))
        {
            System.out.println("Please Enter a City: ");
            ad2.setCity(userinput.nextLine());
        }

        //user state
        System.out.println("Enter Your State: ");
        ad2.setState(userinput.nextLine());

        //checks if matches any actual number or if its empty
        while (ad2.getState().matches(".*\\d.*") || ad2.getState().matches(""))
        {
            System.out.println("Please Enter a State: ");
            ad2.setState(userinput.nextLine());
        }


        //user zip
        System.out.println("Enter Your Zip Code: ");
        ad2.setZipCode(userinput.nextLine());

        //checks if it doesnt match any actual number or if its empty
        while (ad2.getZipCode().matches("") || !ad2.getZipCode().matches(".*\\d.*"))
        {
            System.out.println("Please Enter a Zip: ");
            ad2.setState(userinput.nextLine());
        }


        // set student address
        student1.setAddress(ad2);

        //menu driven program

        //this stores our datastore into an accessible array
        DataStore ds1 = DataStore.getInstance();
        CourseSection [] myMenu = ds1.getSections();

        //outputs the array in a nice manner
        for (int i=0; i<myMenu.length;i++) {
            System.out.println(i+1 + "). "+ myMenu[i].toString() + '\n'+  "_______________________________________________");

        }
        System.out.println("0). Finished" + '\n');
        String classEnroll = "";

        //while class enroll isn't 'quit' execute as follows
        while (!classEnroll.equals("quit")) {

            System.out.println("Please enter a number based on the above classes to enroll in to a max of 5, Press '0' to finish: ");
            classEnroll = userinput.next();

            //parse classEnroll into integer and have it relate to array according to number inserted -1
            int result = Integer.parseInt(classEnroll);
            //if user quits, change classEnroll to quit, exit while loop
            if (result == 0) {
                classEnroll = "quit";
            }
            //if not 0, create a new course section, and pull field from the myMenu array according to result - 1, since array starts at zero and zero is used to quit.
            else {
                CourseSection sec = new CourseSection(myMenu[result - 1].getCourseId(), myMenu[result - 1].getCourseName(), myMenu[result - 1].getCourseId(), myMenu[result - 1].getDays(), myMenu[result - 1].getStartTime(), myMenu[result - 1].getBuilding(), myMenu[result - 1].getRoom());
               //once the course selection is made, try to enroll student.
                try {
                    student1.addCourse(sec);
                }
                //when trying to enroll, if there were too many enrolled classes, execute as follows
                catch (CourseException tm) {
                    System.out.println(tm.getMessage());
                }
                //when enrolling, if duplicate class, execute as follows
                catch (DuplicateException de) {
                    System.out.println(de.getMessage());
                }
            }


        }

        //prints out student with all enrolled attributes.
        System.out.println(student1.toString());
    }
}
