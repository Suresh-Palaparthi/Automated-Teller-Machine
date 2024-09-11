package com.idfc.banking;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
public class Deposit extends JFrame implements ActionListener {

	JLabel amountLabel;
	JButton backButton, depositButton;
	JTextField amountTextField;
	String pin;
	Deposit(String pin){
		this.pin = pin;
		getContentPane().setBackground(Color.WHITE);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel bgimage = new JLabel(i3);
		
		bgimage.setBounds(0,0,900,850);
		add(bgimage);
		
		amountLabel = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
		amountLabel.setBounds(180,265,400,40);
		amountLabel.setFont(new Font("System", Font.BOLD,14));
		amountLabel.setForeground(Color.WHITE);
		bgimage.add(amountLabel);
		
		amountTextField = new JTextField();
		amountTextField.setBounds(170,320, 320, 30);
		amountTextField.setFont(new Font("System", Font.BOLD, 10));
		bgimage.add(amountTextField);
		
		depositButton = new JButton("DEPOSIT");
		depositButton.setBounds(355, 455, 150, 28);
		depositButton.setFont(new Font("System", Font.BOLD, 10));
		depositButton.addActionListener(this);
		bgimage.add(depositButton);
		
		backButton = new JButton("BACK");
		backButton.setBounds(355, 485, 150, 28);
		backButton.setFont(new Font("System", Font.BOLD, 10));
		backButton.addActionListener(this);
		bgimage.add(backButton);
		
		setSize(900,820);
		setTitle("Deposit");
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == depositButton) {
			String amountDeposited = amountTextField.getText();
			Date date = new Date();
			
			if(amountDeposited.equals("")) {
				System.out.println("Please enter the amount you want to deposit");
				
			}else {
				try {
					Conn c = new Conn();
					String query = "insert into bank values('"+pin+"','"+date+"','Deposit','"+amountDeposited+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Rs."+amountDeposited+" has been deposited to your account");
					setVisible(false);
					new Login();
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			
		}
		if(ae.getSource() == backButton) {
			setVisible(false);
			new Transactions(pin);
		}
		
	}
	
	public static void main(String[] args) {
		new Deposit("");
	}
}
