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
    private int exponentProblems = 0;
    private String addDiff, subDiff, multDiff, divDiff, expDiff;
    
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
    
    public void setExponentProblems(int x)
    {
        exponentProblems = x;
    }
    
    //Setters for Difficulty
    
    public void setAddDiff (String difficulty){
        addDiff = difficulty;
    }
    
    public void setSubDiff (String difficulty){
        subDiff = difficulty;
    }
    
    public void setMultDiff (String difficulty){
        multDiff = difficulty;
    }
    
    public void setDivDiff (String difficulty){
        divDiff = difficulty;
    }
    
    public void setExpDiff (String difficulty){
        expDiff = difficulty;
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
    
    public int getExponentProblems()
    {
         return exponentProblems;
       
    }
    
    //Getters for Difficulty
    
    public String getAddDiff (){
        return addDiff;
    }
    
    public String getSubDiff (){
        return subDiff;
    }
     
    public String getMultDiff (){
        return multDiff;
    }
    
    public String getDivDiff (){
        return divDiff;
    }
     
    public String getExpDiff (){
        return expDiff;
    }
        
    public int[] generateAddition(int problemNumber, String difficulty)//generates addition problems
    {
        Random rand = new Random();
        
        int num1, num2, sum;
        //set up random numbers of varying lengths, depending on difficulty
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
    
    public int[] generateSubtraction(int problemNumber, String difficulty)//generates subtraction problems
    {
        Random rand = new Random();
        int num1;
        int num2;
        int sum;
        //set up random numbers of varying lengths, depending on difficulty
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
        
        //ensures that the larger number is always on top
        //Answers will always be positive
        if (num1 > num2){
            sum = num1 - num2;     
//ARRAY SETUP value[0] = prroblem number, value[1] = operand1, value[2] = operand2 and value[3] = solution      
            int subArr[] = {problemNumber, num1, num2, sum};
            return subArr;
            
        }
        else{
            sum = num2-num1;            
            int subArr[] = {problemNumber, num2, num1, sum};
            return subArr;
        }            
    }
    
    public int[] generateMultiplication(int problemNumber, String difficulty)//generates multiplication problems
    {
        Random rand = new Random();
        int num1;
        int num2;
        //set up random numbers of varying lengths, depending on difficulty
        switch (difficulty) {
            case "easy":
                num1 = rand.nextInt(10) + 1;
                num2 = rand.nextInt(10) + 1;
                break;
            case "normal":
                num1 = rand.nextInt(9) + 2;
                num2 = rand.nextInt(90) + 10;
                break;
            default:
                num1 = rand.nextInt(9) + 2;
                num2 = rand.nextInt(900) + 100;
                break;
        }
        int sum = num1 * num2;
        //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
        int mulArr[] = {problemNumber, num1, num2, sum};
        return mulArr;
    }
    
    public int[] generateDivision(int problemNumber, String difficulty)//generates division problems
    {
        Random rand = new Random();
        int num1;
        int num2;
        //set up Random numbers of varying lengths, depending on difficulty
        switch (difficulty) {
            case "easy":
                num1 = rand.nextInt(9) + 2;
                num2 = rand.nextInt(9) + 2;
                break;
            case "normal":
                num1 = rand.nextInt(9) + 2;
                num2 = rand.nextInt(89) + 11;
                break;
            default:
                num1 = rand.nextInt(9) + 2;
                num2 = rand.nextInt(899) + 101;
                break;
        }
        int ans = num1 * num2;
        String problem;
        //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
        problem = (problemNumber + ") " + ans + " / " + num1 + " = " + num2 + "<br>" + "\n");
        int divArr[] = {problemNumber, ans, num1, num2};
          
        return divArr;
    }
    
    public int[] generateExponent(int problemNumber, String difficulty)//generates exponent problems
    {
        Random rand = new Random();
        int num1;
        int num2;
        //set up random numbers of varying lengths, depending on difficulty
        switch (difficulty) {
            case "easy":
                num1 = rand.nextInt(9) + 2;
                num2 = rand.nextInt(3) + 2;
                break;
            case "normal":
                num1 = rand.nextInt(9) + 2;
                num2 = rand.nextInt(5) + 2;
                break;
            default:
                num1 = rand.nextInt(19) + 11;
                num2 = rand.nextInt(5) + 2;
                break;
        }
        int ans = (int)Math.pow(num1, num2);
        String problem;
        //ARRAY SETUP value[0] = problem number, value[1] = operand1, value[2] = operand2 and value[3] = solution
        problem = (problemNumber + ") " + num1 + " ^ " + num2 + " = " + ans + "<br>" + "\n");
        int expArr[] = {problemNumber, num1, num2, ans};
        
        return expArr;
    }
}
