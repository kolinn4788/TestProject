package bankaccount;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

import bankaccount.person;
public class createdisplay extends JFrame implements ActionListener{
		JLabel laccno,laccno1,lname,lname1,lph,lph1,lemail,lemail1,lbalance,lbalance1,laddress,laddress1;
		JButton bcancle;
		JPanel p,p1,pbutton;
		public createdisplay(){
			person pp=new person();
			System.out.println(pp.getname());
			laccno=new JLabel("Account No:");
			laccno1=new JLabel(pp.getaccno());
			lname=new JLabel("Name");
			lname1=new JLabel(pp.getname());
			lph=new JLabel("Phone");
			lph1=new JLabel(pp.getph());
			lemail=new JLabel("Email");
			lemail1=new JLabel(pp.getemail());
			lbalance=new JLabel("Balance");
			lbalance1=new JLabel(pp.getbalance());
			laddress=new JLabel("Address");
			laddress1=new JLabel(pp.getaddress());
			/////////////////
			p1=new JPanel(new GridLayout(6,2,1,1));
			p1.add(laccno);	p1.add(laccno1);
			p1.add(lname);	p1.add(lname1);
			p1.add(lph);	p1.add(lph1);
			p1.add(lemail);	p1.add(lemail1);
			p1.add(lbalance);	p1.add(lbalance1);
			p1.add(laddress);	p1.add(laddress1);
			///////////////////////
			bcancle=new JButton("Cancel");
			bcancle.addActionListener(this);
			
			pbutton=new JPanel();
			pbutton.add(bcancle);
			
			/////////////////////////
			
			p=new JPanel();
			p.add(p1);
			p.add(pbutton);
			
			setContentPane(p);
			/////////////////

			setSize(800,300);
			setTitle("Create Account!");
			setLocation(100,100);
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
		}
		
		public void actionPerformed(ActionEvent evt) {
			
			if(evt.getSource()==bcancle){
				int b=JOptionPane.showConfirmDialog(null, "Do you exit?","exit or not", JOptionPane.YES_NO_OPTION);
				if(b==0){
					setVisible(false);
				}
			}
		}


	}

