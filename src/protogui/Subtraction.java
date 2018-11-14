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
public class Subtraction 
{
    Padding paddingObj = new Padding();
    
    Subtraction()
    {}
    
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
    
    public String generateCarriedSubtraction(int problemNum, int num1 , int num2, int numberLength, int result) throws IOException
    {                         
        String padding = paddingObj.generatePadding();
        
        String subtraction = "";
        
        String carriedDigits = generateCarriedNumbers(num1,num2);
        subtraction += "<div align=\"right\">" + "\n";
        subtraction += problemNum + ") " + "&emsp;&emsp;" + padding +"<br>" + "\n" + "\n";
        subtraction += "<font size = \"3\" color = grey>" + carriedDigits + padding + "<br>"+ "\n";
        subtraction += "<font size = \"3\" color = black>"+ "\n";
        subtraction += num1 + padding + "<br>" + "\n" + "\n";
        subtraction += "<u>" + "- " + num2 + "</u>" + padding + "<br>" + "\n"+ "\n";
        subtraction += result + padding + "<br>" + "\n" + "\n";
        subtraction += "</div>"+ "\n";
        
        return subtraction;
    }
}
