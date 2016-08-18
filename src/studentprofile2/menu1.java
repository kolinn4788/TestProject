package studentprofile2;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import studentprofile2.dialoginput;;

public class menu1 extends JApplet implements ActionListener{
	JMenuItem jmenuitem1,jmenuitem2,jmenuitem3,jmenuitem4,jmenuitem5,jmenuitem6;
	public void init(){
		JMenuBar jmenubar=new JMenuBar();
		JMenu jmenu1=new JMenu("File");
		JMenuItem jmenuitem1=new JMenuItem("New....");
		JMenuItem jmenuitem2=new JMenuItem("Open.....");
		JMenuItem jmenuitem3=new JMenuItem("Exit....");
		jmenu1.add(jmenuitem1);
		jmenu1.add(jmenuitem2);
		jmenu1.addSeparator();
		jmenu1.add(jmenuitem3);
		jmenuitem1.addActionListener(this);
		jmenuitem2.addActionListener(this);
		jmenuitem3.addActionListener(this);
		JMenu jmenu2=new JMenu("Edit");
		JMenuItem jmenuitem4=new JMenuItem("Cut");
		JMenuItem jmenuitem5=new JMenuItem("Copy");
		JMenuItem jmenuitem6=new JMenuItem("Paste");
		jmenu2.add(jmenuitem4);
		jmenu2.add(jmenuitem5);
		jmenu2.add(jmenuitem6);
		jmenuitem4.addActionListener(this);
		jmenuitem5.addActionListener(this);
		jmenuitem6.addActionListener(this);
		jmenubar.add(jmenu1);
		jmenubar.add(jmenu2);
		setJMenuBar(jmenubar);
	}
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==jmenuitem1){
			//JOptionPane.showMessageDialog(null,"You selected New");
			new dialoginput ();
		
		}
		else if(e.getSource()==jmenuitem2){
			JOptionPane.showMessageDialog(null,"You selected Open");
		}
		else if(e.getSource()==jmenuitem3){
			System.exit(0);
		}
	}
}

