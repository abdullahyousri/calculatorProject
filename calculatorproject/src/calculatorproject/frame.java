package calculatorproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class frame extends JFrame implements ActionListener {

    private static JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bEqual, bAdd, bSub, bMulti, bDiv, bDot, bQuadratic, bOff, bArray, bRoot, bClear; // buttons 
    private static TextField text;    // text field 

    private static double num1;  // input variable 
    private static double num2;
    private static double result;
    private static char ope;    // operation symbol 

    public frame() {
        // frame 
        {
            JFrame frame = new JFrame();    // frame intilization 
            this.setTitle("calculator project");     // project title
            this.setSize(320, 510);             // frame dimensions 
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setLayout(null);
        }
        // text field
        {
            text = new TextField(15);
        }
        // buttons intitlization 
        {
            b0 = new JButton("0");
            b1 = new JButton("1");
            b2 = new JButton("2");
            b3 = new JButton("3");
            b4 = new JButton("4");
            b5 = new JButton("5");
            b6 = new JButton("6");
            b7 = new JButton("7");
            b8 = new JButton("8");
            b9 = new JButton("9");
            bEqual = new JButton("=");
            bAdd = new JButton("+");
            bSub = new JButton("-");
            bMulti = new JButton("*");
            bDiv = new JButton("/");
            bDot = new JButton(".");
            bQuadratic = new JButton("quadratic equation");
            bRoot = new JButton("sqrt");
            bOff = new JButton("off");
            bArray = new JButton("array");
            bClear = new JButton("clear");
        }

        // add items to frame 
        {
            this.add(b0);
            this.add(b1);
            this.add(b2);
            this.add(b3);
            this.add(b4);
            this.add(b5);
            this.add(b6);
            this.add(b7);
            this.add(b8);
            this.add(b9);
            this.add(bEqual);
            this.add(bAdd);
            this.add(bSub);
            this.add(bMulti);
            this.add(bDiv);
            this.add(bDot);
            this.add(bQuadratic);
            this.add(bOff);
            this.add(bArray);
            this.add(bRoot);
            this.add(text);
            this.add(bClear);
        }
         // set items dimensions 
        {
            text.setBounds(10, 40, 280, 50);
            b0.setBounds(70, 360, 50, 50);
            b1.setBounds(10, 300, 50, 50);
            b2.setBounds(70, 300, 50, 50);
            b3.setBounds(130, 300, 50, 50);
            b4.setBounds(10, 240, 50, 50);
            b5.setBounds(70, 240, 50, 50);
            b6.setBounds(130, 240, 50, 50);
            b7.setBounds(10, 180, 50, 50);
            b8.setBounds(70, 180, 50, 50);
            b9.setBounds(130, 180, 50, 50);
            bEqual.setBounds(10, 360, 50, 50);
            bAdd.setBounds(230, 110, 70, 50);
            bSub.setBounds(230, 180, 70, 50);
            bMulti.setBounds(230, 240, 70, 50);
            bDiv.setBounds(230, 300, 70, 50);
            bDot.setBounds(130, 360, 50, 50);
            bRoot.setBounds(230, 360, 70, 50);
            bQuadratic.setBounds(10, 420, 170, 50);
            bOff.setBounds(130, 110, 50, 50);
            bOff.setForeground(Color.red);
            bArray.setBounds(230, 420, 70, 50);
            bClear.setBounds(10, 110, 110, 50);
        }
        // add actions to buttons 
        {
        b0.addActionListener(new b0Action());
        b1.addActionListener(new b1Action());
        b2.addActionListener(new b2Action());
        b3.addActionListener(new b3Action());
        b4.addActionListener(new b4Action());
        b5.addActionListener(new b5Action());
        b6.addActionListener(new b6Action());
        b7.addActionListener(new b7Action());
        b8.addActionListener(new b8Action());
        b9.addActionListener(new b9Action());
        bDot.addActionListener(new bDotAction());
        bClear.addActionListener(new bClearAction());
        bAdd.addActionListener(new bAddAction());
        bSub.addActionListener(new bSubAction());
        bDiv.addActionListener(new bDivAction());
        bMulti.addActionListener(new bMultiAction());
        bEqual.addActionListener(new bEqualAction());
        bOff.addActionListener(new bOffAction());
        bRoot.addActionListener(new bRootAction());
        bArray.addActionListener(new bArrayAction());
        bQuadratic.addActionListener(new bQuadraticAction());
        }
    }

    private void setNumbersButtons(String b) {    // method to set acion for numbers buttons 
        String AllProgram = text.getText() + b;
        text.setText(AllProgram);
    }

    private void setOperationButtons(char operation) {  // method to set action for operations buttons 
        num1 = Double.parseDouble(text.getText());
        text.setText("");
        ope = operation;
    }

    class b0Action implements ActionListener { // number 0 

        public void actionPerformed(ActionEvent a) {
            setNumbersButtons("0");
        }
    }

    class b1Action implements ActionListener {  // number 1

        public void actionPerformed(ActionEvent a) {
            setNumbersButtons("1");
        }
    }

    class b2Action implements ActionListener {  // number 2

        public void actionPerformed(ActionEvent a) {
            setNumbersButtons("2");
        }
    }

    class b3Action implements ActionListener { // number 3 

        public void actionPerformed(ActionEvent a) {
            setNumbersButtons("3");
        }
    }

    class b4Action implements ActionListener {  // number 4

        public void actionPerformed(ActionEvent a) {
            setNumbersButtons("4");
        }
    }

    class b5Action implements ActionListener {  // number 5

        public void actionPerformed(ActionEvent a) {
            setNumbersButtons("5");
        }
    }

    class b6Action implements ActionListener { // number 6 

        public void actionPerformed(ActionEvent a) {
            setNumbersButtons("6");
        }
    }

    class b7Action implements ActionListener { // number 7

        public void actionPerformed(ActionEvent a) {
            setNumbersButtons("7");
        }
    }

    class b8Action implements ActionListener {  // number 8

        public void actionPerformed(ActionEvent a) {
            setNumbersButtons("8");
        }
    }

    class b9Action implements ActionListener {  // number 9

        public void actionPerformed(ActionEvent a) {
            setNumbersButtons("9");
        }
    }

    class bDotAction implements ActionListener {  // dot button 

        public void actionPerformed(ActionEvent a) {
            setNumbersButtons(".");
        }
    }

    class bClearAction implements ActionListener {    // clear button 

        public void actionPerformed(ActionEvent a) {
            text.setText("");
        }
    }

    class bAddAction implements ActionListener {   // + button 

        public void actionPerformed(ActionEvent a) {
            setOperationButtons('+');
        }
    }

    class bSubAction implements ActionListener {  // - button 

        public void actionPerformed(ActionEvent a) {
            setOperationButtons('-');
        }
    }

    class bDivAction implements ActionListener {   // / button 

        public void actionPerformed(ActionEvent a) {
            setOperationButtons('/');
        }
    }

    class bMultiAction implements ActionListener {  // * button 

        public void actionPerformed(ActionEvent a) {
            setOperationButtons('*');
        }
    }

    class bEqualAction implements ActionListener {  // = button 

        public void actionPerformed(ActionEvent a) {
            num2 = Double.parseDouble(text.getText());
            switch (ope) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            text.setText(String.valueOf(result));
        }
    }

    class bOffAction implements ActionListener {   // off button 

        public void actionPerformed(ActionEvent a) {
            System.exit(0);
        }
    }

    class bRootAction implements ActionListener {  // sqrt button 

        public void actionPerformed(ActionEvent a) {
            num1 = Double.parseDouble(text.getText());
            result = Math.sqrt(num1);
            text.setText(String.valueOf(result));
        }
    }

    class bQuadraticAction implements ActionListener {  // quadratic equation button 

        public void actionPerformed(ActionEvent a) {
            QuadraticEquation c = new QuadraticEquation();
        }
    }

    class bArrayAction implements ActionListener {   // array button 

        public void actionPerformed(ActionEvent a) {
            matrix d = new matrix();
        }
    }

    public static void main(String[] args) {
        new frame();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
