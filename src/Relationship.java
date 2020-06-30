import java.util.*;
public class Relationship {

    Map<String, List<String>> parentMap = new HashMap<String, List<String>>();
    Map<String, List<String>> childMap = new HashMap<String, List<String>>();
    public Relationship()
    {
    }

    public Relationship(String path)
    {

        //Reads data, catches error reading data
        try{
            readData(path);
        }
        catch (Exception ex)
        {
            System.out.println("Error reading data from Relationship file!");
            System.out.println(ex.getMessage());
        }
    }

    public void readData(String path) throws java.io.IOException
    {

        java.io.File relationshipFile = new java.io.File(path);
        Scanner rFile = new Scanner(relationshipFile);


        String line;
        int l = 0;
        while (rFile.hasNext())
        {
            line = rFile.nextLine();
            l++;
            //Skips first line of file
            if (l == 1)
                continue;

            //System.out.println(line);
            String splitLine[] = line.split("\t");

            if (splitLine[2].equals("0"))
                continue;

            if (splitLine[7].equals("116680003")) //Relationship is hierarchical
            {
                //Tree (graph) is another option here for the hierarchical
                if (!parentMap.containsKey(splitLine[4]))
                {
                    //If value isn't in map, add it and create a new list
                    parentMap.put(splitLine[4], new ArrayList<>());
                    //Add value to new array
                    parentMap.get(splitLine[4]).add(splitLine[5]);
                }
                else
                {
                    //If key already exists, just add to list
                    parentMap.get(splitLine[4]).add(splitLine[5]);
                }

                //Add to map?
                if (!childMap.containsKey(splitLine[5]))
                {
                    //If value isn't in map, add it and create a new list
                    childMap.put(splitLine[5], new ArrayList<>());
                    //Add value to new array
                    childMap.get(splitLine[5]).add(splitLine[4]);
                }
                else
                {
                    //If key already exists, just add to list
                    childMap.get(splitLine[5]).add(splitLine[4]);

                }
            }

        }

    }
    //Called when user enters string, returns map with relationship groups and data concatenated in a String
    public Map<String, String> getAttributes(Description d, String path, String ID) throws java.io.IOException
    {
        //Variable declarations
        Map<String, String> tempMap = new HashMap<>();
        java.io.File relationshipFile = new java.io.File(path);
        Scanner rFile = new Scanner(relationshipFile);

        String line;
        int l = 0;
        while (rFile.hasNext())
        {
            line = rFile.nextLine();
            l++;
            //Skips first line
            if (l == 1)
                continue;

            //System.out.println(line);
            String splitLine[] = line.split("\t");

            //If concept ID is equal to user entered, active and typeID isn't hierarchical
            if (splitLine[4].equals(ID) && splitLine[2].equals("1") && !splitLine[7].equals("116680003"))
            {
                String temp = tempMap.get(splitLine[6]);
                String temp2;
                if (temp == null)
                {
                    //Temporary variable to hold concatenated data
                    temp2 = d.getTerm(splitLine[7]) + " -> " + d.getTerm(splitLine[5]) + "\n";
                }
                else
                    temp2 = temp + d.getTerm(splitLine[7]) + " -> " + d.getTerm(splitLine[5]) + "\n";

                //Adds relationship group and concatenated data to map
                tempMap.put(splitLine[6], temp2);

            }

        }
        return tempMap; //Returns map to main method
    }

}
