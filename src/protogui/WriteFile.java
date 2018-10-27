/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protogui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Thomas
 */
public class WriteFile {

    
    BufferedWriter file;
    public int totalProblems = 0;
    
    public void startFile() throws IOException {
        file = new BufferedWriter(new FileWriter("output.html"));
        file.write("<html>\n");
        file.write("<header><title>MathProblemGenerator</title></header>\n");
        file.write("<body>\n");
        file.write("Name_____________<br>\n");
        
        file.write("<style>\n");
        file.write("* {\n");
        file.write("box-sizing: border-box;\n");
        file.write("}\n");

        /* Create two equal columns that floats next to each other */
        file.write(".column {\n");
        file.write("float: left;\n");
        file.write("width: 50%;\n");
        file.write("padding: 10px;\n");

        file.write("}\n");

        /* Clear floats after the columns\n */
        file.write(".row:after {\n");
        file.write("content: \"\";\n");
        file.write("display: table;\n");
        file.write("clear: both;\n");
        file.write("}\n");
        file.write("</style>\n");
        
        file.write("<div class=\"row\">\n"); // start of column 1
        file.write("<div class=\"column\" style=\"background-color:#FFFFFF;\">\n");
        
        
        

    }

    public void writeFile(int additionProblems,int subtractionProblems, int multiplicationProblems,int divisionProblems) throws IOException//writes the file to html
    {
        MathFunctions mathFunctions = new MathFunctions();
        
        int additionColumn1;
        if(additionProblems % 2 == 1)
            additionColumn1 = (additionProblems / 2) + 1;
        else 
            additionColumn1 = (additionProblems / 2);
        int additionColumn2 = additionProblems / 2;
        
        int subtractionColumn1;
        if(subtractionProblems % 2 == 1)
            subtractionColumn1 = (subtractionProblems / 2) + 1;
        else 
            subtractionColumn1 = (subtractionProblems / 2);
        int subtractionColumn2 = subtractionProblems / 2;
        
        int multiplicationColumn1;
        if(multiplicationProblems % 2 == 1)
            multiplicationColumn1 = (multiplicationProblems / 2) + 1;
        else 
            multiplicationColumn1 = (multiplicationProblems / 2);
        int multiplicationColumn2 = multiplicationProblems / 2;
        
        int divisionColumn1;
        if(divisionProblems % 2 == 1)
            divisionColumn1 = (divisionProblems / 2) + 1;
        else 
            divisionColumn1 = (divisionProblems / 2);
        int divisionColumn2 = divisionProblems / 2;
        
        

        
        for (int i = 0; i < additionColumn1; i++) //generates a number of problems based on what the user specified
        {
            file.write(mathFunctions.generateAddition(totalProblems + 1));//passing i through to generate problem number; +1 to start at problem 1
            file.write("<br>");//giving student space to work
            file.write("<br>");  
            file.write("<br>");  
            file.write("<br>");  
            totalProblems++;
            file.newLine();
        }


        for (int i = 0; i < subtractionColumn1; i++) //generates a number of problems based on what the user specified
        {
            file.write(mathFunctions.generateSubtraction(totalProblems + 1));
            totalProblems++;
            file.write("<br>");
            file.write("<br>");  
            file.write("<br>");  
            file.write("<br>"); 
            file.newLine();

        }


        for (int i = 0; i < multiplicationColumn1; i++) //generates a number of problems based on what the user specified
        {
            file.write(mathFunctions.generateMultiplication(totalProblems + 1));
            file.write("<br>");
            file.write("<br>");  
            file.write("<br>");  
            file.write("<br>"); 
            totalProblems++;
            file.newLine();

        }


        for (int i = 0; i < divisionColumn1; i++) //generates a number of problems based on what the user specified
        {
            file.write(mathFunctions.generateDivision(totalProblems + 1));
            file.write("<br>");
            file.write("<br>");  
            file.write("<br>");  
            file.write("<br>"); 
            totalProblems++;
            file.newLine();

        }

        file.write("</div>\n");//end of column1
        file.write("<div class=\"column\" style=\"background-color:#FFFFFF;\">\n"); //start of column2

        for (int i = 0; i < additionColumn2; i++) //generates a number of problems based on what the user specified
        {
            file.write(mathFunctions.generateAddition(totalProblems + 1));//passing i through to generate problem number; +1 to start at problem 1
            file.write("<br>");
            file.write("<br>");  
            file.write("<br>");  
            file.write("<br>"); 
            totalProblems++;
            file.newLine();
        }


        for (int i = 0; i < subtractionColumn2; i++) //generates a number of problems based on what the user specified
        {
            file.write(mathFunctions.generateSubtraction(totalProblems + 1));
            file.write("<br>");
            file.write("<br>");  
            file.write("<br>");  
            file.write("<br>"); 
            totalProblems++;
            file.newLine();

        }


        for (int i = 0; i < multiplicationColumn2; i++) //generates a number of problems based on what the user specified
        {
            file.write(mathFunctions.generateMultiplication(totalProblems + 1));
            file.write("<br>");
            file.write("<br>");  
            file.write("<br>");  
            file.write("<br>"); 
            totalProblems++;
            file.newLine();

        }

        for (int i = 0; i < divisionColumn2; i++) //generates a number of problems based on what the user specified
        {
            file.write(mathFunctions.generateDivision(totalProblems + 1));
            file.write("<br>");
            file.write("<br>");  
            file.write("<br>");  
            file.write("<br>"); 
            totalProblems++;
            file.newLine();

        }    

        file.write("</div>\n");//end of column2
        file.write("</div>\n");
        
    }

    public void endFile() throws IOException {
        file.write("<body>\n");
        file.write("<html>\n");
        file.close();
    }
}