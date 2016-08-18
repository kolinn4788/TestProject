package bankaccountwithGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;

public class displayordinary extends JFrame implements ActionListener{
	JLabel l;
	JPanel p,p1,pbutton;
	JTextArea area;
	JButton bcancle;
	
	displayordinary(String s){
		l=new JLabel("All Acoount in Bank:");
		area=new JTextArea(10,40);
		JScrollPane sp=new JScrollPane(area);
		p1=new JPanel();
		p1.add(sp , BorderLayout.CENTER);
		area.append("Account No           "+"Name              "+"Balance\n");
		area.append(s);
		bcancle=new JButton("Cancle");
		bcancle.addActionListener(this);
		pbutton=new JPanel();
		pbutton.add(bcancle,BorderLayout.CENTER);
		p=new JPanel();
		p.add(l);
		p.add(p1);
		p.add(pbutton);
		
		setContentPane(p);
		/////////////////

		setSize(500,300);
		setTitle("Display with Ordinary!");
		setLocation(100,100);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent evt) {
	if(evt.getSource()==bcancle){
		int b=JOptionPane.showConfirmDialog(null, "Do you exit?","exit or not", JOptionPane.YES_NO_OPTION);
		if(b==0){
			setVisible(false);
		}
	}
}

}
