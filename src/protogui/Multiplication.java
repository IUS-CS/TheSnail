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
        String runningCarried= "";
        String carriedNumbers = "";
        while(operand2 > 0)
        {
            int subop2 = operand2 % 10;
            operand2 /= 10;
            int temp1 = operand1;
            carriedNumbers = "";
            while(temp1 > 0)
            {
                
                int subop1 = temp1 % 10;
                temp1 /= 10;
                int subResult = (subop1 * subop2);
                if(subResult > 9)
                {
                    int carriedNumber = subResult / 10;
                    carriedNumbers = carriedNumber + carriedNumbers;
                }
                else
                {
                    carriedNumbers = "&nbsp;&nbsp;" + carriedNumbers;
                }                
            }
            runningCarried = "<br>"  + carriedNumbers + "&nbsp;&nbsp;" + padding + runningCarried;           
        }

        return runningCarried;        
    }
    
    String runningSums(int operand1, int operand2)
    {
        String padding = paddingObj.generatePadding();
        String runningSums = "";
        int total = 0;
        int zeropad = 1;
        while(operand2 > 9)
        {
            int subop = operand2 % 10;
            operand2 /= 10;
            int subResult = subop * operand1 * zeropad;
            runningSums += subResult + padding + "<br>" + "\n";
            zeropad *= 10;
            total += subResult;
        }
        int subop = operand2 % 10;
        operand2 /= 10;
        int subResult = subop * operand1 * zeropad;
        runningSums += "<u>" + "+" + subResult + "</u>" + padding + "<br>" + "\n";
        zeropad *= 10;
        total += subResult;
        runningSums +=  total  + padding + "<br>" + "\n";
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
