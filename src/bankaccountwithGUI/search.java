package bankaccountwithGUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class search extends JFrame implements ActionListener{
	JLabel laccno;
	JTextField taccno;
	JButton bsubmit,bcancle;
	JPanel p,p1,pbutton;
	public search(){
		laccno=new JLabel("Account No:");
		taccno=new JTextField(30);
		
		p1=new JPanel(new GridLayout(1,2,1,1));
		p1.add(laccno);	p1.add(taccno);
		
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
		setTitle("Search Account!");
		setLocation(100,100);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource()==bsubmit){
			
					String no=taccno.getText();
			
					//System.out.println(no+na);
					databaseconnection c=new databaseconnection();
						try {
							c.search(no);
						} catch (SQLException e) {
				// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//JOptionPane.showMessageDialog(null, "Your account Search Successfully");
				
		}
		if(evt.getSource()==bcancle){
			int b=JOptionPane.showConfirmDialog(null, "Do you exit?","exit or not", JOptionPane.YES_NO_OPTION);
			if(b==0){
				setVisible(false);
			}
		}
	}
	
}
