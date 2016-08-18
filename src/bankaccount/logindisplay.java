package bankaccount;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

import bankaccount.person;
public class logindisplay implements ActionListener{
		JFrame frame1=new JFrame();
		JLabel laccno,laccno1,lname,lname1,lph,lph1,lemail,lemail1,lbalance,lbalance1,laddress,laddress1;
		JButton bdeposit,bwithdraw,btrans,blogout;
		JPanel p,p1,pbutton;
		public logindisplay(){
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
			p1=new JPanel(new GridLayout(7,2,1,1));
			p1.add(laccno);	p1.add(laccno1);
			p1.add(lname);	p1.add(lname1);
			p1.add(lph);	p1.add(lph1);
			p1.add(lemail);	p1.add(lemail1);
			p1.add(lbalance);	p1.add(lbalance1);
			p1.add(laddress);	p1.add(laddress1);
			///////////////////////
			
			bdeposit=new JButton("Deposit");
			bdeposit.addActionListener(this);
			bwithdraw=new JButton("Withdraw");
			bwithdraw.addActionListener(this);
			btrans=new JButton("Transfer");
			btrans.addActionListener(this);
			blogout=new JButton("Logout");
			blogout.addActionListener(this);
			
			/////////////////////////////
			pbutton=new JPanel();
			pbutton.add(bdeposit);
			pbutton.add(bwithdraw);
			//pbutton.add(btrans);
			pbutton.add(blogout);
			/////////////////////////
			
			p=new JPanel();
			p.add(p1);
			p.add(pbutton);
			
			frame1.setContentPane(p);
			/////////////////

			frame1.setSize(800,300);
			frame1.setTitle("Login Account!");
			frame1.setLocation(100,100);
			frame1.setResizable(true);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setVisible(true);
			
		}
		
		public void actionPerformed(ActionEvent evt) {
			
			if(evt.getSource()==blogout){
				int b=JOptionPane.showConfirmDialog(null, "Do you exit?","exit or not", JOptionPane.YES_NO_OPTION);
				if(b==0){
					frame1.setVisible(false);
				}
			}
		}


	}

