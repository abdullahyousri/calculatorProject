package calculatorproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class matrix implements ActionListener {

    private static int rows, cols, defaultRowsNumber, defaultColsNumber, result; // matrix dimesions variable 

    private static double matrix1[][], matrix2[][], defaultMatrix[][];  // arrays 

    private static TextField input[][];  // text field variable 

    private static JButton newMatrix = new JButton("New Matrix");
    private static JButton showValue = new JButton("GET Value");

    private static JButton additionWithOtherMatrix = new JButton("add by another matrix");
    private static JButton multiplyWithOtherMatrix = new JButton("Multiplying by another matrix");
    private static JButton subtractWithOtherMatrix = new JButton("Subtracting with another Matrix");
    private static JButton showMatrix = new JButton("show Matrix");

    private static JButton addtionWithOtherMatrix = new JButton("a");
    private static JButton divisionWithOtherMatrix = new JButton("a");

    private static JPanel panel[] = new JPanel[8];  // panels which contain components 

    matrix() {
        cols = rows = 0;
        matrix1 = new double[0][0];
        ChooseOperation();
    }

    private static void Dimensions() {
        JTextField rowsField = new JTextField(10);  // rows number field 
        JTextField colsField = new JTextField(10); // cols  number field 

        JPanel panel[] = new JPanel[2];     // two panels for title and input fields
        panel[0] = new JPanel(); // title
        panel[1] = new JPanel(); // input fields 
        panel[0].add(new JLabel("Enter Dimensions")); // frame title 
        panel[1].add(new JLabel("Rows:")); // rows input field title 
        panel[1].add(rowsField); // rows input place 
        panel[1].add(Box.createHorizontalStrut(15));
        panel[1].add(new JLabel("Cols:")); // cols input field title 
        panel[1].add(colsField); // rows input place  

        JOptionPane.showConfirmDialog(null, panel, null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        rows = defaultRowsNumber;
        cols = defaultColsNumber;

        if (colsField.getText().equals("")) { // empty cols input field 
            cols = 0;
        } else {
            if (isInt(colsField.getText())) {  // make sure that input is integer number 
                cols = Integer.parseInt(colsField.getText());
            } else {
                JOptionPane.showMessageDialog(null, "Wrong Dimensions");
                cols = defaultColsNumber;
                rows = defaultRowsNumber;

            }

            if (rowsField.getText().equals("")) { // empty rows input field
                rows = 0;
            } else {
                if (isInt((rowsField.getText()))) {   // make sure that input is integer number 
                    rows = Integer.parseInt(rowsField.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Dimensions");
                    cols = defaultColsNumber;
                    rows = defaultRowsNumber;

                }
            }
        }
        if (cols < 1 || rows < 1) {  // error inputs 
            JOptionPane.showConfirmDialog(null, "You entered wrong dimensions", "Error", JOptionPane.PLAIN_MESSAGE);
            cols = defaultColsNumber;
            rows = defaultRowsNumber;

        } else {
            defaultMatrix = matrix1;
            matrix1 = new double[rows][cols];
            setElements(matrix1, "Fill your new matrix"); //filling the new matrix

        }

    }

    private static boolean setElements(double matrix[][], String title) { // this method for enter matrix2 
        int i, j;
        String result;

        JPanel panel[] = new JPanel[rows + 2];
        panel[0] = new JPanel();
        panel[0].add(new Label(title));   // panel for title 
        panel[panel.length - 1] = new JPanel();
        input = new TextField[matrix.length][matrix[0].length];   // textfiled for enter elements 

        for (i = 1; i <= matrix.length; i++) {
            panel[i] = new JPanel();

            for (j = 0; j < matrix[0].length; j++) {
                input[i - 1][j] = new TextField(5);
                panel[i].add(input[i - 1][j]);

            }//end col loop

        }//end row loop

         JOptionPane.showConfirmDialog(null, panel, null, JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);

      

            for (i = 0; i < matrix.length; i++) {
                for (j = 0; j < matrix[0].length; j++) {
                    result = input[i][j].getText();

                    if (isDouble(result)) {
                        matrix[i][j] = Double.parseDouble(input[i][j].getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "You entered wrong elements");

                        cols = defaultColsNumber;
                        rows = defaultRowsNumber;

                        return false;
                    }
                }
            }
            return true;
       

    }

    private static void checkTextField(TextField field[][]) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                if (field[i][j].getText().equals("")) {
                    field[i][j].setText("0");
                }
            }
        }
    }//end reset

    private void ChooseOperation() {
        int i;

        for (i = 0; i < panel.length; i++) {
            panel[i] = new JPanel();
        }
        additionWithOtherMatrix.setPreferredSize(new Dimension(175, 35));
        additionWithOtherMatrix.addActionListener(this);
        panel[2].add(additionWithOtherMatrix);

        subtractWithOtherMatrix.setPreferredSize(new Dimension(175, 35));
        subtractWithOtherMatrix.addActionListener(this);
        panel[3].add(subtractWithOtherMatrix);

        multiplyWithOtherMatrix.setPreferredSize(new Dimension(175, 35));
        multiplyWithOtherMatrix.addActionListener(this);
        panel[4].add(multiplyWithOtherMatrix);

        showValue.setPreferredSize(new Dimension(175, 35));
        showValue.addActionListener(this);
        panel[5].add(showValue);

        showMatrix.setPreferredSize(new Dimension(175, 35));
        showMatrix.addActionListener(this);
        panel[6].add(showMatrix);

        newMatrix.setPreferredSize(new Dimension(175, 35));
        newMatrix.setForeground(Color.red);
        newMatrix.addActionListener(this);
        panel[7].add(newMatrix);

        JOptionPane.showConfirmDialog(null, panel, null, JOptionPane.CLOSED_OPTION, JOptionPane.PLAIN_MESSAGE);

    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == additionWithOtherMatrix) {
            matrixAddMatrix();

        } else if (a.getSource() == subtractWithOtherMatrix) {
            matrixMinusMatrix();

        } else if (a.getSource() == multiplyWithOtherMatrix) {
            multiplyByMatrix();

        } else if (a.getSource() == showValue) {
            GetValue();
        } else if (a.getSource() == newMatrix) {
            newMatrix();
        }
        if (a.getSource() == showMatrix) {
            showMatrix(matrix1, "Your Matrix");
        }
    }//end action performed

    private static double getValue(double[][] matrix) {
        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                value += matrix[i][j];
            }
        }
        return value;
    }//end getValue

    private static void showMatrix(double[][] matrix, String title) {
        int i, j;             //temprature variable

        JPanel panel[] = new JPanel[matrix.length + 1];
        panel[0] = new JPanel();
        panel[0].add(new JLabel(title));

        for (i = 1; i <= matrix.length; i++) {
            panel[i] = new JPanel();

            for (j = 0; j < matrix[0].length; j++) {
                if (matrix[i - 1][j] == -0) {
                    matrix[i - 1][j] = 0;
                }
                panel[i].add(new JLabel(String.format("%.2f", matrix[i - 1][j])));

            }//end col loop

        }//end row loop

        if (cols == 0 || rows == 0) {
            JOptionPane.showMessageDialog(null, "You haven't entered any matrix");
        } else {

            JOptionPane.showMessageDialog(null, panel, null, JOptionPane.PLAIN_MESSAGE, null);
        }
    }//end show Matrix

    private static void matrixAddMatrix() {
        if (matrix1.length < 1) {
            JOptionPane.showMessageDialog(null, "You haven't entered any matrix");
        } else {
            double matrix2[][] = new double[rows][cols];
            double add;
            if (setElements(matrix2, "Fill The Matrix of Combination ")) {

                add = getValue(matrix1) + getValue(matrix2);

                JOptionPane.showMessageDialog(null, add, "addition result", JOptionPane.PLAIN_MESSAGE);

            }
        }
    }

    private static void matrixMinusMatrix() {

        if (matrix1.length < 1) {
            JOptionPane.showMessageDialog(null, "You haven't entered any matrix");
        } else {
            double matrix2[][] = new double[rows][cols];
            double sub[][] = new double[rows][cols];
            double reverseMatrix2[][] = new double[rows][cols];

            if (setElements(matrix2, "Fill Subtracting Matrix")) {

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        reverseMatrix2[i][j] = (-1 * matrix2[i][j]);
                        sub[i][j] = matrix1[i][j] + reverseMatrix2[i][j];
                    }
                }
                showMatrix(sub, "Subtracting Result");
                JOptionPane.showConfirmDialog(null, getValue(sub), "the result of subtract", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
        }//end else of checking
    }

    private static void multiplyByMatrix() {

        JTextField wField = new JTextField(5); //col field
        int col2 = 0;
        double matrix2[][], results[][];
        int sum;

        if (matrix1.length < 1) {
            JOptionPane.showMessageDialog(null, "You haven't entered any matrix");
        } else {

            //design input line
            JPanel choosePanel[] = new JPanel[2];
            choosePanel[0] = new JPanel();
            choosePanel[1] = new JPanel();

            choosePanel[0].add(new JLabel("Enter Dimensitions"));

            choosePanel[1].add(new JLabel("Rows:"));
            choosePanel[1].add(new JLabel("" + cols));

            choosePanel[1].add(new JLabel("Cols:"));
            choosePanel[1].add(wField);

            result = JOptionPane.showConfirmDialog(null, choosePanel,
                    null, JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.PLAIN_MESSAGE);

            if (result == 0) {
                if (wField.getText().equals("")) {
                    col2 = 0;
                } else {
                    if (isInt(wField.getText())) {
                        col2 = Integer.parseInt(wField.getText());

                    }
                }

                matrix2 = new double[cols][col2];
                results = new double[rows][col2];
                if (setElements(matrix2, "Fill multiplying matrix")) {

                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < col2; j++) {
                            sum = 0;
                            for (int k = 0; k < cols; k++) {
                                sum += matrix1[i][k] * matrix2[k][j];
                            }

                            results[i][j] = sum;

                        }
                    }

                    showMatrix(results, "Mulitiplication Result");
                    JOptionPane.showConfirmDialog(null, getValue(results), "the result of subtract", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);

                }//elements checking
            }//dimensions checking
            else {
                return;
            }
        }//end else of checking
    }//end multiply by matrix method

    private static void GetValue() {
        if (matrix1.length < 1) {
            JOptionPane.showMessageDialog(null, "You haven't entered any matrix");

        } else {
            double result = getValue(matrix1);

            JOptionPane.showMessageDialog(null, String.format("Determination's Value = %.2f", getValue(matrix1)), null, JOptionPane.PLAIN_MESSAGE, null);
        }
    }//end gui get Value

    private static boolean isInt(String a) {
        int i;
        if (a.length() == '0') {
            return false;
        }

        for (i = 0; i < a.length(); i++) {
            if (a.charAt(i) != '+' && a.charAt(i) != '-'
                    && !Character.isDigit(a.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDouble(String b) {
        int j;
        if (b.length() == '0') {
            return false;
        }

        for (j = 0; j < b.length(); j++) {
            if (b.charAt(j) != '+' && b.charAt(j) != '-'
                    && b.charAt(j) != '.'
                    && !Character.isDigit(b.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    private static void newMatrix() {
        Dimensions();
    }

}
