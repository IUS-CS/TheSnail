/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protogui;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class MultiplicationTest {
    
    public MultiplicationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of carriedMultiplication method, of class Multiplication.
     */
    @Test
    public void testCarriedMultiplication1() {
        System.out.println("carriedMultiplication1");
        int operand1 = 24;
        int operand2 = 4;
        Multiplication instance = new Multiplication();
        Padding paddingObj = new Padding();
        String padding = paddingObj.generatePadding();
        String expResult = "<br>" + "\n" + "&nbsp;&nbsp;"  + 
                "1&nbsp;&nbsp;" + padding;
        String result = instance.carriedMultiplication(operand1, operand2);

        assertEquals(expResult, result);
    }
    
    @Test
    public void testCarriedMultiplication2() {
        System.out.println("carriedMultiplication2");
        int operand1 = 24;
        int operand2 = 54;
        Multiplication instance = new Multiplication();
        Padding paddingObj = new Padding();
        String padding = paddingObj.generatePadding();
        String expResult = "<br>" + "\n" + 
                "12&nbsp;&nbsp;" + padding + "<br>" + "\n" + 
                "&nbsp;&nbsp;1&nbsp;&nbsp;" + padding;
        String result = instance.carriedMultiplication(operand1, operand2);

        assertEquals(expResult, result);
    }

    /**
     * Test of runningSums method, of class Multiplication.
     */
    @Test
    public void testRunningSums1() {
        System.out.println("runningSums1");
        Padding paddingObj = new Padding();
        String padding = paddingObj.generatePadding();
        int operand1 = 24;
        int operand2 = 4;
        Multiplication instance = new Multiplication();
        String expResult = "<u>+96</u>" + padding + "<br>" + "\n" + 
                96 + padding + "<br>" + "\n";
        String result = instance.runningSums(operand1, operand2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRunningSums2() {
        System.out.println("runningSums2");
        Padding paddingObj = new Padding();
        String padding = paddingObj.generatePadding();
        int operand1 = 24;
        int operand2 = 54;
        Multiplication instance = new Multiplication();
        String expResult = "96" + padding + "<br>" + "\n" + 
                "<u>+1200</u>" + padding + "<br>" + "\n" +
                1296 + padding + "<br>" + "\n";
        String result = instance.runningSums(operand1, operand2);
        assertEquals(expResult, result);
    }

    
    
}
