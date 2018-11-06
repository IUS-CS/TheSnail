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
    private String addDiff, subDiff;
    
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
    
    public void setAddDiff (String difficulty){
        addDiff = difficulty;
    }
    
    public void setSubDiff (String difficulty){
        subDiff = difficulty;
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
    
    public String getAddDiff (){
        return addDiff;
    }
    
     public String getSubDiff (){
        return subDiff;
    }
        
    public int[] generateAddition(int problemNumber, String difficulty)//generates addition problems
    {
        Random rand = new Random();
        
        int num1, num2, sum;
        switch (difficulty) {
            case "easy":
                num1 = rand.nextInt(10) + 1;
                num2 = rand.nextInt(10) + 1;
                break;
            case "normal":
                num1 = rand.nextInt(90) + 10;
                num2 = rand.nextInt(90) + 10;
                break;
            default:
                num1 = rand.nextInt(900) + 100;
                num2 = rand.nextInt(900) + 100;
                break;
        }
        
        sum = num1 + num2;
        //ARRAY SETUP value[0] = prroblem number, value[1] = num1, value[2] = num2 and value[3] = sum
        int sumArr[] = {problemNumber,num1,num2,sum};
                
        
        return sumArr;
    }
    
    public int[] generateSubtraction(int problemNumber)//generates addition problems
    {
        Random rand = new Random();
        int num1 = rand.nextInt(10) + 1;
        int num2 = rand.nextInt(10) + 1;
        int sum;
        String problem;
        //ARRAY SETUP value[0] = prroblem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
        if (num1 > num2){
            sum = num1 - num2;           
            int subArr[] = {problemNumber, num1, num2, sum};
            return subArr;
            
        }
        else{
            sum = num2-num1;            
            int subArr[] = {problemNumber, num2, num1, sum};
            return subArr;
        }            
    }
    
    public int[] generateMultiplication(int problemNumber)//generates addition problems
    {
        Random rand = new Random();
        int num1 = rand.nextInt(10) + 1;
        int num2 = rand.nextInt(10) + 1;
        int sum = num1 * num2;
        //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
        int mulArr[] = {problemNumber, num1, num2, sum};
        return mulArr;
    }
    
    public int[] generateDivision(int problemNumber)//generates addition problems
    {
        Random rand = new Random();
        int num1 = rand.nextInt(9) + 2;
        int num2 = rand.nextInt(9) + 2;
        int ans = num1 * num2;
        String problem;
        //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
        problem = (problemNumber + ") " + ans + " / " + num2 + " = " + num1 + "<br>" + "\n");
        int divArr[] = {problemNumber, ans, num2, num1};
          
        return divArr;
    }
}
