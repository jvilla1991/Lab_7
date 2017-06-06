import java.util.Scanner;

/**
 * Created by Admin on 4/17/2017.
 */

// Write a Program that recognizes invalid inputs when the user requests informations about student in class.

public class Main {

    private static int studentNumber;



    public static void setStudentNumber(int userNum)
    {
        studentNumber = userNum;
        return;
    }

    public static String getName(int studentNumber)
    {
        switch (studentNumber)
        {
            case 1:
                return "Carl";
            case 2:
                return "Josh";
            case 3:
                return "Lexi";
            case 4:
                return "Carolyn";
            case 5:
                return "Irene";
            default:
                return "";
        }
    }

    public static String studentFavoriteFood(int studentNumber)
    {
        switch (studentNumber)
        {
            case 1:
                return "Carl is really into pudding.";
            case 2:
                return "Josh gorges himself on pizza.";
            case 3:
                return "Lexi keeps it simple with Spaghetti";
            case 4:
                return "Carolyn likes Swedish Fish";
            case 5:
                return "Irene really likes Nachos";
            default:
                return "";
        }
    }

    public static String studentHometown(int studentNumber)
    {
        switch (studentNumber)
        {
            case 1:
                return "Carl is from New York, the Big Apple";
            case 2:
                return "Josh hails from Ontario, Canada - North of the Wall";
            case 3:
                return "Lexi is from Roseville";
            case 4:
                return "Carolyn is from Livonia";
            case 5:
                return "Irene is from Mexico City, south of the border.";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        boolean bool = true;

        try
        {
            // We ask the user to enter a student number, this also includes an exception to be thrown if the user doesn not enter properly
            do {
                System.out.println("Student List:");
                System.out.println("1 - Carl");
                System.out.println("2 - Josh");
                System.out.println("3 - Lexi");
                System.out.println("4 - Carolyn");
                System.out.println("5 - Irene");
                System.out.println("Input a number that corresponds to the student: ");
                int userNumber = scnr.nextInt();
                if (!(userNumber > 0 & userNumber < 6))
                {
                    throw new Exception("Invalid Integer!!");
                }

                // The user's selected number becomes the student number that is select via a setter method
                setStudentNumber(userNumber);

                // This method is passed around throughout the rest of the program in the form of a getter method.
                System.out.println("The student you chose is " + getName(studentNumber) + ".");

                // The user must choose an option to learn more about a student
                System.out.println("");
                System.out.println("Would you like to know more about " + getName(studentNumber) + "?");
                System.out.println("Enter 1 for favorite food. Enter 2 for hometown");
                int i = scnr.nextInt();
                if (!(i > 0 && i < 3))
                {
                    throw new Exception("Invalid Integer!!");
                }

                // Depending on the user's choice, and assuming the user has added an appropriate integer, the output can be one of two method, both of which are simply strings
                switch (i)
                {
                    case 1:
                        System.out.println(studentFavoriteFood(studentNumber));
                        break;
                    case 2:
                        System.out.println(studentHometown(studentNumber));
                        break;
                    default:
                        return;
                }

                scnr.nextLine();

                // Finally, we ask if the user wants to know more about another student, thus repeating the process again.
                System.out.println("Would you like to know more about another student? (y/n)?");
                String s = scnr.nextLine();
                if ("y".equalsIgnoreCase(s))
                {
                    continue;
                }
                else if ("n".equalsIgnoreCase(s))
                {
                    System.out.println("Goodbye");
                    bool = false;
                }
                else
                {
                    throw new Exception("Invalid input!");
                }
            } while(bool == true);
        } catch (Exception e)
        {
            System.out.println("");
            System.out.println(e.toString());
            System.out.println("Invalid Input...");
            System.out.println("Shutting down...");
        }

    }
}
