import java.util.Scanner;
import java.util.*;
public class Main {

    public static void main(String[] args) throws java.io.IOException
    {
        //Paths to data. ENTER PATHS TO DATA HERE
        String rPath = "";
        String dPath = "";
        String cPath = "";
        Concept c = new Concept(cPath);

        Description d = new Description(dPath);

        Relationship r = new Relationship(rPath);


        Scanner userInput = new Scanner(System.in);
        String inputStr;


        //Prompt user until they enter the term "exit"
        do{
            System.out.print("Enter a source ID: ");
            inputStr = userInput.nextLine();

            //Break if user enters exit
            if (inputStr.equals("exit"))
                    return;

            //If input is not active or does not exist
            if (!c.activeAndExists(inputStr) && !inputStr.equals("exit"))
            {
                System.out.println("ID does not exist or is not active. ");
                continue;
            }

            System.out.println("The FSN IS: " + d.getTerm(inputStr) + "\n");


            List<String> returnedList;



            //Get parents from Relationship class, outputs to user
            returnedList = r.parentMap.get(inputStr);
            System.out.println("List of parents: ");
            if (returnedList != null)
            {
                for (int i = 0; i < returnedList.size(); i++)
                    System.out.println(d.getTerm(returnedList.get(i)) + " ");
            }
            System.out.println();

            //Gets children from relationship class, outputs to user
            System.out.println("List of Children: ");
            returnedList = r.childMap.get(inputStr);
            if (returnedList != null)
            {
                for (int i = 0; i < returnedList.size(); i++)
                    System.out.println(d.getTerm(returnedList.get(i)) + " ");
            }
            System.out.println();


            //Gets attributes from relationship class in a map, outputs to user
            System.out.println("List of Attributes: ");
            Map<String, String> returnedMap = r.getAttributes(d, rPath, inputStr);
            int count = 1;

            //Print attribute groups from map
            for (Map.Entry<String, String> entry : returnedMap.entrySet())
            {
                System.out.println("Group " + count);
                System.out.print(entry.getValue());
                count++;
            }
        System.out.println();


        }while (!userInput.equals("exit"));


    }
}
