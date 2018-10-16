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
    private int subtractionProblems = 0;
    private int multiplicationProblems = 0;
    private int divisionProblems = 0;
    
    //Setters for problem types
    
    public void setAdditionProblems(int x)
    {
        additionProblems = x;
    }
    
    public void setSubtractionProblems(int x)
    {
        subtractionProblems = x;
    }
    
    public void setMultiplicationProblems(int x)
    {
        multiplicationProblems = x;
    }
    
    public void setDivisionProblems(int x)
    {
        divisionProblems = x;
    }
    
    //Getters for problem types
    
    public int getAdditionProblems()
    {
        return additionProblems;
    }
    
    public int getSubtractionProblems()
    {
        return subtractionProblems;
    }
    
    public int getMultiplicationProblems()
    {
        return multiplicationProblems;
    }
    
    public int getDivisionProblems()
    {
        return divisionProblems;
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
    
    public String generateSubtraction(int problemNumber)//generates addition problems
    {
        Random rand = new Random();
        int num1 = rand.nextInt(10) + 1;
        int num2 = rand.nextInt(10) + 1;
        int sum;
        String problem;
        if (num1 > num2){
            sum = num1 - num2;
            problem = (problemNumber + ") " + num1 + " - " + num2 + " = " + sum + "<br>" + "\n");
        }
        else{
            sum = num2-num1;
            problem = (problemNumber + ") " + num2 + " - " + num1 + " = " + sum + "<br>" + "\n");
        }
                
        return problem;
    }
    
    public String generateMultiplication(int problemNumber)//generates addition problems
    {
        Random rand = new Random();
        int num1 = rand.nextInt(10) + 1;
        int num2 = rand.nextInt(10) + 1;
        int sum = num1 * num2;
                
        String problem = (problemNumber + ") " + num1 + " * " + num2 + " = " + sum + "<br>" + "\n");
        return problem;
    }
    
    public String generateDivision(int problemNumber)//generates addition problems
    {
        Random rand = new Random();
        int num1 = rand.nextInt(9) + 2;
        int num2 = rand.nextInt(9) + 2;
        int ans = num1 * num2;
        String problem;
        
        problem = (problemNumber + ") " + ans + " / " + num2 + " = " + num1 + "<br>" + "\n");
          
        return problem;
    }
}
