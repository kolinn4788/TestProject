package studentprofile2;



import java.awt.*;
import java.awt.event.*;


import javax.swing.*;


public class inputform extends JFrame implements ActionListener{
	String st;
	JScrollPane sp;
	JPanel buttonPanel;
	ButtonGroup group;
	JPanel p1,p2,p;
	JTextArea area;
	JButton bsinformation,bclear,bcancel;
	JLabel Lreno,Lname,Lrno,Lsex,LFatherName,Lmajor,Lclass,Lsbsubject;
	JTextField treno,tname,trro,tfathername;
	JRadioButton rbmale,rbfemale;
	JComboBox combomajor,comboclass,combosbsubject;
	String[] major={"Computer Science","Computer Technology"};
	String[] Class={"First Year","Second Year","Third Year"};
	String[] subjcet={"Software Engineering","Knowledge Engineering","Business Information System","High Performance Computing","Computer Communication and Network","Embedded System","Computer System"};
	
	
	public inputform(){
		Lreno=new JLabel("Entrance No.");
		Lrno=new JLabel("Roll No.");
		Lname=new JLabel("Studnet Name");
		Lsex=new JLabel("Sex");
		LFatherName=new JLabel("Father Name");
		Lclass=new JLabel("Class/Year");
		Lmajor=new JLabel("Major");
		Lsbsubject=new JLabel("Specialized Subject");
		
		treno=new JTextField(20);
		trro=new JTextField(20);
		tname=new JTextField(20);
		tfathername=new JTextField(20);
		
		comboclass=new JComboBox(Class);
		combomajor=new JComboBox(major);
		combosbsubject=new JComboBox(subjcet);
		//////////////////////
		rbmale=new JRadioButton("Male",true);
		rbfemale=new JRadioButton("Female");
		rbmale.addActionListener(this);
		rbfemale.addActionListener(this);
		
		group=new ButtonGroup();
		group.add(rbmale);		
		group.add(rbfemale);
		
		buttonPanel=new JPanel();
		buttonPanel.add(rbmale);	
		buttonPanel.add(rbfemale);
		//////////////////////for button
		p1=new JPanel();
		p1.setLayout(new GridLayout(9,2));
		
		p1.add(Lreno);  p1.add(treno);
		p1.add(Lrno);	p1.add(trro);
		p1.add(Lname);	p1.add(tname);
		p1.add(Lsex);	p1.add(buttonPanel);
		p1.add(LFatherName);	p1.add(tfathername);
		p1.add(Lclass);	p1.add(comboclass);
		p1.add(Lmajor);	p1.add(combomajor);
		p1.add(Lsbsubject); p1.add(combosbsubject);
		
		////////////////////////////////
		
		
		
		bsinformation=new JButton("Show Information");
		bclear=new JButton("Clear");
		bcancel=new JButton("Cancel");
		p2=new JPanel();		
		p2.add(bsinformation);	
		p2.add(bclear);
		p2.add(bcancel);
		bsinformation.addActionListener(this);
		bclear.addActionListener(this);
		bcancel.addActionListener(this);
		/////////////////////
		
		p=new JPanel();
		p.add(p1);
		p.add(p2);
		
		setContentPane(p);
		
		setSize(650,500);
		setTitle("GridLayout Test!");
		setLocation(100,100);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent evt){
		
				studentpofile s=new studentpofile();
		if(evt.getSource()==rbmale)
			st=rbmale.getLabel();
		if(evt.getSource()==rbfemale)
			st=rbfemale.getLabel();
		
		
		if(evt.getSource()==bsinformation){
			s.setenumber(Integer.parseInt(treno.getText()));
			s.setrollno(trro.getText());
			s.setname(tname.getText());
			s.setsex(st);
			s.setfname(tfathername.getText());
			s.setmajor((String)combomajor.getSelectedItem());
			s.setClass((String)comboclass.getSelectedItem());
			s.setsubject((String)combosbsubject.getSelectedItem());
			String s1="Entrance Number="+s.getenumber()+"\n"+"Roll Number="+s.getrollno()+"\n"+"Student Name="+s.getname()+"\n"+
						"Sex="+s.getsex()+"\n"+"Father Name="+s.getfname()+"\n"+"Class Name="+s.getclass()+"\n"+"Major="+s.getmajor()+
						"\n"+"Specialized subject="+s.getsubject();
			JOptionPane.showMessageDialog(null,s1);
		}
		else if(evt.getSource()==bclear){
			treno.setText(null);
			trro.setText(null);
			tname.setText(null);
			st=null;
			tfathername.setText(null);
			combomajor.setSelectedItem(null);
			comboclass.setSelectedItem(null);
			combosbsubject.setSelectedItem(null);
		}
		else if(evt.getSource()==bcancel){
			int result=JOptionPane.showConfirmDialog((Component)null,"Are you sure to Exit?","Confirmation",JOptionPane.YES_NO_OPTION);
			if(result==JOptionPane.YES_OPTION){
				System.exit(0);

			}
			
		}
		
	}	

}
