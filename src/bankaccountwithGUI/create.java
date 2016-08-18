package bankaccountwithGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

import bankaccountwithGUI.setgetform;
public class create extends JFrame implements ActionListener{
		JLabel laccno,lname;
		JTextField taccno,tname;
		JButton bsubmit,bcancle;
		JPanel p,p1,pbutton;
		public create(){
			laccno=new JLabel("Account No:");
			taccno=new JTextField(30);
			lname=new JLabel("Name");
			tname=new JTextField(30);
			p1=new JPanel(new GridLayout(2,4,1,1));
			p1.add(laccno);	p1.add(taccno);
			p1.add(lname);	p1.add(tname);
			////////////////////////
			bsubmit=new JButton("Submit");
			bcancle=new JButton("Cancle");
			bsubmit.addActionListener(this);
			bcancle.addActionListener(this);
			
			pbutton=new JPanel();
			pbutton.add(bsubmit);
			pbutton.add(bcancle);
			/////////////////////////
			
			p=new JPanel();
			p.add(p1);
			p.add(pbutton);
			
			setContentPane(p);
			/////////////////

			setSize(800,200);
			setTitle("Create Account!");
			setLocation(100,100);
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
		}
		
		public void actionPerformed(ActionEvent evt) {
			
			if(evt.getSource()==bsubmit){
				String no=taccno.getText();
				String na=tname.getText();
				//System.out.println(no+na);
				databaseconnection c=new databaseconnection();
				try {
					c.create(no, na);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	 			JOptionPane.showMessageDialog(null, "Your account Create Successfully");
			}
			if(evt.getSource()==bcancle){
				int b=JOptionPane.showConfirmDialog(null, "Do you exit?","exit or not", JOptionPane.YES_NO_OPTION);
				if(b==0){
					setVisible(false);
				}
			}
		}


	}
