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
public class DivisionTest {
    
    public DivisionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of generateLongDivision method, of class Division.
     */
    @Test
    public void testGenerateLongDivision1() {
        System.out.println("generateLongDivision1");
        String dividend = "8";
        int divisor = 4;
        Padding paddingObj = new Padding();
        String padding = paddingObj.generatePadding();
        Division instance = new Division();
        String expResult = "<u>-8</u>" + "&nbsp;&nbsp;" +  padding + "<br>" + "\n" +
                0 + "&nbsp;&nbsp;" + padding + "<br>" + "\n";
        
        String result = instance.generateLongDivision(dividend, divisor);
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);

    }
    @Test
    public void testGenerateLongDivision2() {
        System.out.println("generateLongDivision2");
        String dividend = "16";
        int divisor = 4;
        Padding paddingObj = new Padding();
        String padding = paddingObj.generatePadding();
        Division instance = new Division();
        String expResult = "<u>-0</u>" + "&nbsp;&nbsp;" + "&nbsp;&nbsp;" + padding + "<br>" + "\n" +
                16 + "&nbsp;&nbsp;" + padding + "<br>" + "\n" +
                "<u>-16</u>" + "&nbsp;&nbsp;" + padding + "<br>" + "\n" +
                0 + "&nbsp;&nbsp;" + padding + "<br>" + "\n";
        
        String result = instance.generateLongDivision(dividend, divisor);
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);

    }
    
    @Test
    public void testGenerateLongDivision3() {
        System.out.println("generateLongDivision3");
        String dividend = "2000";
        int divisor = 5;
        Padding paddingObj = new Padding();
        String padding = paddingObj.generatePadding();
        Division instance = new Division();
        String expResult = "<u>-0</u>" + "&nbsp;&nbsp;" + "&nbsp;&nbsp;" + "&nbsp;&nbsp;" + "&nbsp;&nbsp;" + padding + "<br>" + "\n" +
                20 + "&nbsp;&nbsp;" + "&nbsp;&nbsp;" + "&nbsp;&nbsp;" + padding + "<br>" + "\n" +
                "<u>-20</u>" + "&nbsp;&nbsp;" + "&nbsp;&nbsp;" + "&nbsp;&nbsp;"+ padding + "<br>" + "\n" +
                "00" + "&nbsp;&nbsp;" + "&nbsp;&nbsp;" + padding + "<br>" + "\n" +
                "<u>-0</u>" + "&nbsp;&nbsp;" + "&nbsp;&nbsp;" + padding + "<br>" + "\n" +
                "00" + "&nbsp;&nbsp;" + padding + "<br>" + "\n" +
                "<u>-0</u>" + "&nbsp;&nbsp;" + padding + "<br>" + "\n" +
                "0" + "&nbsp;&nbsp;" + padding + "<br>" + "\n";
        
        String result = instance.generateLongDivision(dividend, divisor);
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);

    }

    
    
}
