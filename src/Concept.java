import java.util.*;

public class Concept {

    protected List<String> conceptsList = new ArrayList<>();

    //Create an empty concept object
    public Concept()
    {
    }

    //Constructor that uses path to read file data
    public Concept(String path)
    {
        //Reads data from file, catches error reading data
        try{
            readData(path);
        }
        catch (Exception ex)
        {
            System.out.println("Error reading data from concept file!");
            System.out.println(ex.getMessage());
        }



    }


    public void readData(String path) throws java.io.IOException
    {
        java.io.File conceptsFile = new java.io.File(path);
        Scanner cFile = new Scanner(conceptsFile);


        String line;
        int l = 0;
        while (cFile.hasNext())
        {
            line = cFile.nextLine();
            l++;
            //Skips first line of file
            if (l == 1)
                continue;

            //System.out.println(line);
            String splitLine[] = line.split("\t");
            if (splitLine[2].equals("1"))
                conceptsList.add(splitLine[0]);

        }

    }

    //Check if the concept is active and exists, if so return true
    public boolean activeAndExists(String id)
    {
        if (conceptsList.contains(id))
            return true;
        return false;
    }


}
