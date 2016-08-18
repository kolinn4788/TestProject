package bankaccountwithGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

import bankaccountwithGUI.setgetform;
public class update extends JFrame implements ActionListener{
		JLabel laccno,lbalance,l;
		JTextField taccno,tbalance;
		JComboBox cchoice;
		JButton bsubmit,bcancle;
		JPanel p,p1,pbutton;
		String[] choice={"Deposit","Withdraw"};
		public update(){
			laccno=new JLabel("Account No");
			taccno=new JTextField(20);
			lbalance=new JLabel("Enter your balance");
			tbalance=new JTextField(20);
			l=new JLabel("Choose your choice:");
			cchoice=new JComboBox(choice);
			p1=new JPanel(new GridLayout(3,2,1,1));
			p1.add(laccno);	p1.add(taccno);
			p1.add(lbalance);	p1.add(tbalance);
			p1.add(l);	p1.add(cchoice);
			
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

			setSize(600,200);
			setTitle("Update Account!");
			setLocation(100,100);
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
		}
		
		
	public void actionPerformed(ActionEvent evt) {
		String s=((String)cchoice.getSelectedItem());
		if(evt.getSource()==bsubmit){
				if(s.equals("Deposit")){
					int n=1;
					String accno=taccno.getText();
					double balance=Double.parseDouble(tbalance.getText());
					databaseconnection c=new databaseconnection("BankInfo");
					try {
						c.update(accno, balance, n);
					} catch (SQLException e) {
		
						e.printStackTrace();
					}
				}
				else if(s.equals("Withdraw")){
					int n=2;
					String accno=taccno.getText();
					Double balance=Double.parseDouble(tbalance.getText());
					databaseconnection c=new databaseconnection("BankInfo");
					try {
							c.update(accno,balance,n);
					} catch (SQLException e) {
		
						e.printStackTrace();
					}
				}
		
		}
		if(evt.getSource()==bcancle){
			int b=JOptionPane.showConfirmDialog(null, "Do you exit?","exit or not", JOptionPane.YES_NO_OPTION);
			if(b==0){
				setVisible(false);
			}
		}
	}
	
	
}
