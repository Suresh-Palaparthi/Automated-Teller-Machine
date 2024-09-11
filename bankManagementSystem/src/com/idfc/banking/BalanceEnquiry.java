package com.idfc.banking;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

	String pin;
	JLabel amountLabel;
	JButton backButton;
	BalanceEnquiry(String pin){
		this.pin = pin;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel bgimage = new JLabel(i3);
		
		bgimage.setBounds(0,0,900,850);
		add(bgimage);
		
		int balance =0;
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pin+"'");
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
			
		amountLabel = new JLabel("Your Account Balance is Rs."+balance+"");
		amountLabel.setBounds(180,275,400,40);
		amountLabel.setFont(new Font("System", Font.BOLD,16));
		amountLabel.setForeground(Color.WHITE);
		bgimage.add(amountLabel);
			
		backButton = new JButton("BACK");
		backButton.setBounds(355, 485, 150, 28);
		backButton.setFont(new Font("System", Font.BOLD, 10));
		backButton.addActionListener(this);
		bgimage.add(backButton);
		
		setSize(900,820);
		setTitle("Balance Enquiry");
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(pin);
	}
	
	public static void main(String[] args){
		new BalanceEnquiry("");
	}
}
