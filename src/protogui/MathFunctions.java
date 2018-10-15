/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protogui;

import java.util.Random;

/**
 *
 * @author Thomas
 */
public class MathFunctions {
    
    private int additionProblems = 0;
    
    public void setAdditionProblems(int x)
    {
        additionProblems = x;
    }
    
    public int getAdditionProblems()
    {
        return additionProblems;
    }
    
    public String generateAddition(int problemNumber)//generates addition problems
    {
        Random rand = new Random();
        int num1 = rand.nextInt(10) + 1;
        int num2 = rand.nextInt(10) + 1;
        int sum = num1 + num2;
                
        String problem = (problemNumber + ") " + num1 + " + " + num2 + " = " + sum + "<br>" + "\n");
        return problem;
    }
    
    public String generateSubtraction()//generates addition problems
    {
        Random rand = new Random();
        int num1 = rand.nextInt(10) + 1;
        int num2 = rand.nextInt(10) + 1;
        int sum;
        String problem;
        if (num1 > num2){
            sum = num1 - num2;
            problem = (num1 + " - " + num2 + " = " + sum);
        }
        else{
            sum = num2-num1;
            problem = (num2 + " - " + num1 + " = " + sum);
        }
                
        return problem;
    }
    
    public String generateMultiplication()//generates addition problems
    {
        Random rand = new Random();
        int num1 = rand.nextInt(10) + 1;
        int num2 = rand.nextInt(10) + 1;
        int sum = num1 * num2;
                
        String problem = (num1 + " * " + num2 + " = " + sum);
        return problem;
    }
}
