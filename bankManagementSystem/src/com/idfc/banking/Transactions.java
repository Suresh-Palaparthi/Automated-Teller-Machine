package com.idfc.banking;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {
	
	JLabel amountLabel;
	JButton depositButton, cashWithdrawlButton, fastCashButton, miniStatementButton, pinChangeButton, balanceEnquiryButton, exitButton;
	String pin;

	Transactions(String pin){
		this.pin = pin;
		getContentPane().setBackground(Color.WHITE);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel bgimage = new JLabel(i3);
		bgimage.setBounds(0,0,900,850);
		add(bgimage);
		
		amountLabel = new JLabel("Please select your transaction");
		amountLabel.setBounds(220,275,400,40);
		amountLabel.setFont(new Font("System", Font.BOLD,16));
		amountLabel.setForeground(Color.WHITE);
		bgimage.add(amountLabel);
		
		
		depositButton = new JButton("DEPOSIT");
		depositButton.setBounds(170, 395, 150, 28);
		depositButton.setFont(new Font("System", Font.BOLD, 10));
		depositButton.addActionListener(this);
		bgimage.add(depositButton);
		
		cashWithdrawlButton = new JButton("CASH WITHDRAWL");
		cashWithdrawlButton.setBounds(355, 395, 150, 28);
		cashWithdrawlButton.setFont(new Font("System", Font.BOLD, 10));
		cashWithdrawlButton.addActionListener(this);
		bgimage.add(cashWithdrawlButton);
		
		fastCashButton = new JButton("FAST CASH");
		fastCashButton.setBounds(170, 425, 150, 28);
		fastCashButton.setFont(new Font("System", Font.BOLD, 10));
		fastCashButton.addActionListener(this);
		bgimage.add(fastCashButton);
		
		miniStatementButton = new JButton("MINI STATEMENT");
		miniStatementButton.setBounds(355, 425, 150, 28);
		miniStatementButton.setFont(new Font("System", Font.BOLD, 10));
		miniStatementButton.addActionListener(this);
		bgimage.add(miniStatementButton);
		
		pinChangeButton = new JButton("PIN CHANGE");
		pinChangeButton.setBounds(170, 455, 150, 28);
		pinChangeButton.setFont(new Font("System", Font.BOLD, 10));
		pinChangeButton.addActionListener(this);
		bgimage.add(pinChangeButton);
		
		balanceEnquiryButton = new JButton("BALANCE ENQUIRY");
		balanceEnquiryButton.setBounds(355, 455, 150, 28);
		balanceEnquiryButton.setFont(new Font("System", Font.BOLD, 10));
		balanceEnquiryButton.addActionListener(this);
		bgimage.add(balanceEnquiryButton);
		
		exitButton = new JButton("EXIT");
		exitButton.setBounds(355, 485, 150, 28);
		exitButton.setFont(new Font("System", Font.BOLD, 10));
		exitButton.addActionListener(this);
		bgimage.add(exitButton);
		
		setTitle("Transactions");
		setSize(900,820);
		setLayout(null);
		setLocationRelativeTo(null);
//		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new Transactions("");
	}

	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == depositButton) {
			setVisible(false);
			new Deposit(pin);
		}
		if(ae.getSource() == cashWithdrawlButton) {
			setVisible(false);
			new CashWithdrawl(pin);
			
		}
		if(ae.getSource() == fastCashButton) {
			setVisible(false);
			new FastCash(pin);
		}
		if(ae.getSource() == miniStatementButton) {
			System.exit(0);
		}
		if(ae.getSource() == pinChangeButton) {
			System.exit(0);
		}
		if(ae.getSource() == balanceEnquiryButton) {
			System.exit(0);
		}
		if(ae.getSource() == exitButton) {
			System.exit(0);
		}
		
	}
}
