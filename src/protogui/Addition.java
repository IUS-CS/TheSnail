/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protogui;

import java.io.IOException;

/**
 *
 * @author Thomas
 */
public class Addition 
{
    Padding paddingObj = new Padding();
    
    Addition()
    {
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
    
    public String additionSolutions(int problemNum, int operand1, int operand2, int sum) throws IOException
    {
            String addition = "";
            int num1 = operand1;
            int num2 = operand2;
            
            String solutionOnes = generateCarriedOnes(num1, num2);
            
            String padding = paddingObj.generatePadding();
            
            addition += "<div align=\"right\">"  + "\n";
            addition += problemNum + ") " + "&emsp;&emsp;" + padding +"<br>" + "\n"  + "\n";
            addition += "<font size = \"3\" color = grey>" + solutionOnes + padding + "<br>" + "\n";
            addition += "<font size = \"3\" color = black>" + "\n";
            addition += operand1 + padding + "<br>" + "\n"  + "\n";
            addition += "<u>" + "+ " + operand2 + "</u>" + padding + "<br>" + "\n" + "\n";
            addition += sum + padding + "<br>" + "\n"  + "\n";
            addition += "</div>" + "\n";
            
            return addition;
    }
}
