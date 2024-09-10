package com.idfc.banking;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
	
	JLabel heading, page1, name,fname, dob, gender, email, mars, addr, city, pinc, state;
	JTextField nameTextField, fnameTextField, emailTextField, addrTextField, cityTextField,pinTextField,stateTextField;
	JRadioButton married,unmarried,other,male,female;
	ButtonGroup genGroup, marGroup;
	JButton next;
	JDateChooser dateChooser;
	String random;
	SignupOne(){
		
		getContentPane().setBackground(Color.WHITE);
		setTitle("Sign Up - A");
		setSize(850,800);
		setLocationRelativeTo(null);
		setLayout(null);
		
		random = ""+(int)((Math.random() * 9000) + 1000);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2); 
		
		JLabel icon = new JLabel(i3);
		icon.setBounds(20, 0, 100 , 100);
		add(icon);
		
		heading = new JLabel("APPLICATION FORM NO." + random);
		heading.setBounds(120,30, 600, 40);
		heading.setFont(new Font("Osward", Font.BOLD,34));
		add(heading);
		
		page1 = new JLabel("Page 1: Personal Details");
		page1.setBounds(350, 100, 500, 40);
		page1.setFont(new Font("Raleway",Font.BOLD , 18));
		add(page1);
		
		name = new JLabel("Name:");
		name.setBounds(130, 150, 200, 40);
		name.setFont(new Font("Raleway", Font.BOLD, 14));
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(350, 155, 450, 30);
		nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
		add(nameTextField);
		
		
		fname = new JLabel("Father's Name:");
		fname.setBounds(130, 190, 200, 40);
		fname.setFont(new Font("Raleway", Font.BOLD, 14));
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setBounds(350, 195, 450, 30);
		fnameTextField.setFont(new Font("Raleway", Font.BOLD,14));
		add(fnameTextField);
		
		dob = new JLabel("Date of Birth:");
		dob.setBounds(130, 230, 200, 40);
		dob.setFont(new Font("Raleway", Font.BOLD, 14));
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(350,235, 450, 30);
//		dateChooser.setForeground(Color.WHITE);
		add(dateChooser);
		
		gender = new JLabel("Gender:");
		gender.setBounds(130, 270, 200, 40);
		gender.setFont(new Font("Raleway", Font.BOLD, 14));
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(350, 275, 100, 30);
		male.setBackground(Color.white);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450, 275, 100, 30);
		female.setBackground(Color.white);
		add(female);
		
		genGroup = new ButtonGroup() ;
		genGroup.add(male);
		genGroup.add(female);
		
		email = new JLabel("Email Address:");
		email.setBounds(130, 310, 200, 40);
		email.setFont(new Font("Raleway", Font.BOLD, 14));
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setBounds(350, 315, 450, 30);
		emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
		add(emailTextField);
		
		mars = new JLabel("Marital Status:");
		mars.setBounds(130, 350, 200, 40);
		mars.setFont(new Font("Raleway", Font.BOLD, 14));
		add(mars);
		
		
		married = new JRadioButton("Married");
		married.setBounds(350, 355, 100, 30);
		married.setBackground(Color.white);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 355, 100, 30);
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(570, 355, 100, 30);
		other.setBackground(Color.white);
		add(other);
		
		marGroup = new ButtonGroup() ;
		marGroup.add(married);
		marGroup.add(unmarried);
		marGroup.add(other);
		
		addr = new JLabel("Address:");
		addr.setBounds(130, 390, 200, 40);
		addr.setFont(new Font("Raleway", Font.BOLD, 14));
		add(addr);
		
		addrTextField = new JTextField();
		addrTextField.setBounds(350, 395, 450, 30);
		addrTextField.setFont(new Font("Raleway", Font.BOLD,14));
		add(addrTextField);
		
		city = new JLabel("City:");
		city.setBounds(130, 430, 200, 40);
		city.setFont(new Font("Raleway", Font.BOLD, 14));
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setBounds(350, 435, 450, 30);
		cityTextField.setFont(new Font("Raleway", Font.BOLD,14));
		add(cityTextField);
		
		
		pinc = new JLabel("Pin Code:");
		pinc.setBounds(130, 470, 200, 40);
		pinc.setFont(new Font("Raleway", Font.BOLD, 14));
		add(pinc);
		
		pinTextField = new JTextField();
		pinTextField.setBounds(350, 475, 450, 30);
		pinTextField.setFont(new Font("Raleway", Font.BOLD,14));
		add(pinTextField);
		
		state = new JLabel("State:");
		state.setBounds(130, 510, 200, 40);
		state.setFont(new Font("Raleway", Font.BOLD, 14));
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setBounds(350, 515, 450, 30);
		stateTextField.setFont(new Font("Raleway", Font.BOLD,14));
		add(stateTextField);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(700,600,100,40);
		next.setFont(new Font("Raleway", Font.BOLD,14));
		next.addActionListener(this);
		add(next);
		
		
		setVisible(true);
	}
	
public void actionPerformed(ActionEvent ae) {

	String formno = "" + random;
	String name = nameTextField.getText();
	String fname = fnameTextField.getText();
	String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
	String gender = null;
	if(male.isSelected()) {
		gender = "Male";
	}
	else if(female.isSelected()) {
		gender = "Female";
	}
	String marstatus = null;
	if(married.isSelected()) {
		marstatus = "Married";
	}
	else if(unmarried.isSelected()) {
		marstatus = "Unmarried";
	}
	else if(other.isSelected()) {
		marstatus = "Other";
	}
	
	String email = emailTextField.getText();
	String address = addrTextField.getText();
	String city = cityTextField.getText();
	String pin = pinTextField.getText();
	String state = stateTextField.getText();
	
	try {
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "Name is Required");
		} else {
			Conn c = new Conn();
			String query = "insert into signup values('"+formno +"', '" + name +"', '" + fname +"', '" + dob +"', '" + gender 
					+"', '" + email +"', '" + marstatus +"', '" + address + "', '" + city +"', '" + pin +"', '" + state + "')";
			c.s.executeUpdate(query);
		}
		
	}catch(Exception e){
		System.out.println(e);
	}
	
	setVisible(false);
	new SignupTwo(formno);
	
	}
	
	
	

	public static void main(String[] args) {
		new SignupOne();
	}
}
