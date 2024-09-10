package com.idfc.banking;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PinChange extends JFrame implements ActionListener {

	String pin;
	JLabel titleLabel, nPinLabel, renPinLabel;
	JPasswordField nPinPasswordField, renPinPasswordField;
	
	JButton changeButton, backButton;
	PinChange(String pin){
		this.pin = pin;
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,850, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel bgimage = new JLabel(i3);
		bgimage.setBounds(0,0,900,850);
		add(bgimage);
		
		titleLabel = new JLabel("CHANGE YOUR PIN");
		titleLabel.setBounds(260,275,400,40);
		titleLabel.setFont(new Font("System", Font.BOLD,16));
		titleLabel.setForeground(Color.WHITE);
		bgimage.add(titleLabel);
		
		nPinLabel = new JLabel("New Pin:");
		nPinLabel.setBounds(180,315,200,40);
		nPinLabel.setFont(new Font("System", Font.BOLD,14));
		nPinLabel.setForeground(Color.WHITE);
		bgimage.add(nPinLabel);

		nPinPasswordField = new JPasswordField();
		nPinPasswordField.setBounds(340,320,160,30);
		nPinPasswordField.setFont(new Font("System", Font.BOLD,14));
		bgimage.add(nPinPasswordField);
		
		renPinLabel = new JLabel("Re-enter New Pin:");
		renPinLabel.setBounds(180,355,200,40);
		renPinLabel.setFont(new Font("System", Font.BOLD,14));
		renPinLabel.setForeground(Color.WHITE);
		bgimage.add(renPinLabel);

		renPinPasswordField = new JPasswordField();
		renPinPasswordField.setBounds(340,360,160,30);
		renPinPasswordField.setFont(new Font("System", Font.BOLD,14));
		bgimage.add(renPinPasswordField);
		
		
		changeButton = new JButton("CHANGE PIN");
		changeButton.setBounds(355, 455, 150, 28);
		changeButton.setFont(new Font("System", Font.BOLD, 10));
		changeButton.addActionListener(this);
		bgimage.add(changeButton);
		
		backButton = new JButton("BACK");
		backButton.setBounds(355, 485, 150, 28);
		backButton.setFont(new Font("System", Font.BOLD, 10));
		backButton.addActionListener(this);
		bgimage.add(backButton);
		
		setTitle("Transactions");
		setSize(900,820);
		setLayout(null);
//		setUndecorated(true);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new PinChange("");
	}

	public void actionPerformed(ActionEvent ae) {
		String nPin = nPinPasswordField.getText();
		String rPin = renPinPasswordField.getText();
		if(ae.getSource() == changeButton) {
			if(!nPin.equals(rPin)) {
				JOptionPane.showMessageDialog(null,"Passwords are not matching, Please re-enter");
				return;
			}else {
				try {
					Conn c = new Conn();
					String query1 = "UPDATE login set pin = '"+nPin+"' where pin ='"+pin+"'";
					String query2 = "UPDATE signupthree set pin = '"+nPin+"' where pin ='"+pin+"'";
					String query3 = "UPDATE bank set pin = '"+nPin+"' where pin ='"+pin+"'";
					
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);
					c.s.executeUpdate(query3);
					
					JOptionPane.showMessageDialog(null, "PIN Change successful");
					setVisible(false);
					new Transactions(nPin);
				}catch(Exception e){
					System.out.println(e);
				}
				
			}
			
			
		}else {
			setVisible(false);
			new Transactions(pin);
		}
		
		
	}

	
}
