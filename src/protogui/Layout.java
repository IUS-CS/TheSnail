/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protogui;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.util.Random;
import java.io.*;




/**
 *
 * @author Thomas
 */
public class Layout extends JFrame implements ActionListener{
    private JLabel item1;
    JTextField input,output;
    JButton print;
    MathFunctions mathFunctions = new MathFunctions();
    WriteFile writeFile = new WriteFile();
    
    
    public Layout()
    {
        super("MathGenerator");
        setLayout(new FlowLayout());  
        item1 = new JLabel("Enter a number");
        add(item1);
        
        
        setLayout(null);
                input = new JTextField(5);
                input.setBounds(100,20,100,20);
              add(input);
             

             
              print = new JButton("Get Value");
              print.setBounds(20,200,100,20);
              print.addActionListener(this);
              add(print);
    }    
     
    public void actionPerformed(ActionEvent e)   
    {       
             if(e.getSource()== print )
             {  
                try
                {                           
                    mathFunctions.setAdditionProblems(Integer.parseInt(input.getText()));
                    writeFile.writeFile(mathFunctions.getAdditionProblems());
                }
                catch(Exception IOException)
                {
                
                }
             }
             
    }   
    
    
    
    
    
    
    
}//Layout
