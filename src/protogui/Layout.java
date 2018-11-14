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

    private JLabel addLabel, genLabel, subLabel, multLabel, divLabel, expLabel;
    JTextField addinput, output, subInput, multInput, divInput, expInput;
    JButton print;
    //JFrame frame2;
    JPanel panel, panel2, panel3, panel4, panel5, panel6;
    JScrollPane scroll;
    MathFunctions mathFunctions = new MathFunctions();
    WriteFile writeFile = new WriteFile();
    
    ButtonGroup buttonGroup1 = new ButtonGroup();
    ButtonGroup buttonGroup2 = new ButtonGroup();
    ButtonGroup buttonGroup3 = new ButtonGroup();
    ButtonGroup buttonGroup4 = new ButtonGroup();
    ButtonGroup buttonGroup5 = new ButtonGroup();
    
    JRadioButton ea1,n1,h1;
    JRadioButton ea2,n2,h2;
    JRadioButton ea3,n3,h3;
    JRadioButton ea4,n4,h4;
    JRadioButton ea5,n5,h5;
    

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
        
        expLabel = new JLabel("Exponential");
        expLabel.setBounds(20, 190, 100, 10);
        add(expLabel);

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

        expInput = new JTextField(5);
        expInput.setBounds(100, 190, 100, 20);
        expInput.setText("0");
        add(expInput);
        
        print = new JButton("Create Assignment");
        print.setBounds(20, 250, 170, 20);
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
        ea1.setSelected(true);
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
        ea2.setSelected(true);
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
        ea3.setSelected(true);
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
        ea4.setSelected(true);
        panel4.setBounds(190, 155, 210, 35);
        add(panel4);
        
        panel5 = new JPanel();
        ea5 = new JRadioButton("easy");
        buttonGroup5.add(ea5);
        panel5.add(ea5);
        n5 = new JRadioButton("normal");
        buttonGroup5.add(n5);
        panel5.add(n5);
        h5 = new JRadioButton("hard");
        buttonGroup5.add(h5);
        panel5.add(h5);
        ea5.setSelected(true);
        panel5.setBounds(190, 185, 210, 35);
        add(panel5);
        
       panel6 = new JPanel();
       scroll = new JScrollPane();
       JScrollPane scrollBar=new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       panel6.add(scrollBar);
       panel6.setSize(400,400); 
       panel6.setVisible(true);
       panel6.setBounds(500, 800, 50, 70);
       add(panel6);
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
                
                if (ea2.isSelected()){
                    mathFunctions.setSubDiff("easy");  
                }
                else if (n2.isSelected()){
                    mathFunctions.setSubDiff("normal");
                }
                else{
                    mathFunctions.setSubDiff("hard");
                }
                
                if (ea3.isSelected()){
                    mathFunctions.setMultDiff("easy");  
                }
                else if (n3.isSelected()){
                    mathFunctions.setMultDiff("normal");
                }
                else{
                    mathFunctions.setMultDiff("hard");
                }
                
                if (ea4.isSelected()){
                    mathFunctions.setDivDiff("easy");  
                }
                else if (n4.isSelected()){
                    mathFunctions.setDivDiff("normal");
                }
                else{
                    mathFunctions.setDivDiff("hard");
                }
                
                if (ea5.isSelected()){
                    mathFunctions.setExpDiff("easy");  
                }
                else if (n5.isSelected()){
                    mathFunctions.setExpDiff("normal");
                }
                else{
                    mathFunctions.setExpDiff("hard");
                }
                
                writeFile.file();
                mathFunctions.setAdditionProblems(Integer.parseInt(addinput.getText()));
                mathFunctions.setSubtractionProblems(Integer.parseInt(subInput.getText()));
                mathFunctions.setMultiplicationProblems(Integer.parseInt(multInput.getText()));
                mathFunctions.setDivisionProblems(Integer.parseInt(divInput.getText()));
                mathFunctions.setExponentProblems(Integer.parseInt(expInput.getText()));
                writeFile.writeFile(mathFunctions.getAdditionProblems(),
                                    mathFunctions.getSubtractionProblems(),
                                    mathFunctions.getMultiplicationProblems(),
                                    mathFunctions.getDivisionProblems(),
                                    mathFunctions.getExponentProblems(),
                                    mathFunctions.getAddDiff(),
                                    mathFunctions.getSubDiff(),
                                    mathFunctions.getMultDiff(),
                                    mathFunctions.getDivDiff(),
                                    mathFunctions.getExpDiff()
                                    );
                
                writeFile.endFile();
                writeFile.totalProblems = 0; // resets problems counter incase of multiples generations
            } catch (Exception IOException) {

            }
        }

    }

}//Layout
