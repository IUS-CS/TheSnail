# Current Design Pattern  
Singleton with Elements of Template Method.  
There should only be one instance of our Layout class. It will call and instance of our MathFunctions and WriteFile classes.
The LayoutClass which creates the Window in which users interact with will act as the global access point to the rest of the project.
All input will be handled through the Layout. 
# Potential Additional Designs   
If we divided our MathFunctions class into smaller more specialized classes the bridge structure could be used to help define hierarchy.
# Plans for Future Design  
The next immediate steps in our modules will be basic algebra of solving for a variable. Our modules will try to build upon the last ones with increasing complexity using our current design pattern.
 
