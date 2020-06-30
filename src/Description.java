import java.util.*;

public class Description {
    protected Map<String, String> descriptionMap = new HashMap<String, String>();

    public Description()
    {
    }

    public Description (String path)
    {
        //Reads data from file, catches error reading data
        try{
            readData(path);
        }
        catch (Exception ex)
        {
            System.out.println("Error reading data from description file!");
            System.out.println(ex.getMessage());
        }
    }

    public void readData(String path) throws java.io.IOException
    {
        //Reads data from description file
        java.io.File descriptionFile = new java.io.File(path);
        Scanner dFile = new Scanner(descriptionFile);


        String line;
        int l = 0;
        //Loops through entire description file
        while (dFile.hasNext())
        {
            line = dFile.nextLine();
            l++;
            //Skips first line of file
            if (l == 1)
                continue;

            //Parses line, separated by tabs
            String splitLine[] = line.split("\t");
            if (splitLine[2].equals("1") && splitLine[6].equals("900000000000003001"))
            {
                //If active and type ID equals above, add to description map
                descriptionMap.put(splitLine[4], splitLine[7]);

            }

        }

    }

    //Check if ID exists and is active in the description map
    public boolean activeAndExists(String id)
    {
        if (descriptionMap.containsKey(id))
            return true;
        return false;
    }

    //Returns a specific term from the description map given a concept ID
    public String getTerm(String conceptID)
    {
        return descriptionMap.get(conceptID);
    }


}
