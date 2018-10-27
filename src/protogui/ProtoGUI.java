/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protogui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 *
 * @author Thomas
 */
public class ProtoGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Layout layout1 = new Layout();
        layout1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layout1.setSize(1000,1000);
        layout1.setVisible(true);
        layout1.setLocation(550, 500);
        
        
        // TODO code application logic here
    }
    
}
