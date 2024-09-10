package com.idfc.banking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener{
	
	JLabel page2, religion, category, income, education, occupation, pan, aadhar, seniorCitizen, existingAccount;
	JComboBox religionComboBox, categoryComboBox, incomeComboBox, educationComboBox, occupationComboBox;
	JTextField panTextField, aadharTextField;
	ButtonGroup seniorCitizenGroup, existingAccountGroup;
	JButton next;
	JRadioButton seniorCitizenYes, seniorCitizenNo, existingAccountYes, existingAccountNo;
	String formno;
	SignupTwo(String formno){
		
		getContentPane().setBackground(Color.WHITE);
		setTitle("Sign Up - B");
		setSize(850,800);
		setLocationRelativeTo(null);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2); 
		
		this.formno = formno;
		JLabel icon = new JLabel(i3);
		icon.setBounds(20, 0, 100 , 100);
		add(icon);
		
		page2 = new JLabel("Page 2: Additional Details");
		page2.setBounds(350, 100, 500, 40);
		page2.setFont(new Font("Raleway",Font.BOLD , 18));
		add(page2);
		
		religion = new JLabel("Religion:");
		religion.setBounds(130, 150, 200, 40);
		religion.setFont(new Font("Raleway", Font.BOLD, 14));
		add(religion);
		
		String valReligion[] = {"Hindu", "Christian", "Muslim", "Sikh", "Others"};
		religionComboBox = new JComboBox(valReligion);
		religionComboBox.setBounds(350, 155, 450, 30);
		religionComboBox.setFont(new Font("Raleway", Font.BOLD,14));
		add(religionComboBox);
		
		
		category = new JLabel("Category:");
		category.setBounds(130, 190, 200, 40);
		category.setFont(new Font("Raleway", Font.BOLD, 14));
		add(category);
		
		
		String valCategory[] = {"General", "BC", "SC", "ST", "Others"};
		categoryComboBox = new JComboBox(valCategory);
		categoryComboBox.setBounds(350, 195, 450, 30);
		categoryComboBox.setFont(new Font("Raleway", Font.BOLD,14));
		add(categoryComboBox);
		
		income = new JLabel("Income");
		income.setBounds(130, 230, 200, 40);
		income.setFont(new Font("Raleway", Font.BOLD, 14));
		add(income);
		
		
		String valIncome[] = {"No-Income", "< 2,50,000", "2.5L - 5L", "5L - 10L", "> 10L"};
		incomeComboBox = new JComboBox(valIncome);
		incomeComboBox.setBounds(350, 235, 450, 30);
		incomeComboBox.setFont(new Font("Raleway", Font.BOLD,14));
		add(incomeComboBox);
		
		education = new JLabel("Educational Qualification");
		education.setBounds(130, 270, 200, 40);
		education.setFont(new Font("Raleway", Font.BOLD, 14));
		add(education);
		
		String valEducation[] = {"Illiterate", "Metric", "+2", "Gradute", "Post-Graduate"};
		educationComboBox = new JComboBox(valEducation);
		educationComboBox.setBounds(350, 275, 450, 30);
		educationComboBox.setFont(new Font("Raleway", Font.BOLD,14));
		add(educationComboBox);
		
		occupation = new JLabel("Occupation");
		occupation.setBounds(130, 310, 200, 40);
		occupation.setFont(new Font("Raleway", Font.BOLD, 14));
		add(occupation);
		
		String valOccupation[] = {"Unemployed", "Business - Self Employed", "Salaried - Private", "Salaried - Government", "Military Personnel"};
		occupationComboBox = new JComboBox(valOccupation);
		occupationComboBox.setBounds(350, 315, 450, 30);
		occupationComboBox.setFont(new Font("Raleway", Font.BOLD,14));
		add(occupationComboBox);
		
		pan = new JLabel("PAN Number");
		pan.setBounds(130, 350, 200, 40);
		pan.setBackground(Color.white);
		add(pan);
		
		panTextField = new JTextField();
		panTextField.setBounds(350, 355, 450, 30);
		panTextField.setFont(new Font("Raleway", Font.BOLD,14));
		add(panTextField);
		
		aadhar = new JLabel("Aadhar Number:");
		aadhar.setBounds(130, 390, 200, 40);
		aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
		add(aadhar);
		
		aadharTextField = new JTextField();
		aadharTextField.setBounds(350, 395, 450, 30);
		aadharTextField.setFont(new Font("Raleway", Font.BOLD,14));
		add(aadharTextField);
		
		seniorCitizen = new JLabel("Senior Citizen:");
		seniorCitizen.setBounds(130, 430, 200, 40);
		seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 14));
		add(seniorCitizen);
		
		
		seniorCitizenYes = new JRadioButton("Yes");
		seniorCitizenYes.setBounds(350, 435, 100, 30);
		seniorCitizenYes.setBackground(Color.white);
		add(seniorCitizenYes);
		
		seniorCitizenNo = new JRadioButton("No");
		seniorCitizenNo.setBounds(450, 435, 100, 30);
		seniorCitizenNo.setBackground(Color.white);
		add(seniorCitizenNo);
		
		seniorCitizenGroup = new ButtonGroup() ;
		seniorCitizenGroup.add(seniorCitizenYes);
		seniorCitizenGroup.add(seniorCitizenNo);
		
		existingAccount = new JLabel("Existing Account:");
		existingAccount.setBounds(130, 470, 200, 40);
		existingAccount.setFont(new Font("Raleway", Font.BOLD, 14));
		add(existingAccount);

		existingAccountYes = new JRadioButton("Yes");
		existingAccountYes.setBounds(350, 475, 100, 30);
		existingAccountYes.setBackground(Color.white);
		add(existingAccountYes);
		
		existingAccountNo = new JRadioButton("No");
		existingAccountNo.setBounds(450, 475, 100, 30);
		existingAccountNo.setBackground(Color.white);
		add(existingAccountNo);
		
		existingAccountGroup = new ButtonGroup() ;
		existingAccountGroup.add(existingAccountYes);
		existingAccountGroup.add(existingAccountNo);
		
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(700,510,100,40);
		next.setFont(new Font("Raleway", Font.BOLD,14));
		next.addActionListener(this);
		add(next);
		
		
		setVisible(true);
	}
	
