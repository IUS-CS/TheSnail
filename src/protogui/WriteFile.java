/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template questions, choose Tools | Templates
 * and open the template in the editor.
 */
package protogui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.*;

/**
 *
 * @author Thomas
 */
public class WriteFile {

    
    BufferedWriter questions;
    BufferedWriter solutions;
    public int totalProblems;
    Padding paddingObj = new Padding();
    Addition addition = new Addition();
    Subtraction subtraction = new Subtraction();
    Multiplication multiplication = new Multiplication();
    Division division = new Division();

    
    public void file() throws IOException 
    {
        questions = new BufferedWriter(new FileWriter("questions.html"));
        solutions = new BufferedWriter(new FileWriter("solutions.html"));
        startColumn(questions);
        startColumn(solutions);
    }

    public void writeFile(int additionProblems,int subtractionProblems, int multiplicationProblems,int divisionProblems, int exponentProblems, 
            String addDiff, String subDiff, String multDiff, String divDiff, String expDiff) throws IOException
//writes the questions to html
    {
        
        
        totalProblems = 1;
        
        column(additionProblems, subtractionProblems, multiplicationProblems, divisionProblems, exponentProblems, 
            addDiff, subDiff, multDiff, divDiff, expDiff);

        //end of column1
        
        switchColumn(questions);
        switchColumn(solutions);
        
        //start of column2
        totalProblems = 2;
        column(additionProblems, subtractionProblems, multiplicationProblems, divisionProblems, exponentProblems, 
            addDiff, subDiff, multDiff, divDiff, expDiff);

        endColumn(questions);
        endColumn(solutions);
    }

    public void endFile() throws IOException {
        questions.write("<body>\n");
        questions.write("<html>\n");
        questions.close();
        solutions.write("<body>\n");
        solutions.write("<html>\n");
        solutions.close();
    }
    
    public void startColumn(BufferedWriter file) throws IOException
    {
        file.write("<html>\n");
        file.write("<header><title>MathProblemGenerator</title></header>\n");
        file.write("<body>\n");
        file.write("Name_____________<br>\n");

        file.write("<style>\n");
        file.write("* {\n");
        file.write("box-sizing: border-box;\n");
        file.write("}\n");

        //creates file two equal columns that floats next to each other */
        file.write(".column {\n");
        file.write("float: left;\n");
        file.write("width: 50%;\n");
        file.write("padding: 10px;\n");

        file.write("}\n");

        file.write(".row:after {\n");
        file.write("content: \"\";\n");
        file.write("display: table;\n");
        file.write("clear: both;\n");
        file.write("}\n");
        file.write("</style>\n");

        file.write("<div class=\"row\">\n"); // start of column 1
        file.write("<div class=\"column\" style=\"background-color:#FFFFFF;\">\n");
    }
    
    public void switchColumn(BufferedWriter file) throws IOException
    {
        file.write("</div>\n");
        file.write("<div class=\"column\" style=\"background-color:#FFFFFF;\">\n");
    }
        
    public void endColumn(BufferedWriter file) throws IOException
    {
       file.write("</div>\n");//end of column2
        
       file.write("</div>\n");
    }
    public void basicArithmeticGeneration(String problem) throws IOException
    {
        
        questions.write(problem + "<br>" + "\n");
            for(int j = 0; j < 4; j++)
                questions.write("<br>" + "\n");//giving student space to work           
            totalProblems += 2;
            questions.newLine();
    }
    
    public int generateColumn1Numbers(int problemNumbers)
    {
        int numberColumn1;
        if(problemNumbers % 2 == 1)
            numberColumn1 = (problemNumbers / 2) + 1;
        else 
            numberColumn1 = (problemNumbers / 2);

        return numberColumn1;
    }
    
    public int generateColumn2Numbers(int problemNumbers)
    {        
        int numberColumn2 = problemNumbers / 2;
        return numberColumn2;
    }            
    
    public void column(int additionProblems,int subtractionProblems, int multiplicationProblems,int divisionProblems, int exponentProblems, 
            String addDiff, String subDiff, String multDiff, String divDiff, String expDiff) throws IOException
    {
        MathFunctions mathFunctions = new MathFunctions();
        
        int additionColumn1 = generateColumn1Numbers(additionProblems);
        
        int subtractionColumn1 = generateColumn1Numbers(subtractionProblems);
        
        int multiplicationColumn1 = generateColumn1Numbers(multiplicationProblems);
        
        int divisionColumn1 = generateColumn1Numbers(divisionProblems);
        
        int exponentColumn1 = generateColumn1Numbers(exponentProblems);
        
        for (int i = 0; i < additionColumn1; i++) //generates a number of problems based on what the user specified
        {
            int[] values = mathFunctions.generateAddition(totalProblems, addDiff );//passing i through to generate problem number; +1 to start at problem 1
            //ARRAY SETUP value[0] = prroblem number, value[1] = num1, value[2] = num2 and value[3] = sum
            String problem = (values[0] + ") " + values[1] + " + " + values[2] + " = " +  "<br>" + "\n");
            basicArithmeticGeneration(problem);
            int largestNum = Math.max(values[1],values[2]);//always want largest num to be first operand
            int smallestNum = Math.min(values[1],values[2]);
            solutions.write(addition.additionSolutions(values[0],largestNum,smallestNum,values[3]));            
        }

        for (int i = 0; i < subtractionColumn1; i++) //generates a number of problems based on what the user specified
        {
            
            int[] values = mathFunctions.generateSubtraction(totalProblems, subDiff);
            //ARRAY SETUP value[0] = prroblem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " - " + values[2] + " = " +  "<br>" + "\n");
            basicArithmeticGeneration(problem);
            
            //solutions.write(values[0] + ") " + values[1] + " - " + values[2] + " = " + values[3] + "<br>" + "\n");
            int numberLength = ("" + values[1]).length();
            solutions.write(subtraction.generateCarriedSubtraction(values[0], values[1] , values[2], numberLength, values[3]));

        }
        
        for (int i = 0; i < multiplicationColumn1; i++) //generates a number of problems based on what the user specified
        {
            int values[] = mathFunctions.generateMultiplication(totalProblems, multDiff);
            //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " * " + values[2] + " = " + "<br>" + "\n");
            basicArithmeticGeneration(problem);
            solutions.write(multiplication.multiplicationSolutions(values[0], values[1], values[2]));
        }


        for (int i = 0; i < divisionColumn1; i++) //generates a number of problems based on what the user specified
        {
            int values[] = mathFunctions.generateDivision(totalProblems, divDiff);
            //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " / " + values[2] + " = " + "<br>" + "\n");
            basicArithmeticGeneration(problem);
            solutions.write(division.divisionSolutions(values[0],values[1],values[2],values[3]));
        }
        
        for (int i = 0; i < exponentColumn1; i++) //generates a number of problems based on what the user specified
        {
            int values[] = mathFunctions.generateExponent(totalProblems, expDiff);
            //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " ^ " + values[2] + " = " + "<br>" + "\n");
            basicArithmeticGeneration(problem);
            solutions.write(values[0] + ") " + values[1] + " ^ " + values[2] + " = " + values[3] + "<br>" + "\n");
        }
    }     
}