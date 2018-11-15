/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protogui;

/**
 *
 * @author Thomas
 */
public class Multiplication 
{
    Padding paddingObj = new Padding();
    Multiplication()
    {
    }
    
    String carriedMultiplication(int operand1, int operand2)
    {
        String padding = paddingObj.generatePadding();
        String runningCarried= ""; //running total of all numbers carried
        String carriedNumbers; //running total of numbers carried on current line
        while(operand2 > 0)
        {
            int subop2 = operand2 % 10;
            operand2 /= 10;
            int temp1 = operand1;
            carriedNumbers = ""; //reset carriedNumbers at beginning of each new line
            while(temp1 > 0) //loop thru all the digits of the bottom number
            {
                
                int subop1 = temp1 % 10;
                temp1 /= 10;
                int subResult = (subop1 * subop2);
                if(subResult > 9)//will the result require a carried number
                {
                    int carriedNumber = subResult / 10; //get the digit that needs to be carried
                    carriedNumbers = carriedNumber + carriedNumbers; //add the digit to the current line carried numbers
                }
                else
                {
                    carriedNumbers = "&nbsp;&nbsp;" + carriedNumbers; //add a blank space to represent no carried number
                }                
            }
            runningCarried = "<br>"  + carriedNumbers + "&nbsp;&nbsp;" + padding + runningCarried; //add a break to create a new line for the carried numbers of the next digit           
        }

        return runningCarried;        
    }
    
    String runningSums(int operand1, int operand2)
    {
        //Used for addition section underneath the problem
        String padding = paddingObj.generatePadding();
        String runningSums = "";
        int total = 0;
        int zeropad = 1; //keeps track of how many 0 placeholders will need to be added
        while(operand2 > 9) //there are still digits to be multiplied
        {
            int subop = operand2 % 10;
            operand2 /= 10; 
            int subResult = subop * operand1 * zeropad; //multiply the current num2 digit by current num1 digit
            runningSums += subResult + padding + "<br>" + "\n";
            zeropad *= 10; //increase the number of 0 placeholders
            total += subResult; //add the current subresult to the end result
        }
        //does the same thing as the while loop, but adds an underline because it is the last number to be added together
        int subop = operand2 % 10;
        operand2 /= 10;
        int subResult = subop * operand1 * zeropad;
        runningSums += "<u>" + "+" + subResult + "</u>" + padding + "<br>" + "\n";
        zeropad *= 10;
        total += subResult;
        
        runningSums +=  total  + padding + "<br>" + "\n";//adds end value to the output string
        return runningSums;        
    }
    
    String multiplicationSolutions(int problemNum, int operand1, int operand2)
    {
        String multiplicationSolution = "";
        String padding = paddingObj.generatePadding();
        multiplicationSolution += "<div align=\"right\">" + "\n";
        multiplicationSolution += problemNum + ") " + "&emsp;&emsp;" + padding +"<br>" + "\n" + "\n";
        multiplicationSolution += "<font size = \"3\" color = grey>" + carriedMultiplication(operand1,operand2) + "<br>" + "\n";
        multiplicationSolution += "<font size = \"3\" color = black>" + "\n";
        multiplicationSolution += operand1 + padding + "<br>" + "\n";
        multiplicationSolution += "<u>" + "x" + operand2  + "</u>" + padding + "<br>" + "\n";
        multiplicationSolution += runningSums(operand1, operand2);
        multiplicationSolution += "</div>"+ "\n";
        
        return multiplicationSolution;
    }
}
