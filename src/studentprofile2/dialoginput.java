package studentprofile2;

import java.awt.event.*;

import javax.swing.*;

public class dialoginput extends JFrame implements ActionListener
{
	
	JLabel jlabel=new JLabel("Enter the text");
	JTextField jtextfield=new JTextField(15);
	JButton jbutton1=new JButton("OK"),
	jbutton2=new JButton("Exit"),
	jbutton3=new JButton("Cancel");
	JPanel p=new JPanel();
	public dialoginput(){
		p.add(jlabel);	p.add(jtextfield);
		p.add(jbutton1);		p.add(jbutton2);		p.add(jbutton2);
		jbutton1.addActionListener(this);
		jbutton2.addActionListener(this);
		jbutton3.addActionListener(this);
		setContentPane(p);
		setSize(300,300);
		setTitle("GridLayout Test!");
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jbutton1){
			JOptionPane.showMessageDialog(null,"You selected OK");
		}
		if(e.getSource()==jbutton2){
			System.exit(0);
		}
	
		
	}
}


