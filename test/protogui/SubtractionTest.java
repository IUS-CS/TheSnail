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
public class SubtractionTest {
    
    public SubtractionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of generateCarriedNumbers method, of class Subtraction.
     */
    @Test
    public void testGenerateCarriedNumbers1() {
        System.out.println("generateCarriedOnes1");
        int num1 = 10;
        int num2 = 4;
        Subtraction instance = new Subtraction();
        String expResult = "0&nbsp;&nbsp;";
        String result = instance.generateCarriedNumbers(num1, num2);
        assertEquals(expResult, result);
    }
    
    //burrowing 2 spaces
    @Test
    public void testGenerateCarriedNumbers2() {
        System.out.println("generateCarriedOnes2");
        int num1 = 1000;
        int num2 = 1;
        Subtraction instance = new Subtraction();;
        String expResult = "099&nbsp;&nbsp;";
        String result = instance.generateCarriedNumbers(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGenerateCarriedNumbers3() {
        System.out.println("generateCarriedOnes3");
        int num1 = 564;
        int num2 = 70;
        Subtraction instance = new Subtraction();
        String expResult = "4&nbsp;&nbsp;&nbsp;&nbsp;";
        String result = instance.generateCarriedNumbers(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGenerateCarriedNumbers4() {
        System.out.println("generateCarriedOnes4");
        int num1 = 564;
        int num2 = 70;
        Subtraction instance = new Subtraction();
        String expResult = "4&nbsp;&nbsp;&nbsp;&nbsp;";
        String result = instance.generateCarriedNumbers(num1, num2);
        assertEquals(expResult, result);
    }
    
    //burrowing 1 spaces
    @Test
    public void testGenerateCarriedNumbers5() {
        System.out.println("generateCarriedOnes5");
        int num1 = 100;
        int num2 = 1;
        Subtraction instance = new Subtraction();
        String expResult = "09&nbsp;&nbsp;";
        String result = instance.generateCarriedNumbers(num1, num2);
        assertEquals(expResult, result);
    }

    /**
     * Test of generatePadding method, of class WriteFile.
     */
    
    //burrowing 1 spaces but having to burrow after
    @Test
    public void testGenerateCarriedNumbers6() {
        System.out.println("generateCarriedOnes6");
        int num1 = 1000;
        int num2 = 10;
        Subtraction instance = new Subtraction();
        String expResult = "09&nbsp;&nbsp;&nbsp;&nbsp;";
        String result = instance.generateCarriedNumbers(num1, num2);
        assertEquals(expResult, result);
    }
    
    //burrowing 1 spaces but having to burrow after
    @Test
    public void testGenerateCarriedNumbers7() {
        System.out.println("generateCarriedOnes7");
        int num1 = 1101;
        int num2 = 10;
        Subtraction instance = new Subtraction();
        String expResult = "&nbsp;&nbsp;0&nbsp;&nbsp;&nbsp;&nbsp;";
        String result = instance.generateCarriedNumbers(num1, num2);
        assertEquals(expResult, result);
    }
}
