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
public class WriteFileTest {
    
    public WriteFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of generateCarriedOnes method, of class WriteFile
     */
    //No Ones
    @Test
    public void testGenerateCarriedOnes1() {
        System.out.println("generateCarriedOnes1");
        int num1 = 0;
        int num2 = 1;
        WriteFile instance = new WriteFile();
        String expResult = "&nbsp;&nbsp;";
        String result = instance.generateCarriedOnes(num1, num2);
        assertEquals(expResult, result);
    }
    
    //One One
    @Test
    public void testGenerateCarriedOnes2() {
        System.out.println("generateCarriedOnes2");
        int num1 = 9;
        int num2 = 1;
        WriteFile instance = new WriteFile();
        String expResult = "1&nbsp;&nbsp;";
        String result = instance.generateCarriedOnes(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    //2 Ones
    public void testGenerateCarriedOnes3() {
        System.out.println("generateCarriedOnes3");
        int num1 = 39;
        int num2 = 61;
        WriteFile instance = new WriteFile();
        String expResult = "11&nbsp;&nbsp;";
        String result = instance.generateCarriedOnes(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    //space between Ones
    public void testGenerateCarriedOnes4() {
        System.out.println("generateCarriedOnes4");
        int num1 = 319;
        int num2 = 761;
        WriteFile instance = new WriteFile();
        String expResult = "1&nbsp;&nbsp;1&nbsp;&nbsp;";
        String result = instance.generateCarriedOnes(num1, num2);
        assertEquals(expResult, result);
    }
    
    //carrying over twice
    @Test
    public void testGenerateCarriedOnes5() {
        System.out.println("generateCarriedOnes5");
        int num1 = 999;
        int num2 = 1;
        WriteFile instance = new WriteFile();
        String expResult = "111&nbsp;&nbsp;";
        String result = instance.generateCarriedOnes(num1, num2);
        assertEquals(expResult, result);
    }
    @Test
    public void testGenerateCarriedNumbers1() {
        System.out.println("generateCarriedOnes1");
        int num1 = 10;
        int num2 = 4;
        WriteFile instance = new WriteFile();
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
        WriteFile instance = new WriteFile();
        String expResult = "099&nbsp;&nbsp;";
        String result = instance.generateCarriedNumbers(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGenerateCarriedNumbers3() {
        System.out.println("generateCarriedOnes3");
        int num1 = 564;
        int num2 = 70;
        WriteFile instance = new WriteFile();
        String expResult = "4&nbsp;&nbsp;&nbsp;&nbsp;";
        String result = instance.generateCarriedNumbers(num1, num2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGenerateCarriedNumbers4() {
        System.out.println("generateCarriedOnes4");
        int num1 = 564;
        int num2 = 70;
        WriteFile instance = new WriteFile();
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
        WriteFile instance = new WriteFile();
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
        WriteFile instance = new WriteFile();
        String expResult = "09&nbsp;&nbsp;&nbsp;&nbsp;";
        String result = instance.generateCarriedNumbers(num1, num2);
        assertEquals(expResult, result);
    }

    /**
     * Test of generatePadding method, of class WriteFile.
     */
    
    //burrowing 1 spaces but having to burrow after
    @Test
    public void testGenerateCarriedNumbers7() {
        System.out.println("generateCarriedOnes7");
        int num1 = 1101;
        int num2 = 10;
        WriteFile instance = new WriteFile();
        String expResult = "&nbsp;&nbsp;0&nbsp;&nbsp;&nbsp;&nbsp;";
        String result = instance.generateCarriedNumbers(num1, num2);
        assertEquals(expResult, result);
    }

    /**
     * Test of generatePadding method, of class WriteFile.
     */
    
    @Test
    public void testGeneratePadding() {
        System.out.println("generatePadding");
        WriteFile instance = new WriteFile();
        String expResult = "&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;";
        String result = instance.generatePadding();
        assertEquals(expResult,result);
    }
    
}
