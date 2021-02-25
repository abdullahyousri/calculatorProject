package calculatorproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class QuadraticEquation extends JFrame implements ActionListener {

    private static JLabel label1, label2, label3, result1, result2; // titles for text fields 
    private static TextField text1, text2, text3, result3, result4;  // text fields 
    private static JButton bSolve, bReset;  // buttons 
    private static double a, b, c, d, e, f, g, h, l;   // inputs variables 

    public QuadraticEquation() {

        {// frame 
            JFrame frame = new JFrame();
            this.setTitle("solveQyadraticEquation");
            this.setSize(400, 230);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setLayout(null);
        }

        {// initilaztions for labels and text fields and buttons
            label1 = new JLabel("X²  + ");
            label2 = new JLabel("x  + ");
            label3 = new JLabel("=  0");
            result1 = new JLabel("x1 = ");
            result2 = new JLabel("x2 = ");
            text1 = new TextField(10);
            text2 = new TextField(10);
            text3 = new TextField(10);
            result3 = new TextField(10);
            result4 = new TextField(10);
            bSolve = new JButton("Solve");
            bReset = new JButton("Reset");
            result3.setEditable(false);
            result4.setEditable(false);
        }

        { // add items to frame
            this.add(label1);  // x2
            this.add(label2);  // x + 
            this.add(label3);  // = 0
            this.add(result1); // x1 
            this.add(result2); // x2 
            this.add(text1);   // textField
            this.add(text2);   // textField
            this.add(text3);   // textField
            this.add(result3); // textField
            this.add(result4); // textField
            this.add(bSolve);  // Button
            this.add(bReset); // Button
        }

        {  // set dimensions for items 
            label1.setBounds(110, 30, 30, 30);
            label2.setBounds(210, 30, 30, 30);
            label3.setBounds(300, 30, 30, 30);
            result1.setBounds(60, 90, 30, 30);
            result2.setBounds(190, 90, 30, 30);
            text1.setBounds(50, 30, 50, 30);
            text2.setBounds(150, 30, 50, 30);
            text3.setBounds(240, 30, 50, 30);
            result3.setBounds(90, 90, 60, 30);
            result4.setBounds(220, 90, 60, 30);
            bSolve.setBounds(40, 150, 150, 30);
            bReset.setBounds(210, 150, 150, 30);
            bSolve.addActionListener(new bSolveAction());
            bReset.addActionListener(new bResetAction());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class bSolveAction implements ActionListener {  // make action for solve button 

        public void actionPerformed(ActionEvent w) {
            { // get inputs from text fields 
            a = Double.parseDouble(text1.getText());
            b = Double.parseDouble(text2.getText());
            c = Double.parseDouble(text3.getText()); 
            } 
            
            { // make an equation for solve quadratic equation 
            d = (b * b) - (4 * a * c);
            e = Math.sqrt(d);
            f = (-b + e);
            g = (-b - e);
            h = f / (2 * a); // first value of x 
            l = g / (2 * a); // second value of x 
            }
            
            { // set text outs of text fields
                result3.setText(String.valueOf(h)); 
                result4.setText(String.valueOf(l));
            }
        }
    }

    class bResetAction implements ActionListener {  // make an action for reset button 

        public void actionPerformed(ActionEvent k) {
            result3.setText("");
            result4.setText("");
            text1.setText("");
            text2.setText("");
            text3.setText("");
        }
    }

    public static void main(String[] args) {
        new QuadraticEquation();
    }
}
