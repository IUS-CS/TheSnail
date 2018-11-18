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
public class MathFunctionsTest {
    
    public MathFunctionsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setAdditionProblems method, of class MathFunctions.
     */
    @Test
    public void testSetAdditionProblems() {
        System.out.println("setAdditionProblems");
        int x = 0;
        MathFunctions instance = new MathFunctions();
        instance.setAdditionProblems(x);
        instance.setAdditionProblems(5);
        int expResult =5;
        int result = instance.getAdditionProblems();
        assertEquals(expResult,result);
    }
    
    //TODO SUBTRACTION 
    /**
     * Test of setAdditionProblems method, of class MathFunctions.
     */
    @Test
    public void testSetSubtractionProblems() {
        System.out.println("setSubtractionProblems");
        int x = 0;
        MathFunctions instance = new MathFunctions();
        instance.setSubtractionProblems(x);
        instance.setSubtractionProblems(5);
        int expResult = 5;
        int result = instance.getSubtractionProblems();
        assertEquals(expResult,result);
    }
    
    //TODO MULTIPLICATION
     @Test
    public void testSetMultiplicationProblems() {
        System.out.println("setMultiplicationProblems");
        int x = 0;
        MathFunctions instance = new MathFunctions();
        instance.setMultiplicationProblems(x);
        instance.setMultiplicationProblems(5);
        int expResult = 5;
        int result = instance.getMultiplicationProblems();
        assertEquals(expResult,result);
    }
    @Test
    //TODO DIVISION
        public void testSetDivisionProblems() {
        System.out.println("setDIvisionProblems");
        int x = 0;
        MathFunctions instance = new MathFunctions();
        instance.setDivisionProblems(x);
        instance.setDivisionProblems(5);
        int expResult = 5;
        int result = instance.getDivisionProblems();
        assertEquals(expResult,result);
    }
    //TODO PADDING TEST
    public void testGeneratePadding()
    {
        
    }

    
}
