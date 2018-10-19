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

    }

    public void writeFile(int problems, String type) throws IOException//writes the file to html
    {
        MathFunctions mathFunctions = new MathFunctions();
        

        if (type.equals("addition")) {
            for (int i = 0; i < problems; i++) //generates a number of problems based on what the user specified
            {
                file.write(mathFunctions.generateAddition(totalProblems + 1));//passing i through to generate problem number; +1 to start at problem 1
                totalProblems++;
                file.newLine();
            }
        }//if
        else if (type.equals("subtraction")) {
            for (int i = 0; i < problems; i++) //generates a number of problems based on what the user specified
            {
                file.write(mathFunctions.generateSubtraction(totalProblems + 1));
                totalProblems++;
                file.newLine();

            }
        }//else if
        else if (type.equals("multiplication")) {
            for (int i = 0; i < problems; i++) //generates a number of problems based on what the user specified
            {
                file.write(mathFunctions.generateMultiplication(totalProblems + 1));
                totalProblems++;
                file.newLine();

            }
        }//else if
        else if (type.equals("division")) {
            for (int i = 0; i < problems; i++) //generates a number of problems based on what the user specified
            {
                file.write(mathFunctions.generateDivision(totalProblems + 1));
                totalProblems++;
                file.newLine();

            }
        }//else if
    }

    public void endFile() throws IOException {
        file.write("<body>\n");
        file.write("<html>\n");
        file.close();
    }
}