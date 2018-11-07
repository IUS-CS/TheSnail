/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template questions, choose Tools | Templates
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

    
    BufferedWriter questions;
    BufferedWriter solutions;
    public int totalProblems = 0;
    
    public void startFile() throws IOException {
        questions = new BufferedWriter(new FileWriter("questions.html"));
        solutions = new BufferedWriter(new FileWriter("solutions.html"));
        questions.write("<html>\n");
        questions.write("<header><title>MathProblemGenerator</title></header>\n");
        questions.write("<body>\n");
        questions.write("Name_____________<br>\n");
        
        questions.write("<style>\n");
        questions.write("* {\n");
        questions.write("box-sizing: border-box;\n");
        questions.write("}\n");

        /* Create two equal columns that floats next to each other */
        questions.write(".column {\n");
        questions.write("float: left;\n");
        questions.write("width: 50%;\n");
        questions.write("padding: 10px;\n");

        questions.write("}\n");

        /* Clear floats after the columns\n */
        questions.write(".row:after {\n");
        questions.write("content: \"\";\n");
        questions.write("display: table;\n");
        questions.write("clear: both;\n");
        questions.write("}\n");
        questions.write("</style>\n");
        
        questions.write("<div class=\"row\">\n"); // start of column 1
        questions.write("<div class=\"column\" style=\"background-color:#FFFFFF;\">\n");
        
        solutions.write("<html>\n");
        solutions.write("<header><title>MathProblemGenerator</title></header>\n");
        solutions.write("<body>\n");
        solutions.write("Solutions<br/>\n");
        
        
        

    }

    public void writeFile(int additionProblems,int subtractionProblems, int multiplicationProblems,int divisionProblems, int exponentProblems, 
            String addDiff, String subDiff, String multDiff, String divDiff, String expDiff) throws IOException//writes the questions to html
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
        
        int exponentColumn1;
        if(exponentProblems % 2 == 1)
            exponentColumn1 = (exponentProblems / 2) + 1;
        else 
            exponentColumn1 = (exponentProblems / 2);
        int exponentColumn2 = exponentProblems / 2;

        
        for (int i = 0; i < additionColumn1; i++) //generates a number of problems based on what the user specified
        {
            int[] values = mathFunctions.generateAddition(totalProblems + 1, addDiff );//passing i through to generate problem number; +1 to start at problem 1
            //ARRAY SETUP value[0] = prroblem number, value[1] = num1, value[2] = num2 and value[3] = sum
            String problem = (values[0] + ") " + values[1] + " + " + values[2] + " = " +  "<br>" + "\n");
            basicArithmeticGeneration(problem);
            
            solutions.write(values[0] + ") " + values[1] + " + " + values[2] + " = " + values[3] + "<br>" + "\n");
        }


        for (int i = 0; i < subtractionColumn1; i++) //generates a number of problems based on what the user specified
        {
            
            int[] values = mathFunctions.generateSubtraction(totalProblems + 1, subDiff);
            //ARRAY SETUP value[0] = prroblem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " - " + values[2] + " = " +  "<br>" + "\n");
            basicArithmeticGeneration(problem);
            
            solutions.write(values[0] + ") " + values[1] + " - " + values[2] + " = " + values[3] + "<br>" + "\n");

        }


        for (int i = 0; i < multiplicationColumn1; i++) //generates a number of problems based on what the user specified
        {
            int values[] = mathFunctions.generateMultiplication(totalProblems + 1, multDiff);
            //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " * " + values[2] + " = " + "<br>" + "\n");
            basicArithmeticGeneration(problem);
            solutions.write(values[0] + ") " + values[1] + " * " + values[2] + " = " + values[3] + "<br>" + "\n");
        }


        for (int i = 0; i < divisionColumn1; i++) //generates a number of problems based on what the user specified
        {
            int values[] = mathFunctions.generateDivision(totalProblems + 1, divDiff);
            //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " / " + values[2] + " = " + "<br>" + "\n");
            basicArithmeticGeneration(problem);
            solutions.write(values[0] + ") " + values[1] + " / " + values[2] + " = " + values[3] + "<br>" + "\n");
        }
        
        for (int i = 0; i < exponentColumn1; i++) //generates a number of problems based on what the user specified
        {
            int values[] = mathFunctions.generateExponent(totalProblems + 1, expDiff);
            //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " ^ " + values[2] + " = " + "<br>" + "\n");
            basicArithmeticGeneration(problem);
            solutions.write(values[0] + ") " + values[1] + " ^ " + values[2] + " = " + values[3] + "<br>" + "\n");
        }

        questions.write("</div>\n");//end of column1
        questions.write("<div class=\"column\" style=\"background-color:#FFFFFF;\">\n"); //start of column2

        for (int i = 0; i < additionColumn2; i++) //generates a number of problems based on what the user specified
        {
            int[] values = mathFunctions.generateAddition(totalProblems + 1, addDiff);//passing i through to generate problem number; +1 to start at problem 1
            //ARRAY SETUP value[0] = prroblem number, value[1] = num1, value[2] = num2 and value[3] = sum
            String problem = (values[0] + ") " + values[1] + " + " + values[2] + " = " + "<br>" + "\n");
            basicArithmeticGeneration(problem);
            solutions.write(values[0] + ") " + values[1] + " + " + values[2] + " = " + values[3] + "<br>" + "\n");
        }


        for (int i = 0; i < subtractionColumn2; i++) //generates a number of problems based on what the user specified
        {
            int[] values = mathFunctions.generateSubtraction(totalProblems + 1, subDiff);
            //ARRAY SETUP value[0] = prroblem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " - " + values[2] + " = " +  "<br>" + "\n");
            basicArithmeticGeneration(problem);
            solutions.write(values[0] + ") " + values[1] + " - " + values[2] + " = " + values[3] + "<br>" + "\n");

        }


        for (int i = 0; i < multiplicationColumn2; i++) //generates a number of problems based on what the user specified
        {
            int values[] = mathFunctions.generateMultiplication(totalProblems + 1, multDiff);
            //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " * " + values[2] + " = " + "<br>" + "\n");
            basicArithmeticGeneration(problem);
            solutions.write(values[0] + ") " + values[1] + " * " + values[2] + " = " + values[3] + "<br>" + "\n");
        }

        for (int i = 0; i < divisionColumn2; i++) //generates a number of problems based on what the user specified
        {
            int values[] = mathFunctions.generateDivision(totalProblems + 1, divDiff);
            //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " / " + values[2] + " = " + "<br>" + "\n");
            basicArithmeticGeneration(problem);
            solutions.write(values[0] + ") " + values[1] + " / " + values[2] + " = " + values[3] + "<br>" + "\n");
        }    
        
        for (int i = 0; i < exponentColumn2; i++) //generates a number of problems based on what the user specified
        {
            int values[] = mathFunctions.generateExponent(totalProblems + 1, expDiff);
            //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " ^ " + values[2] + " = " + "<br>" + "\n");
            basicArithmeticGeneration(problem);
            solutions.write(values[0] + ") " + values[1] + " ^ " + values[2] + " = " + values[3] + "<br>" + "\n");
        }    

        questions.write("</div>\n");//end of column2
        questions.write("</div>\n");
        
    }

    public void endFile() throws IOException {
        questions.write("<body>\n");
        questions.write("<html>\n");
        questions.close();
        solutions.write("<body>\n");
        solutions.write("<html>\n");
        solutions.close();
    }
    
    public void basicArithmeticGeneration(String problem) throws IOException
    {
        
        questions.write(problem + "<br>" + "\n");
            for(int j = 0; j < 4; j++)
                questions.write("<br>" + "\n");//giving student space to work           
            totalProblems++;
            questions.newLine();
    }
}