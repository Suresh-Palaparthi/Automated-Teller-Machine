package com.idfc.banking;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{

	JButton signin, signup, clear;
	JTextField cardTextField;
	JPasswordField pinField;
	
	Login() {
		
		setSize(800,480);
		setTitle("IDFC - ATM");
		setLocationRelativeTo(null);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel label = new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);
		
		JLabel text = new JLabel("Welcome to IDFC Bank ATM");
		text.setFont(new Font("Osward", Font.BOLD,28));
		text.setBounds(200, 40, 500, 40);
		add(text);

		JLabel cardno = new JLabel("Card Number:");
		cardno.setFont(new Font("Raleway",Font.BOLD ,18));
		cardno.setBounds(120, 150, 150, 30);
		add(cardno);
		
		cardTextField = new JTextField();
		cardTextField.setFont(new Font("Arial", Font.BOLD,14));
		cardTextField.setBounds(300,150,250,30);
		add(cardTextField);
		
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD, 18));
		pin.setBounds(120, 190, 150, 40);
		add(pin);
		
		pinField = new JPasswordField();
		pinField.setFont(new Font("Arial", Font.BOLD,14));
		pinField.setBounds(300,190,250,30);
		add(pinField);
		
		signin = new JButton("SIGN IN");
		signin.setBackground(Color.BLACK);
		signin.setForeground(Color.WHITE);
		signin.setBounds(300, 250, 110, 30);
		signin.addActionListener(this);
		add(signin);

		clear = new JButton("CLEAR");
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.setBounds(440, 250, 110, 30);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.setBounds(300,300,250,30);
		signup.addActionListener(this);
		add(signup);
		
		
		setVisible(true);
		getContentPane().setBackground(Color.WHITE);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == signin) {
			Conn c = new Conn();
			String cardnumber = cardTextField.getText();
			String pin = pinField.getText();
			
			String query = "select * from login where card_number ='" +cardnumber+"'and pin ='"+pin+"'";
			
			try {
				ResultSet rs = c.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pin);
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid Credentials");
				}
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(ae.getSource() == clear) {
			cardTextField.setText("");
			pinField.setText("");
		}
		else if(ae.getSource() == signup) {
			setVisible(false);
			new SignupOne();
		}
		
	}

	public static void main(String[] args) {

		new Login();
	}
}
