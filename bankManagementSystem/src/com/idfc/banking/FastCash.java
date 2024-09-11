package com.idfc.banking;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
	
	String pin;
	JLabel amountLabel;
	JButton b1, b2 ,b3, b4, b5, b6, b7;
	FastCash(String pin){
		this.pin = pin;
		getContentPane().setBackground(Color.WHITE);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel bgimage = new JLabel(i3);
		bgimage.setBounds(0,0,900,850);
		add(bgimage);
		
		amountLabel = new JLabel("SELECT WITHDRAWL AMOUNT");
		amountLabel.setBounds(220,275,400,40);
		amountLabel.setFont(new Font("System", Font.BOLD,16));
		amountLabel.setForeground(Color.WHITE);
		bgimage.add(amountLabel);

		
		b1 = new JButton("Rs.100");
		b1.setBounds(170, 395, 150, 28);
		b1.setFont(new Font("System", Font.BOLD, 10));
		b1.addActionListener(this);
		bgimage.add(b1);
		
		b2 = new JButton("Rs.200");
		b2.setBounds(355, 395, 150, 28);
		b2.setFont(new Font("System", Font.BOLD, 10));
		b2.addActionListener(this);
		bgimage.add(b2);
		
		b3 = new JButton("Rs.500");
		b3.setBounds(170, 425, 150, 28);
		b3.setFont(new Font("System", Font.BOLD, 10));
		b3.addActionListener(this);
		bgimage.add(b3);
		
		b4 = new JButton("Rs.1000");
		b4.setBounds(355, 425, 150, 28);
		b4.setFont(new Font("System", Font.BOLD, 10));
		b4.addActionListener(this);
		bgimage.add(b4);
		
		b5 = new JButton("Rs.1500");
		b5.setBounds(170, 455, 150, 28);
		b5.setFont(new Font("System", Font.BOLD, 10));
		b5.addActionListener(this);
		bgimage.add(b5);
		
		b6 = new JButton("Rs.2000");
		b6.setBounds(355, 455, 150, 28);
		b6.setFont(new Font("System", Font.BOLD, 10));
		b6.addActionListener(this);
		bgimage.add(b6);
		
		b7 = new JButton("BACK");
		b7.setBounds(355, 485, 150, 28);
		b7.setFont(new Font("System", Font.BOLD, 10));
		b7.addActionListener(this);
		bgimage.add(b7);
		
		setTitle("FastCash");
		setSize(900,820);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		
		if(ae.getSource() == b7) {
			setVisible(false);
			new Transactions(pin);
		}
		else {
			String amountWithdrawn = ((JButton)ae.getSource()).getText().substring(3);
			Date date = new Date();
			
			try {
			Conn c = new Conn();

			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
			
			int balance =0;
			while(rs.next()){
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
			
			if(balance<Integer.parseInt(amountWithdrawn)) {
				JOptionPane.showMessageDialog(null,"Insufficient Balance");
				return;
			}
			else {
				String query = "insert into bank values('"+pin+"','"+date+"','Fast Withdrawl','"+amountWithdrawn+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Rs. "+amountWithdrawn+" has been withdrawn");
				setVisible(false);
				new Login();
				
			}
			
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
	}
	public static void main(String[] args) {
		new FastCash("");
	}
	
	
}
