/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protogui;

import java.awt.event.ActionEvent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Thomas
 */
public class LayoutTest {
    
    public LayoutTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }



    /**
     * Test of setAdditionProblems method, of class Layout.
     */
    @Test
    public void testSetAdditionProblems() {
        System.out.println("setAdditionProblems");
        int x = 0;
        Layout instance = new Layout();
        instance.setAdditionProblems(5);
        int expResult =5;
        int result = instance.getAdditionProblems();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult,result);
    }

    /**
     * Test of getAdditionProblems method, of class Layout.
     */
    
    
}
