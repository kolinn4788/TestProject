package bankaccountwithGUI;

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
	JPanel p,buttonpanel,radiopanel;
	JLabel l1,l2;
	String s;
	ButtonGroup g;
	JButton bok,breset,bcancle;
	JRadioButton rbcreate,rbdelete,rbsearch,rbupdate,rbdisplay;
	public mainform(){
		l1=new JLabel("Welcome to KBZ Bank");
		l2=new JLabel("Select your choice:");
		////////////////////////
		rbcreate=new JRadioButton("Create",true);
		rbdelete=new JRadioButton("Delete");
		rbsearch=new JRadioButton("Search");
		rbupdate=new JRadioButton("Update");
		rbdisplay=new JRadioButton("Display");
		rbcreate.addActionListener(this);
		rbdelete.addActionListener(this);
		rbsearch.addActionListener(this);
		rbupdate.addActionListener(this);
		rbdisplay.addActionListener(this);
		
		g=new ButtonGroup();
		g.add(rbcreate);
		g.add(rbdelete);
		g.add(rbsearch);
		g.add(rbupdate);
		g.add(rbdisplay);
		
		radiopanel=new JPanel();
		
		radiopanel.add(rbcreate,BorderLayout.CENTER);
		radiopanel.add(rbdelete,BorderLayout.CENTER);
		radiopanel.add(rbsearch,BorderLayout.CENTER);
		radiopanel.add(rbupdate,BorderLayout.CENTER);
		radiopanel.add(rbdisplay,BorderLayout.CENTER);
		/////////////////////////////
		
		bok=new JButton("OK");
		breset=new JButton("Reset");
		bcancle=new JButton("Cancle");
		bok.addActionListener(this);
		breset.addActionListener(this);
		bcancle.addActionListener(this);
		/////////////////
		buttonpanel=new JPanel();
		buttonpanel.add(bok);
		buttonpanel.add(breset);
		buttonpanel.add(bcancle);
		
		p=new JPanel(new GridLayout(8,1,3,3));
		p.add(l1,BorderLayout.CENTER);
		p.add(l2);
		p.add(radiopanel);
		
		p.add(buttonpanel);
		//////////////////////////////
		setContentPane(p);
		/////////////////

		setSize(300,500);
		setTitle("Bank Project!");
		setLocation(100,100);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==rbcreate){
			s=rbcreate.getLabel();;
			//System.out.println(s);
		}
		else if(e.getSource()==rbdelete){
			s=rbdelete.getLabel();
			//System.out.println(s);
		}
		else if(e.getSource()==rbsearch){
			s=rbsearch.getLabel();
			//System.out.println(s);
		}
		else if(e.getSource()==rbupdate){
			s=rbupdate.getLabel();
			//System.out.println(s);
		}
		else if(e.getSource()==rbdisplay){
			s=rbdisplay.getLabel();
			//System.out.println(s);
			
		}
		if(e.getSource()==bok){
			//System.out.println("OK");
			if(s.equals("Create")){
				//System.out.println(e.getSource());
				new create();
			}
			else if(s.equals("Delete")){
				//System.out.println(e.getSource());
				new delete();
			}
			else if(s.equals("Search")){
				//System.out.println(e.getSource());
				new search();
			}
			else if(s.equals("Update")){
				//System.out.println(e.getSource());
				new update();
			}
			else if(s.equals("Display")){
				//System.out.println(e.getSource());
				//System.out.println("Display");
				new display();
			}
			
		}
		else if(e.getSource()==breset){
			//System.out.println("reset");
			setVisible(false);
			new mainform();
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
	
		
	
	
