package com.idfc.banking;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
	
	String pin;
	JLabel bankNameLabel, cardLabel, cardNumberLabel, dateLabel, typeLabel, amountLabel, balanceLabel;
	JButton exitButton;
	MiniStatement(String pin){
		this.pin = pin;
		
		bankNameLabel = new JLabel("IDFC Bank");
		bankNameLabel.setBounds(175,20,100,30);
		bankNameLabel.setFont(new Font("Raleway", Font.BOLD, 14));
		add(bankNameLabel);
		
		cardLabel = new JLabel("Card Number:");
		cardLabel.setBounds(50, 80, 120, 20);
		cardLabel.setFont(new Font("Raleway", Font.BOLD, 12));
		add(cardLabel);
		
		try {
			Conn c = new Conn();
			
			ResultSet rs = c.s.executeQuery("select * from login where pin ='"+pin+"'");
			rs.next();
			String cardno = rs.getString("card_number");
			
			cardNumberLabel = new JLabel(cardno);
			cardNumberLabel.setBounds(170,80,200,20);
			cardNumberLabel.setFont(new Font("Raleway", Font.BOLD, 12));
			add(cardNumberLabel);
			
			ResultSet rs1 = c.s.executeQuery("select * from bank where pin ='"+pin+"'");
			
			int count =0;
			int balance =0;
			while(rs1.next()) {
				String date, type, amount;
				
				date = rs1.getString("date");
				type = rs1.getString("type");
				amount = rs1.getString("amount");
				
				if(type.equals("Deposit")) {
					balance += Integer.parseInt(amount);
				}else {
					balance -= Integer.parseInt(amount);
				}
				
				dateLabel = new JLabel(date);
				dateLabel.setBounds(50,160 + 30*count,200,20);
				dateLabel.setFont(new Font("Raleway", Font.BOLD, 10));
				add(dateLabel);
				
				typeLabel = new JLabel(type);
				typeLabel.setBounds(230,160 + 30*count,100,20);
				typeLabel.setFont(new Font("Raleway", Font.BOLD, 10));
				add(typeLabel);
				
				amountLabel = new JLabel(amount);
				amountLabel.setBounds(300,160 + 30*count,50,20);
				amountLabel.setFont(new Font("Raleway", Font.BOLD, 10));
				add(amountLabel);
				
				count++;
			}
			
			balanceLabel = new JLabel("Your total balance is Rs."+balance);
			balanceLabel.setBounds(50,400,200,20);
			balanceLabel.setFont(new Font("Raleway", Font.BOLD, 10));
			add(balanceLabel);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		exitButton = new JButton("EXIT");
		exitButton.setBounds(50,450,100,30);
		exitButton.setFont(new Font("Raleway", Font.BOLD, 10));
		exitButton.addActionListener(this);
		add(exitButton);
		
		
		setSize(450,550);
		setTitle("Mini Statement");
		setLocation(150,150);
		setLayout(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
			setVisible(false);
			new Login();
	}
	
	public static void main(String[] args) {
		new MiniStatement("");
	}
}
