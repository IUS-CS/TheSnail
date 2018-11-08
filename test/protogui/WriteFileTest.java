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
     * Test of generateCarriedOnes method, of class WriteFile.
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
