package com.idfc.banking;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener {

	JLabel page3, actype, cardNo, cardNoSample, cardNoSub, cardNoSampleSub, pinLabel, pinSample, pinSub, servicesReq;
	JRadioButton savingsAc, fdAc, currentAc, recAc;
	ButtonGroup actypeGroup;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submitButton, cancelButton;
	int random;
	String formno;
	
	SignupThree(String formno){
		
		getContentPane().setBackground(Color.WHITE);
		setTitle("Sign Up - C");
		setSize(850,800);
		setLocationRelativeTo(null);
		setLayout(null);
		
		
		this.formno = formno;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2); 
		
		JLabel icon = new JLabel(i3);
		icon.setBounds(150, 0, 100 , 100);
		add(icon);
		
		page3 = new JLabel("Page 3: Account Details");
		page3.setBounds(300, 40, 500, 40);
		page3.setFont(new Font("Raleway",Font.BOLD , 18));
		add(page3);
		
		
		actype = new JLabel("Account Type:");
		actype.setBounds(130, 130, 200, 40);
		actype.setFont(new Font("Raleway", Font.BOLD, 18));
		add(actype);
		
		savingsAc = new JRadioButton("Savings Account");
		savingsAc.setBounds(140,180, 200, 40);
		savingsAc.setFont(new Font("Raley",Font.BOLD, 16));
		savingsAc.setBackground(Color.WHITE);
		add(savingsAc);
		
		fdAc = new JRadioButton("Fixed Deposit Account");
		fdAc.setBounds(340,180, 300, 40);
		fdAc.setFont(new Font("Raley",Font.BOLD, 16));
		fdAc.setBackground(Color.WHITE);
		add(fdAc);
		
		currentAc = new JRadioButton("Current Account");
		currentAc.setBounds(140,210, 200, 40);
		currentAc.setFont(new Font("Raley",Font.BOLD, 16));
		currentAc.setBackground(Color.WHITE);
		add(currentAc);
		
		recAc = new JRadioButton("Recurring Deposit Account");
		recAc.setBounds(340,210, 300, 40);
		recAc.setFont(new Font("Raley",Font.BOLD, 16));
		recAc.setBackground(Color.WHITE);
		add(recAc);
		
		actypeGroup = new ButtonGroup();
		actypeGroup.add(savingsAc);
		actypeGroup.add(fdAc);
		actypeGroup.add(currentAc);
		actypeGroup.add(recAc);
		
		
		cardNo = new JLabel("Card Number:");
		cardNo.setBounds(130, 250, 200, 40);
		cardNo.setFont(new Font("Raleway", Font.BOLD, 18));
		add(cardNo);
		
		cardNoSample = new JLabel("XXXX-XXXX-XXXX-4184");
		cardNoSample.setBounds(340, 250, 400, 40);
		cardNoSample.setFont(new Font("Raleway", Font.BOLD, 18));
		add(cardNoSample);
		
		cardNoSub = new JLabel("(Your 16-digit card number)");
		cardNoSub.setBounds(130, 270, 200, 40);
		cardNoSub.setFont(new Font("Raleway", Font.BOLD, 11));
		add(cardNoSub);
		
		cardNoSampleSub = new JLabel("It would appear on atm card/cheque Books and Statements");
		cardNoSampleSub.setBounds(340, 270, 400, 40);
		cardNoSampleSub.setFont(new Font("Raleway", Font.BOLD, 11));
		add(cardNoSampleSub);
		
		
		pinLabel = new JLabel("PIN:");
		pinLabel.setBounds(130, 320, 200, 40);
		pinLabel.setFont(new Font("Raleway", Font.BOLD, 18));
		add(pinLabel);
		
		pinSample = new JLabel("XXXX");
		pinSample.setBounds(340, 320, 400, 40);
		pinSample.setFont(new Font("Raleway", Font.BOLD, 18));
		add(pinSample);
		
		pinSub = new JLabel("(4-digit password)");
		pinSub.setBounds(130, 340, 200, 40);
		pinSub.setFont(new Font("Raleway", Font.BOLD, 11));
		add(pinSub);
		
		servicesReq = new JLabel("Services Required:");
		servicesReq.setBounds(130, 380, 300, 40);
		servicesReq.setFont(new Font("Raleway", Font.BOLD, 18));
		add(servicesReq);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setBounds(140, 410, 200, 40);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBounds(340, 410, 200, 40);
		c2.setBackground(Color.WHITE);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBounds(140, 450, 200, 40);
		c3.setBackground(Color.WHITE);
		add(c3);
		
		c4 = new JCheckBox("Email Alerts");
		c4.setBounds(340, 450, 200, 40);
		c4.setBackground(Color.WHITE);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBounds(140, 490, 200, 40);
		c5.setBackground(Color.WHITE);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setBounds(340, 490, 200, 40);
		c6.setBackground(Color.WHITE);
		add(c6);
		
		c7 = new JCheckBox("I hereby declare that this information is correct to the best of my knowledge");
		c7.setFont(new Font("Raleway", Font.BOLD, 11));
		c7.setBackground(Color.white);
		c7.setBounds(140, 550, 1000, 40);
		add(c7);
		
		submitButton = new JButton("Submit");
		submitButton.setBackground(Color.BLACK);
		submitButton.setForeground(Color.WHITE);
		submitButton.setBounds(280, 600, 100, 40);
		submitButton.addActionListener(this);
		add(submitButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.BLACK);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBounds(400, 600, 100, 40);
		cancelButton.addActionListener(this);
		add(cancelButton);
		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submitButton) {
			
			String accountType = null;
			if(savingsAc.isSelected()) {
				accountType = "Savings Account";
			}
			else if(fdAc.isSelected()) {
				accountType = "Fixed Deposit Account";
			}
			else if(currentAc.isSelected()) {
				accountType = "Current Account";
			}
			else if(recAc.isSelected()) {
				accountType = "Recurring Deposit Account";
			}
			
			String cardNumber = "" + (long)((Math.random() * 9000000000000000L) + 1000000000000000L);
			String pin ="" + (int)((Math.random() * 9000) + 1000);
			
			String facilities = null;
			if(c1.isSelected()) {
				facilities = "ATM Card";
			}
			if(c2.isSelected()) {
				facilities = facilities + " Internet Banking";
			}
			if(c3.isSelected()) {
				facilities = facilities + " Mobile Banking";
			}
			if(c4.isSelected()) {
				facilities = facilities + " Email Alerts";
			}
			if(c5.isSelected()) {
				facilities = facilities + " Cheque Book";
			}
			if(c6.isSelected()) {
				facilities = facilities + " E-Statement";
			}
		
			try {
				if(c7.isSelected() !=true) {
					JOptionPane.showMessageDialog(null, "Please select declaration checkbox");
				}
				else {
					Conn c = new Conn();
					String query1 = "insert into signupthree values('"+formno +"', '"+accountType+"','"+facilities+"'"
							+ ",'"+cardNumber+"','"+pin+"')";
					String query2 = "insert into login values('"+formno +"', '"+cardNumber+"','"+pin+"')";
		
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);
					JOptionPane.showMessageDialog(null,"Card Numner:" + cardNumber +"\nPIN:" + pin);
					setVisible(false);
					new Login();
					
				}
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		new SignupThree("");
	}
}
