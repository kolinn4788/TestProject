package bankaccount;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class mainform extends JFrame implements ActionListener{
	JPanel p,buttonpanel;
	JLabel l1;
	String s;
	JButton bcreate,blogin,bcancle;
	public mainform(){
		l1=new JLabel("Welcome to Bank");
		l1.setHorizontalAlignment(JLabel.CENTER);
		////////////////////////
		
		
		
		
		
		bcreate=new JButton("Create");
		blogin=new JButton("Login");
		bcancle=new JButton("Cancel");
		bcreate.addActionListener(this);
		blogin.addActionListener(this);
		bcancle.addActionListener(this);
		/////////////////
		buttonpanel=new JPanel();
		buttonpanel.add(bcreate);
		buttonpanel.add(blogin);
		buttonpanel.add(bcancle);
		
		p=new JPanel(new GridLayout(3,1,3,3));
		p.add(l1,BorderLayout.CENTER);
		p.add(buttonpanel);
		//////////////////////////////
		setContentPane(p);
		/////////////////

		setSize(300,200);
		setTitle("Bank Project!");
		setLocation(100,100);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==bcreate){
			//System.out.println("reset");
			setVisible(false);
			new create();
		}
		else if(e.getSource()==blogin){
			//System.out.println("reset");
			setVisible(false);
			new login();
		}
		else if(e.getSource()==bcancle){
			//System.out.println(e.getSource());
		int b=JOptionPane.showConfirmDialog(null, "Do you exit?","exit or not", JOptionPane.YES_NO_CANCEL_OPTION);
			if(b==0){
			System.exit(0);
			}
		}
	}
}
	
		
	
	
