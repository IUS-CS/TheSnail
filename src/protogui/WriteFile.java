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
    public int totalProblems = 0;
    Padding paddingObj = new Padding();
    Division division = new Division();
    
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
        
        //making solutions columns
        solutions.write("<style>\n");
        solutions.write("* {\n");
        solutions.write("box-sizing: border-box;\n");
        solutions.write("}\n");
        
        solutions.write(".column {\n"); 
        solutions.write("float: left;\n");
        solutions.write("width: 50%;\n");
        solutions.write("padding: 10px;\n");

        solutions.write("}\n");


        solutions.write(".row:after {\n");
        solutions.write("content: \"\";\n");
        solutions.write("display: table;\n");
        solutions.write("clear: both;\n");
        solutions.write("}\n");
        solutions.write("</style>\n");

        solutions.write("<div class=\"row\">\n"); // start of column 1
        solutions.write("<div class=\"column\" style=\"background-color:#FFFFFF;\">\n");
        
        
        

    }

    public void writeFile(int additionProblems,int subtractionProblems, int multiplicationProblems,int divisionProblems, int exponentProblems, 
            String addDiff, String subDiff, String multDiff, String divDiff, String expDiff) throws IOException
//writes the questions to html
    {
        MathFunctions mathFunctions = new MathFunctions();
        
        //set up the number of each type of problem in each column
        int additionColumn1 = generateColumn1Numbers(additionProblems);
        int additionColumn2 = generateColumn2Numbers(additionProblems);
        
        int subtractionColumn1 = generateColumn1Numbers(subtractionProblems);
        int subtractionColumn2 = generateColumn2Numbers(subtractionProblems);
        
        int multiplicationColumn1 = generateColumn1Numbers(multiplicationProblems);;
        int multiplicationColumn2 = generateColumn2Numbers(multiplicationProblems);
        
        int divisionColumn1 = generateColumn1Numbers(divisionProblems);;
        int divisionColumn2 = generateColumn2Numbers(divisionProblems);
        
        int exponentColumn1 = generateColumn1Numbers(exponentProblems);;
        int exponentColumn2 = generateColumn2Numbers(exponentProblems);

        //Start of Column1
        for (int i = 0; i < additionColumn1; i++) //generates a number of problems based on what the user specified
        {
            int[] values = mathFunctions.generateAddition(totalProblems + 1, addDiff );//passing i through to generate problem number; +1 to start at problem 1
            //ARRAY SETUP value[0] = prroblem number, value[1] = num1, value[2] = num2 and value[3] = sum
            String problem = (values[0] + ") " + values[1] + " + " + values[2] + " = " +  "<br>" + "\n");
            basicArithmeticGeneration(problem);
            int largestNum = Math.max(values[1],values[2]);//always want largest num to be first operand
            int smallestNum = Math.min(values[1],values[2]);
            additionSolutions(values[0],largestNum,smallestNum,values[3]);            
        }

        for (int i = 0; i < subtractionColumn1; i++) //generates a number of problems based on what the user specified
        {
            
            int[] values = mathFunctions.generateSubtraction(totalProblems + 1, subDiff);
            //ARRAY SETUP value[0] = prroblem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " - " + values[2] + " = " +  "<br>" + "\n");
            basicArithmeticGeneration(problem);
            
            //solutions.write(values[0] + ") " + values[1] + " - " + values[2] + " = " + values[3] + "<br>" + "\n");
            int numberLength = ("" + values[1]).length();
            generateCarriedSubtraction(values[0], values[1] , values[2], numberLength, values[3]);

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
            solutions.write(division.divisionSolutions(values[0],values[1],values[2],values[3]));
        }
        
        for (int i = 0; i < exponentColumn1; i++) //generates a number of problems based on what the user specified
        {
            int values[] = mathFunctions.generateExponent(totalProblems + 1, expDiff);
            //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " ^ " + values[2] + " = " + "<br>" + "\n");
            basicArithmeticGeneration(problem);
            solutions.write(values[0] + ") " + values[1] + " ^ " + values[2] + " = " + values[3] + "<br>" + "\n");
        }
        
        questions.write("</div>\n");
        solutions.write("</div>\n");
        
        //end of column1
        
        questions.write("<div class=\"column\" style=\"background-color:#FFFFFF;\">\n"); 
        solutions.write("<div class=\"column\" style=\"background-color:#FFFFFF;\">\n"); 
        
        //start of column2

        for (int i = 0; i < additionColumn2; i++) //generates a number of problems based on what the user specified
        {
            int[] values = mathFunctions.generateAddition(totalProblems + 1, addDiff);//passing i through to generate problem number; +1 to start at problem 1
            //ARRAY SETUP value[0] = prroblem number, value[1] = num1, value[2] = num2 and value[3] = sum
            String problem = (values[0] + ") " + values[1] + " + " + values[2] + " = " + "<br>" + "\n");
            basicArithmeticGeneration(problem);int largestNum = Math.max(values[1],values[2]);//always want largest num to be first operand
            int smallestNum = Math.min(values[1],values[2]);
            additionSolutions(values[0],largestNum,smallestNum,values[3]);
        }


        for (int i = 0; i < subtractionColumn2; i++) //generates a number of problems based on what the user specified
        {
            int[] values = mathFunctions.generateSubtraction(totalProblems + 1, subDiff);
            //ARRAY SETUP value[0] = prroblem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
            String problem = (values[0] + ") " + values[1] + " - " + values[2] + " = " +  "<br>" + "\n");
            basicArithmeticGeneration(problem);
            int numberLength = ("" + values[1]).length();
            generateCarriedSubtraction(values[0], values[1] , values[2], numberLength, values[3]);

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
            solutions.write(division.divisionSolutions(values[0],values[1],values[2],values[3]));
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
        
        solutions.write("</div>\n");//end of column2
        
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
        
    public String generateCarriedOnes(int num1, int num2)
    {
        boolean carriedOne = false;
        String solutionOnes = "&nbsp;&nbsp;";
        while(num1 > 0) //still digits left to check
        {
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;
                
            num1 = num1 / 10;
            num2 = num2 / 10;
            
            int solution = digit1 + digit2;
            //DO NOT REMOVE LINE BELOW
            if(carriedOne)//adding 1 if the last digits were greater than 10
                solution++;
            
            
            if(solution > 9)//did we carry a one
            {
                solutionOnes = "1" + solutionOnes; //adds the carried one to be output line
                carriedOne = true;                   
            }
            else
            {
                solutionOnes = "&nbsp;&nbsp;" + solutionOnes; //leaves space in output line because no carried one
                carriedOne = false;
            } 
        }
        return solutionOnes;
    }
    
    public void additionSolutions(int problemNum, int operand1, int operand2, int sum) throws IOException
    {
            
            int num1 = operand1;
            int num2 = operand2;
            
            String solutionOnes = generateCarriedOnes(num1, num2);
            
            String padding = paddingObj.generatePadding();
            
            solutions.write("<div align=\"right\">" );
            solutions.write(problemNum + ") " + "&emsp;&emsp;" + padding +"<br>" + "\n" );//problem number
            solutions.write("<font size = \"3\" color = grey>" + solutionOnes + padding + "<br>");//carried ones
            solutions.write("<font size = \"3\" color = black>");
            solutions.write(operand1 + padding + "<br>" + "\n" );//operand 1
            solutions.write("<u>" + "+ " + operand2 + "</u>" + padding + "<br>" + "\n");//sign and operand 2
            solutions.write(sum + padding + "<br>" + "\n" ); // answer
            solutions.write("</div>");
    }
    
    public String generateCarriedNumbers(int num1, int num2)
    {
        String carriedDigits = "&nbsp;&nbsp;";
        while(num1 > 0)
        {
            int dig1 = num1 % 10; //checks last digit
            int dig2 = num2 % 10; //checks last digit        
            
            
            num1 = num1 / 10; //cuts off last digit
            num2 = num2 / 10; //cuts off last digit
            int sub = dig1 - dig2;
            
            if(sub < 0) //checks to see if user will need to carry a one
            {
                dig1 = num1 % 10;
                num1 = num1 / 10;
                num2 = num2 / 10;
                
                //Take away one from the value you borrowed from
                if(dig1 == 0)
                    carriedDigits = 9 + carriedDigits; 
                else
                    carriedDigits = (dig1 - 1) + carriedDigits;
                
                
                while(dig1 == 0)//looking for number to burrow a 1 from in case of 0
                {
                    
                    dig1 = num1 % 10;
                    num1 = num1 / 10;
                    num2 = num2 / 10;
                    
                    //Take away one from the value you borrowed from
                    if(dig1 == 0)
                    {
                        carriedDigits = 9 + carriedDigits;
                        
                    }
                    else
                    {
                        carriedDigits = (dig1 - 1) + carriedDigits;
                    }
                }
            }
            else
            {
                carriedDigits = "&nbsp;&nbsp;" + carriedDigits;
            }
        }
        return carriedDigits;
    }
    
    public void generateCarriedSubtraction(int problemNum, int num1 , int num2, int numberLength, int result) throws IOException
    {                         
        String padding = paddingObj.generatePadding();
        
        String carriedDigits = generateCarriedNumbers(num1,num2);
        solutions.write("<div align=\"right\">" );
        solutions.write(problemNum + ") " + "&emsp;&emsp;" + padding +"<br>" + "\n" );//problem number
        solutions.write("<font size = \"3\" color = grey>" + carriedDigits + padding + "<br>");//carried ones
        solutions.write("<font size = \"3\" color = black>");
        solutions.write(num1 + padding + "<br>" + "\n" );//operand 1
        solutions.write("<u>" + "- " + num2 + "</u>" + padding + "<br>" + "\n");//sign and operand 2
        solutions.write(result + padding + "<br>" + "\n" ); // answer
        solutions.write("</div>");
    }
    

}