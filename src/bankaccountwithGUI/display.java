package bankaccountwithGUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

import bankaccountwithGUI.setgetform;
public class display extends JFrame implements ActionListener{
		JLabel l;
		//JComboBox cdisplay;
		JCheckBox cdisplay;
		JButton bsubmit,bcancle;
		JPanel p,p1,pbutton;
		//String[] display={"Display with ordinary","Dispay with Gross Total"};
		public display(){
			l=new JLabel("Choose your choice:");
			cdisplay=new JCheckBox("Display with gross total");
			p1=new JPanel();
			p1.add(cdisplay);
			cdisplay.addActionListener(this);
			
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
			p.add(l);
			p.add(p1);
			p.add(pbutton);
			
			setContentPane(p);
			/////////////////

			setSize(500,200);
			setTitle("Create Account!");
			setLocation(100,100);
			setResizable(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
		}
		
		
	public void actionPerformed(ActionEvent evt) {
		//String s=((String)cdisplay.getSelectedItem());
		if(evt.getSource()==bsubmit){
				//if(s.equals("Display with ordinary")){
			Component[] components = p1.getComponents();///to read 
			for (Component ch : components) {//to read 
				JCheckBox cb = (JCheckBox) ch;//to read
				if (cb.isSelected()){//to read
					//System.out.println("With " + cb.getText());
					databaseconnection c=new databaseconnection("BankInfo");
				try {
					c.displaygrosstotal();
				} catch (SQLException e) {
	
					e.printStackTrace();
				}
			}
				else{
					try {
						databaseconnection c=new databaseconnection("BankInfo");
						c.displayoridinary();
						
				} catch (SQLException e) {
	
					e.printStackTrace();
				}
				}
			}
					
				//}
				//else if(s.equals("Dispay with Gross Total")){
					//databaseconnection c=new databaseconnection("BankInfo");
					
				//}
		
		}
		if(evt.getSource()==bcancle){
			int b=JOptionPane.showConfirmDialog(null, "Do you exit?","exit or not", JOptionPane.YES_NO_OPTION);
			if(b==0){
				setVisible(false);
			}
		}
	}
	
	
}
