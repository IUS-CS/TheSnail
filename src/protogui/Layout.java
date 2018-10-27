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
        
        JRadioButton y,n,c;
        panel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();
        y = new JRadioButton("easy");
        buttonGroup.add(y);
        panel.add(y);
        n = new JRadioButton("normal");
        buttonGroup.add(n);
        panel.add(n);
        c = new JRadioButton("hard");
        buttonGroup.add(c);
        panel.add(c);
        panel.setBounds(190, 60, 210, 35);
        add(panel);
        
        panel2 = new JPanel();
        y = new JRadioButton("easy");
        buttonGroup.add(y);
        panel2.add(y);
        n = new JRadioButton("normal");
        buttonGroup.add(n);
        panel2.add(n);
        c = new JRadioButton("hard");
        buttonGroup.add(c);
        panel2.add(c);
        panel2.setBounds(190, 95, 210, 35);
        add(panel2);
        
        panel3 = new JPanel();
        y = new JRadioButton("easy");
        buttonGroup.add(y);
        panel3.add(y);
        n = new JRadioButton("normal");
        buttonGroup.add(n);
        panel3.add(n);
        c = new JRadioButton("hard");
        buttonGroup.add(c);
        panel3.add(c);
        panel3.setBounds(190, 125, 210, 35);
        add(panel3);
       
        panel4 = new JPanel();
        y = new JRadioButton("easy");
        buttonGroup.add(y);
        panel4.add(y);
        n = new JRadioButton("normal");
        buttonGroup.add(n);
        panel4.add(n);
        c = new JRadioButton("hard");
        buttonGroup.add(c);
        panel4.add(c);
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
                writeFile.startFile();
                
                mathFunctions.setAdditionProblems(Integer.parseInt(addinput.getText()));
                writeFile.writeFile(mathFunctions.getAdditionProblems(), "addition");
                mathFunctions.setSubtractionProblems(Integer.parseInt(subInput.getText()));
                writeFile.writeFile(mathFunctions.getSubtractionProblems(), "subtraction");
                mathFunctions.setMultiplicationProblems(Integer.parseInt(multInput.getText()));
                writeFile.writeFile(mathFunctions.getMultiplicationProblems(), "multiplication");
                mathFunctions.setDivisionProblems(Integer.parseInt(divInput.getText()));
                writeFile.writeFile(mathFunctions.getDivisionProblems(), "division");
                
                writeFile.endFile();
            } catch (Exception IOException) {

            }
        }

    }

}//Layout
