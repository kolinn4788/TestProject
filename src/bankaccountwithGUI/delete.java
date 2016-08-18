package bankaccountwithGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

import bankaccountwithGUI.setgetform;
public class delete extends JFrame implements ActionListener{
		JLabel l;
		JComboBox cdelete;
		JButton bsubmit,bcancle;
		JPanel p,p1,pbutton;
		String[] delete={"Delete one account","Delete all account"};
		public delete(){
			l=new JLabel("Choose your choice:");
			cdelete=new JComboBox(delete);
			p1=new JPanel(new GridLayout(1,2,1,1));
			p1.add(l);	p1.add(cdelete);
			
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

			setSize(500,200);
			setTitle("Delete Account!");
			setLocation(100,100);
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
		}
		
		
	public void actionPerformed(ActionEvent evt) {
		String s=((String)cdelete.getSelectedItem());
		if(evt.getSource()==bsubmit){
				if(s.equals("Delete one account")){
					new delete1();
				}
				else if(s.equals("Delete all account")){
					int b=JOptionPane.showConfirmDialog(null, "Do you really delete all account?","delete or not", JOptionPane.YES_NO_OPTION);
					if(b==0){
						databaseconnection c=new databaseconnection("BankInfo");
						try {
								c.deleteall();
						} catch (SQLException e) {
			
							e.printStackTrace();
						}
					}
					JOptionPane.showMessageDialog(null, "Successfully delete all of account");
					
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
