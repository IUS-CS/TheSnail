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
public class Layout extends JFrame implements ActionListener {

    private JLabel addLabel, genLabel, subLabel, multLabel, divLabel;
    JTextField addinput, output, subInput, multInput, divInput;
    JButton print;
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
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == print) {
            try {
                writeFile.startFile();
                
                mathFunctions.setAdditionProblems(Integer.parseInt(addinput.getText()));
                
                mathFunctions.setSubtractionProblems(Integer.parseInt(subInput.getText()));

                mathFunctions.setMultiplicationProblems(Integer.parseInt(multInput.getText()));

                mathFunctions.setDivisionProblems(Integer.parseInt(divInput.getText()));
                writeFile.writeFile(mathFunctions.getAdditionProblems(),
                                    mathFunctions.getSubtractionProblems(),
                                    mathFunctions.getMultiplicationProblems(),
                                    mathFunctions.getDivisionProblems()
                                    );
                
                writeFile.endFile();
                writeFile.totalProblems = 0; // resets problems counter incase of multiples generations
            } catch (Exception IOException) {

            }
        }

    }

}//Layout
