# Snomed-Finder
A program designed using Snomed CT data to list the parents, children and attribute groups of a given concept ID. Snomed CT can be found here: https://browser.ihtsdotools.org

# What is Snomed CT?
Snomed CT is a database designed for referencing medical terminology and the relationships between medical terms and descriptions. Each term is called a concept, and each
concept can have parents, children and relationships with other concepts. 

# What does this program do?
My program takes a concept ID and outputs the parents, children and relationship groups that the given medical term has. 

# How does it work?
The program uses text files containing the data from the Snomed CT database. In the config.json file you can put the paths to the data from the three snomed CT files: Concepts, Descriptions and Relationships. 

# What I learned
* How to properly design and implement object oriented techniques to handle and analyze large sets of data. 
* Optimize efficiency and runtime using large data sets
* Analyze the relationships between data in large data sets

# Example Input/Output

![Example 1](https://github.com/ECiccotelli/Snomed-Finder/blob/master/resources/171221008.PNG)

![Example 2](https://github.com/ECiccotelli/Snomed-Finder/blob/master/resources/423998007.PNG)

![Example 3](https://github.com/ECiccotelli/Snomed-Finder/blob/master/resources/732967004.PNG)


