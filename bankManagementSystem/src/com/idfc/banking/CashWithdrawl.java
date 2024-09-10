package com.idfc.banking;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
public class CashWithdrawl extends JFrame implements ActionListener {
	
	JLabel withdrawLabel;
	JTextField withdrawlAmountTextField;
	String pin;
	JButton withdrawButton, backButton;
	
	CashWithdrawl(String pin){
		this.pin = pin;
		
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel bgimage = new JLabel(i3);
		bgimage.setBounds(0,0,900,850);
		add(bgimage);
		
		withdrawLabel = new JLabel("ENTER THE AMOUNT YOU WANT TO WITHDRAW");
		withdrawLabel.setBounds(170,265,400,40);
		withdrawLabel.setFont(new Font("System", Font.BOLD, 12));
		withdrawLabel.setForeground(Color.WHITE);
		bgimage.add(withdrawLabel);
		
		withdrawlAmountTextField = new JTextField();
		withdrawlAmountTextField.setBounds(170,300, 320, 30);
		withdrawlAmountTextField.setFont(new Font("System", Font.BOLD, 10));
		bgimage.add(withdrawlAmountTextField);
		
		withdrawButton = new JButton("WITHDRAW");
		withdrawButton.setBounds(355, 455, 150, 28);
		withdrawButton.setFont(new Font("System",Font.BOLD, 10));
		withdrawButton.addActionListener(this);
		bgimage.add(withdrawButton);
		
		backButton = new JButton("BACK");
		backButton.setBounds(355, 485, 150, 28);
		backButton.setFont(new Font("System", Font.BOLD, 10));
		backButton.addActionListener(this);
		bgimage.add(backButton);
		
		
		setSize(900,820);
		setTitle("Cash Withdrawl");
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == withdrawButton ) {
			String amountWithdrawn = withdrawlAmountTextField.getText();
			Date date = new Date();
			
			if(amountWithdrawn.equals("")) {
			
				JOptionPane.showMessageDialog(null, "Please enter an amount in the text field");
			}
			
			else {
			
					try {
						Conn c = new Conn();
						ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
						int balance =0;
						while(rs.next()) {
							if(rs.getString("type").equals("Deposit")) {
								balance += Integer.parseInt(rs.getString("amount"));
							}
							else {
								balance -= Integer.parseInt(rs.getString("amount"));
							}
						}
							
							if(balance<Integer.parseInt(amountWithdrawn)) {
								JOptionPane.showMessageDialog(null,"Insufficient balance");
								return;
							}
							
						
						String query = "insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amountWithdrawn+"')";
						c.s.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "Rs. " +amountWithdrawn+" has been withdrawn");
						setVisible(false);
						new Transactions(pin);
						
					}catch(Exception e){
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
		new CashWithdrawl("");
	}
}
