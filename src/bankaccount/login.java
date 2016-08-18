package bankaccount;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import bankaccount.person;

import javax.swing.*;

public class login implements ActionListener{
	JFrame frame1=new JFrame();
		//static person person1=new person("111111","abcde","abcde","abcde","abcde","abcde");
		JLabel laccno,lpassword;
		JTextField taccno,tpassword;
		JButton bsubmit,bcancle;
		JPanel p,p1,pbutton;
		public login(){
			laccno=new JLabel("Account No:");
			taccno=new JTextField(15);
			lpassword=new JLabel("Password");
			tpassword=new JTextField(15);
			p1=new JPanel(new GridLayout(2,4,1,1));
			p1.add(laccno);	p1.add(taccno);
			p1.add(lpassword);	p1.add(tpassword);
			////////////////////////
			bsubmit=new JButton("Submit");
			bcancle=new JButton("Cancel");
			bsubmit.addActionListener(this);
			bcancle.addActionListener(this);
			
			pbutton=new JPanel();
			pbutton.add(bsubmit);
			pbutton.add(bcancle);
			/////////////////////////
			
			p=new JPanel();
			p.add(p1);
			p.add(pbutton);
			
			frame1.setContentPane(p);
			/////////////////

			frame1.setSize(500,200);
			frame1.setTitle("Login Account!");
			frame1.setLocation(100,100);
			frame1.setResizable(true);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame1.setVisible(true);
			
		}
		
		public void actionPerformed(ActionEvent evt) {
			
			if(evt.getSource()==bsubmit){
				/*String no=taccno.getText();
				String pass=tpassword.getText();
				//System.out.println(no+na);
				databaseconnection c=new databaseconnection();
				try {
					c.create(no, pass);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}*/
				new logindisplay();
				frame1.setVisible(false);
	 			JOptionPane.showMessageDialog(null, "Your account Login Successfully");
			}
			if(evt.getSource()==bcancle){
				int b=JOptionPane.showConfirmDialog(null, "Do you exit?","exit or not", JOptionPane.YES_NO_OPTION);
				if(b==0){
					frame1.setVisible(false);
				}
			}
		}


	}
