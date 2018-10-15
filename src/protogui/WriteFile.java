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

    public void writeFile(int additionProblems) throws IOException//writes the file to text: research pdf 
    {    
        MathFunctions mathFunctions = new MathFunctions();
        BufferedWriter file = new BufferedWriter(new FileWriter("output.html"));
        file.write("<html>\n");
        file.write("<header><title>MathProblemGenerator</title></header>\n");
        file.write("<body>\n");
        file.write("Name_____________<br>\n");
        int range = (additionProblems);
         //Range cuts the desired number of problems in third
         //This creates an equal number of addition, subtraction, and multiplication problems
            for (int i = 0; i < range; i++) //generates a number of problems based on what the user specified
            {
                file.write(mathFunctions.generateAddition(i+1));//passing i through to generate problem number; +1 to start at problem 1
                file.newLine();                             
            }
            /*
            for (int i = 0; i < range; i++) //generates a number of problems based on what the user specified
            {
                file.write(mathFunctions.generateSubtraction());
                file.newLine();
                             
            }
            
            for (int i = 0; i < range; i++) //generates a number of problems based on what the user specified
            {
                file.write(mathFunctions.generateMultiplication());
                file.newLine();
                             
            }
            */
            file.write("<body>\n");
            file.write("<html>\n");
            file.close();  
    }
}