public void actionPerformed(ActionEvent ae) {

	String religionValue = (String)religionComboBox.getSelectedItem();
	String categoryValue = (String)categoryComboBox.getSelectedItem();
	String incomeValue = (String)incomeComboBox.getSelectedItem();
	String educationValue = (String)educationComboBox.getSelectedItem();
	String occupationValue = (String)occupationComboBox.getSelectedItem();
	String panValue = panTextField.getText();
	String aadharValue = aadharTextField.getText();
	
	
	
	String seniorCitizenValue = null;
	if(seniorCitizenYes.isSelected()) {
		seniorCitizenValue = "Yes";
	}else if(seniorCitizenNo.isSelected()) {
		seniorCitizenValue = "No";
	}
	
	String existingAccountValue = null;
	if(existingAccountYes.isSelected()) {
		existingAccountValue = "Yes";
	}else if(existingAccountNo.isSelected()) {
		existingAccountValue = "No";
	}
	
	try {
		if(panValue.equals("")) {
			JOptionPane.showMessageDialog(null, "PAN Number is Required");
		} else {
			Conn c = new Conn();
			String query = "insert into signuptwo values('"+formno +"', '"+religionValue +"', '" + categoryValue +"', '" + incomeValue +"', '" + educationValue + "', '" + occupationValue +"', '" + panValue 
					+"', '" + aadharValue +"', '" + seniorCitizenValue +"', '" + existingAccountValue + "')";
			c.s.executeUpdate(query);
			
			setVisible(false);
			new SignupThree(formno);
		}
		
	}catch(Exception e){
		System.out.println(e);
	}
	
	}

	public static void main(String[] args) {
		new SignupTwo("");
	}
}
