package protogui;

import java.io.IOException;

/**
 *
 * @author Thomas
 */
public class Division 
{
    Padding paddingObj = new Padding();
    
    Division()
    {
    }
    
    public String generateLongDivision(String dividend, int divisor)
    {
        //needs to be a string for account of interal 0s such as 2001
        String longDivision = "";//start of string to return
        String mainPadding = paddingObj.generatePadding();//main padding to align with other types of problems
        int subDividend = 0;//number being looked at for individual division
        int leftOver = 0;//number leftover after subtraction
        int nextDigit;//number that is carried down
        
        while(!dividend.equals(""))
        {           
            subDividend = (leftOver * 10) + Character.getNumericValue(dividend.charAt(0)); //moving left over one digit and adding the first char
            dividend = dividend.substring(1); //chopping off first digit of dividend       
            
            int subtraction = (subDividend / divisor) * divisor;//subQuotient * Divisor
            String padding = "";
            for (int i = 0; i < dividend.length(); i++) //padding for numbers to be in correct column
            {
                padding = "&nbsp;&nbsp;" + padding;
            }
            longDivision += "<u>-" + subtraction  + "</u>" + "&nbsp;&nbsp;" + padding + mainPadding + "<br>" + "\n";//adding the subtraction part to the string
            leftOver = subDividend - subtraction;//getting what is leftover - subtraction

            if(dividend.equals(""))//check if there is not a number remainining to carry down
            {
                longDivision += Integer.toString(leftOver) + "&nbsp;&nbsp;" + padding + mainPadding + "<br>" + "\n";//finsihing loop
                break;
            }
            else
                nextDigit = Character.getNumericValue(dividend.charAt(0));//getting next char to carrydown

            longDivision += Integer.toString(leftOver) + Integer.toString(nextDigit) + padding + mainPadding + "<br>" + "\n";//print result of subtraction with next digit
        }
        return longDivision;
    }
             
    public String divisionSolutions(int problemNum, int dividend, int divisor, int quotient) throws IOException
    {              
            String toString = "" + dividend;
            String longDivision = generateLongDivision(toString,divisor);
            String padding = paddingObj.generatePadding();
            String divisionSolution = "";
            divisionSolution += "<div align=\"right\">" + "\n";
            divisionSolution += problemNum + ") " + "&emsp;&emsp;" + padding +"<br>" + "\n" + "\n";
            divisionSolution += "<u>" + "&nbsp;&nbsp;" + quotient + "</u>" + "&nbsp;&nbsp;" + padding + "<br>"+ "\n";
            divisionSolution += "<font size = \"3\" color = black>"+ "\n";
            divisionSolution += divisor + "|" + dividend + padding + "&nbsp;&nbsp;" + "<br>" + "\n" + "\n";
            divisionSolution += longDivision + "<br>" + "\n" + "\n";
            divisionSolution += "</div>"+ "\n";
            return divisionSolution;
    }
}
