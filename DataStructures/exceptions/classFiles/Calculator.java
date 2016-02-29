package exceptions.classFiles;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Calculator extends JFrame implements ActionListener {
	JTextField txtField1 = new JTextField(8);
	JTextField txtField2 = new JTextField(8);
	JTextField lblOutput = new JTextField(8);
	JButton btnAdd = new JButton("Add");
	JButton btnSubtract = new JButton("Subtract");
	JButton btnMultiply = new JButton("Multiply");
	JButton btnDivide = new JButton("Divide");

	public Calculator() {
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.add(new JLabel("Number 1"));
		p1.add(txtField1);
		p1.add(new JLabel("Number 2"));
		p1.add(txtField2);
		p1.add(new JLabel("Result"));

		lblOutput.setEditable(false);
		p1.add(lblOutput);

		p1.setBorder(new LineBorder(Color.BLACK, 1));

		JPanel p2 = new JPanel();
		p2.add(btnAdd);
		p2.add(btnSubtract);
		p2.add(btnMultiply);
		p2.add(btnDivide);
		p2.setBorder(new LineBorder(Color.BLACK, 1));

		setLayout(new GridLayout(2, 1));
		add(p1);
		add(p2);

		btnAdd.addActionListener(this);
		btnSubtract.addActionListener(this);
		btnMultiply.addActionListener(this);
		btnDivide.addActionListener(this);
	}

	public static void main(String[] args) {
		JFrame frame = new Calculator();
		frame.setTitle("Calculator");
		frame.setSize(500, 120);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		try{
			double d1 = Double.parseDouble(txtField1.getText());
			double d2 = Double.parseDouble(txtField2.getText());
			double result = -1;

			if (e.getSource() == btnAdd) {
				result = d1 + d2;
			} else if (e.getSource() == btnSubtract) {
				result = d1 - d2;
			} else if (e.getSource() == btnMultiply) {
				result = d1 * d2;
			} else if (e.getSource() == btnDivide) {
				result = d1 / d2;

				// stupid code that throws an exception.
				int[] a = new int[1];
				a[5] = 16;
			}

			lblOutput.setText("" + result);
		} catch (NumberFormatException ex){ // any exception that is/has NumberFormatException as its parent does this
			lblOutput.setText("Error");
		} catch (Exception ex1){ //any exception
            lblOutput.setText("Error");
            ex1.printStackTrace();
            throw ex1;
        }
	}
}
