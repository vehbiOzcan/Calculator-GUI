package calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class Calculator extends JFrame {

	private JPanel contentPane;
	private double number, result;
	private int operation;
	private JTextField input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void addInput(JTextField input, String str) {
		input.setText(input.getText() + str);
	}

	public void calculate(JTextField input) {
		switch (operation) {
		case 1:
			result = number + Double.parseDouble(input.getText());
			input.setText(Double.toString(result));
			break;
		case 2:
			result = number - Double.parseDouble(input.getText());
			input.setText(Double.toString(result));
			break;
		case 3:
			result = number * Double.parseDouble(input.getText());
			input.setText(Double.toString(result));
			break;
		case 4:
			result = number / Double.parseDouble(input.getText());
			input.setText(Double.toString(result));
			break;
		case 5:
			result = (number * Double.parseDouble(input.getText())) / 100;
			input.setText(Double.toString(result));
			break;
		case 6:
			result = number % Double.parseDouble(input.getText());
			input.setText(Double.toString(result));
			break;
		}
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		setType(Type.UTILITY);
		setTitle("Hesap Makinesi");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel screen = new JPanel();
		screen.setBounds(10, 10, 396, 77);
		contentPane.add(screen);
		screen.setLayout(null);

		JTextField input = new JTextField();
		input.setEditable(false);
		input.setFont(new Font("Tahoma", Font.BOLD, 20));
		input.setHorizontalAlignment(SwingConstants.RIGHT);
		input.setBounds(0, 31, 396, 46);
		screen.add(input);
		input.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(172, 0, 224, 32);
		screen.add(lblNewLabel);

		JPanel control = new JPanel();
		control.setBounds(10, 97, 396, 406);
		contentPane.add(control);
		control.setLayout(new GridLayout(0, 4, 10, 10));

		JButton btnNewButton_1_14 = new JButton("MOD");
		btnNewButton_1_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 6;
				input.setText("");
				lblNewLabel.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_1_14.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_14);

		JButton btnNewButton_1_13 = new JButton("AC");
		btnNewButton_1_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuffer sBuffer = new StringBuffer();
				sBuffer.append(input.getText());
				try {
					sBuffer.deleteCharAt(input.getText().length() - 1);
					input.setText(sBuffer.toString());
				} catch (Exception exc) {
					lblNewLabel.setText("HATA!");
				}
			}
		});
		btnNewButton_1_13.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_13);

		JButton btnNewButton_1_12 = new JButton("C");
		btnNewButton_1_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText("");
			}
		});
		btnNewButton_1_12.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_12);

		JButton btnNewButton_1_11 = new JButton("+");
		btnNewButton_1_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 1;
				input.setText("");
				lblNewLabel.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_1_11.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_11);

		JButton btnNewButton_1_10 = new JButton("7");
		btnNewButton_1_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(input, e.getActionCommand());
			}
		});
		btnNewButton_1_10.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_10);

		JButton btnNewButton_1_9 = new JButton("8");
		btnNewButton_1_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(input, e.getActionCommand());
			}
		});
		btnNewButton_1_9.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_9);

		JButton btnNewButton_1_8 = new JButton("9");
		btnNewButton_1_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(input, e.getActionCommand());
			}
		});
		btnNewButton_1_8.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_8);

		JButton btnNewButton_1_7 = new JButton("-");
		btnNewButton_1_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 2;
				input.setText("");
				lblNewLabel.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_1_7.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_7);

		JButton btnNewButton_1_6 = new JButton("6");
		btnNewButton_1_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(input, e.getActionCommand());
			}
		});
		btnNewButton_1_6.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_6);

		JButton btnNewButton_1_5 = new JButton("5");
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(input, e.getActionCommand());
			}
		});
		btnNewButton_1_5.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_5);

		JButton btnNewButton_1_4 = new JButton("4");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(input, e.getActionCommand());
			}
		});
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_4);

		JButton btnNewButton_1_3 = new JButton("*");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 3;
				input.setText("");
				lblNewLabel.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_3);

		JButton btnNewButton_1_1 = new JButton("3");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(input, e.getActionCommand());
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton("2");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(input, e.getActionCommand());
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_2);

		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(input, e.getActionCommand());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1);

		JButton btnNewButton_1_15 = new JButton("/");
		btnNewButton_1_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number = Double.parseDouble(input.getText());
				operation = 4;
				input.setText("");
				lblNewLabel.setText(number + e.getActionCommand());
			}
		});
		btnNewButton_1_15.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_15);

		JButton btnNewButton_1_15_2 = new JButton("0");
		btnNewButton_1_15_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addInput(input, e.getActionCommand());
			}
		});
		btnNewButton_1_15_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_15_2);

		JButton btnNewButton_1_15_4 = new JButton("=");
		btnNewButton_1_15_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculate(input);
				lblNewLabel.setText("");
			}
		});
		btnNewButton_1_15_4.setFont(new Font("Tahoma", Font.BOLD, 23));
		control.add(btnNewButton_1_15_4);
	}

}
