package bankaccount;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

import bankaccount.person;
public class create extends JFrame implements ActionListener{
		JLabel laccno,lname,lph,lemail,lbalance,laddress;
		JTextField taccno,tname,tph,temail,tbalance,taddress;
		JButton bsubmit,bcancle,bclear;
		JPanel p,p1,pbutton;
		public create(){
			laccno=new JLabel("Account No:");
			taccno=new JTextField(15);
			lname=new JLabel("Name");
			tname=new JTextField(15);
			lph=new JLabel("Phone");
			tph=new JTextField(15);
			lemail=new JLabel("Email");
			temail=new JTextField(15);
			lbalance=new JLabel("Balance");
			tbalance=new JTextField(15);
			laddress=new JLabel("Address");
			taddress=new JTextField(15);
			//////////
			p1=new JPanel(new GridLayout(6,2,1,1));
			p1.add(laccno);	p1.add(taccno);
			p1.add(lname);	p1.add(tname);
			p1.add(lph);	p1.add(tph);
			p1.add(lemail);	p1.add(temail);
			p1.add(lbalance);	p1.add(tbalance);
			p1.add(laddress);	p1.add(taddress);
			////////////////////////
			bsubmit=new JButton("Submit");
			bcancle=new JButton("Cancle");
			bclear=new JButton("Clear");
			bsubmit.addActionListener(this);
			bcancle.addActionListener(this);
			bclear.addActionListener(this);
			
			pbutton=new JPanel();
			pbutton.add(bsubmit);
			pbutton.add(bclear);
			pbutton.add(bcancle);
			
			/////////////////////////
			
			p=new JPanel();
			p.add(p1);
			p.add(pbutton);
			
			setContentPane(p);
			/////////////////

			setSize(500,300);
			setTitle("Create Account!");
			setLocation(100,100);
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
		}
		
		public void actionPerformed(ActionEvent evt) {
			
			if(evt.getSource()==bsubmit){
				/*String s1="Acc No="+taccno.getText()+"\n"+"Name="+tname.getText()+"\n"+"Phone="+tph.getText()+"\n"+
						"Email="+temail.getText()+"\n"+"Balance="+tbalance.getText()+"\n"+"Address="+taddress.getText();
				JOptionPane.showMessageDialog(null,s1);*/
				//System.out.println(no+na);
				/*databaseconnection c=new databaseconnection();
				try {
					c.create(no, na);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}*/
				
				person pp=new person();
				pp.setaccno(taccno.getText());
				pp.setname(tname.getText());
				pp.setph(tph.getText());
				pp.setemail(temail.getText());
				pp.setbalane(tbalance.getText());
				pp.setaddress(taddress.getText());
				new logindisplay();
				setVisible(false);
	 			JOptionPane.showMessageDialog(null, "Your account Create Successfully");
			}
			else if(evt.getSource()==bclear){
				taccno.setText(null);
				tname.setText(null);
				tph.setText(null);
				temail.setText(null);
				tbalance.setText(null);
				taddress.setText(null);
			}
			else if(evt.getSource()==bcancle){
				int b=JOptionPane.showConfirmDialog(null, "Do you exit?","exit or not", JOptionPane.YES_NO_OPTION);
				if(b==0){
					setVisible(false);
				}
			}
		}


	}
