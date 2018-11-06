/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protogui;

import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
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
public class Layout extends JFrame implements ActionListener {

    private JLabel addLabel, genLabel, subLabel, multLabel, divLabel;
    JTextField addinput, output, subInput, multInput, divInput;
    JButton print;
    //JFrame frame2;
    JPanel panel, panel2, panel3, panel4, panel5;
    JScrollPane scroll;
    MathFunctions mathFunctions = new MathFunctions();
    WriteFile writeFile = new WriteFile();
    
    ButtonGroup buttonGroup1 = new ButtonGroup();
    ButtonGroup buttonGroup2 = new ButtonGroup();
    ButtonGroup buttonGroup3 = new ButtonGroup();
    ButtonGroup buttonGroup4 = new ButtonGroup();
    
    JRadioButton ea1,n1,h1;
    JRadioButton ea2,n2,h2;
    JRadioButton ea3,n3,h3;
    JRadioButton ea4,n4,h4;
    

    public Layout() {
        super("MathGenerator");
        setLayout(new FlowLayout());
        genLabel = new JLabel("Enter number of each type of problem");
        genLabel.setBounds(0, 0, 500, 100);
        add(genLabel);

        addLabel = new JLabel("Addition");
        addLabel.setBounds(20, 70, 100, 10);
        add(addLabel);

        subLabel = new JLabel("Subtraction");
        subLabel.setBounds(20, 100, 100, 10);
        add(subLabel);
        
        multLabel = new JLabel("Multiplication");
        multLabel.setBounds(20, 130, 100, 10);
        add(multLabel);
        
        divLabel = new JLabel("Division");
        divLabel.setBounds(20, 160, 100, 10);
        add(divLabel);

        setLayout(null);
        addinput = new JTextField(5);
        addinput.setBounds(100, 70, 100, 20);
        addinput.setText("0");
        add(addinput);

        subInput = new JTextField(5);
        subInput.setBounds(100, 100, 100, 20);
        subInput.setText("0");
        add(subInput);
        
        multInput = new JTextField(5);
        multInput.setBounds(100, 130, 100, 20);
        multInput.setText("0");
        add(multInput);
        
        divInput = new JTextField(5);
        divInput.setBounds(100, 160, 100, 20);
        divInput.setText("0");
        add(divInput);

        print = new JButton("Create Assignment");
        print.setBounds(20, 200, 170, 20);
        print.addActionListener(this);
        add(print);
        
        
        panel = new JPanel();
        
        
        ea1 = new JRadioButton("easy");
        buttonGroup1.add(ea1);
        panel.add(ea1);
        n1 = new JRadioButton("normal");
        buttonGroup1.add(n1);
        panel.add(n1);
        h1 = new JRadioButton("hard");
        buttonGroup1.add(h1);
        panel.add(h1);
        panel.setBounds(190, 60, 210, 35);
        add(panel);
        
        panel2 = new JPanel();
        ea2 = new JRadioButton("easy");
        buttonGroup2.add(ea2);
        panel2.add(ea2);
        n2 = new JRadioButton("normal");
        buttonGroup2.add(n2);
        panel2.add(n2);
        h2 = new JRadioButton("hard");
        buttonGroup2.add(h2);
        panel2.add(h2);
        panel2.setBounds(190, 95, 210, 35);
        add(panel2);
        
        panel3 = new JPanel();
        ea3 = new JRadioButton("easy");
        buttonGroup3.add(ea3);
        panel3.add(ea3);
        n3 = new JRadioButton("normal");
        buttonGroup3.add(n3);
        panel3.add(n3);
        h3 = new JRadioButton("hard");
        buttonGroup3.add(h3);
        panel3.add(h3);
        panel3.setBounds(190, 125, 210, 35);
        add(panel3);
       
        panel4 = new JPanel();
        ea4 = new JRadioButton("easy");
        buttonGroup4.add(ea4);
        panel4.add(ea4);
        n4 = new JRadioButton("normal");
        buttonGroup4.add(n4);
        panel4.add(n4);
        h4 = new JRadioButton("hard");
        buttonGroup4.add(h4);
        panel4.add(h4);
        panel4.setBounds(190, 155, 210, 35);
        add(panel4);
        
       panel5 = new JPanel();
       scroll = new JScrollPane();
       JScrollPane scrollBar=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       panel5.add(scrollBar);
       panel5.setSize(400,400); 
       panel5.setVisible(true);
       panel5.setBounds(500, 800, 50, 70);
       add(panel5);
       //add(scroll);
      
    }
    

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == print) {
            try {
                
                //Checking which radio buttons are pressed
                if (ea1.isSelected()){
                    mathFunctions.setAddDiff("easy");  
                }
                else if (n1.isSelected()){
                    mathFunctions.setAddDiff("normal");
                }
                else{
                    mathFunctions.setAddDiff("hard");
                }
                
                
                
                writeFile.startFile();
                mathFunctions.setAdditionProblems(Integer.parseInt(addinput.getText()));
                mathFunctions.setSubtractionProblems(Integer.parseInt(subInput.getText()));
                mathFunctions.setMultiplicationProblems(Integer.parseInt(multInput.getText()));
                mathFunctions.setDivisionProblems(Integer.parseInt(divInput.getText()));
                writeFile.writeFile(mathFunctions.getAdditionProblems(),
                                    mathFunctions.getSubtractionProblems(),
                                    mathFunctions.getMultiplicationProblems(),
                                    mathFunctions.getDivisionProblems(),
                                    mathFunctions.getAddDiff()
                                    );
                
                writeFile.endFile();
                writeFile.totalProblems = 0; // resets problems counter incase of multiples generations
            } catch (Exception IOException) {

            }
        }

    }

}//Layout
