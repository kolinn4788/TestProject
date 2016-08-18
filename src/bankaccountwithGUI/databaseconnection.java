package bankaccountwithGUI;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import bankaccountwithGUI.setgetform;

public class databaseconnection {
	String dbname;
	Connection conn=null;
	databaseconnection(){
		
	}
	databaseconnection(String dbname){
		this.dbname=dbname;
	}
	
	public Statement getconnection() throws SQLException{
		
				
	try{
		Class.forName("com.mysql.jdbc.Driver");
		
	}
	catch(Exception E){
		System.err.println("Unable to load driver");
		E.printStackTrace();
	}
	
	try{
	
		String db="jdbc:mysql://localhost:3306/"+dbname;
		String username="root";
		String password="";
		conn=DriverManager.getConnection(db,username,password);
		System.out.println("***Connected to the database***");
		
	}
	catch(SQLException e){
		System.out.println("SQLException error"+e.getMessage());
	}
	
	Statement stmt = conn.createStatement();
	
	return stmt;
	
	}
	
	public void create(String no,String na) throws SQLException{
		setgetform s=new setgetform(no,na);
		databaseconnection c=new databaseconnection("BankInfo");
		Statement stmt=(Statement) c.getconnection();
		String query;
	query="INSERT INTO bankaccount VALUES ('"+s.getaccno()+"','"+s.getname()+"','"+s.getbalance()+"')";
				((java.sql.Statement) stmt).executeUpdate(query);
					c.disconnect();
	}
	public void delete1(String accno) throws SQLException{
		String query;
		databaseconnection c=new databaseconnection("BankInfo");
		Statement stmt=(Statement) c.getconnection();
		setgetform s1=new setgetform();
		s1.setaccno(accno);
		query="select accno,name,balance "+" "+"from bankaccount";
		query="delete from bankaccount where accno='"+s1.getaccno()+"'";
		stmt.executeUpdate(query);
		c.disconnect();
	}
	public void deleteall() throws SQLException{
		String query;
		databaseconnection c=new databaseconnection("BankInfo");
		Statement stmt=(Statement) c.getconnection();
		query="DELETE FROM bankaccount";
		stmt.executeUpdate(query);
		c.disconnect();
	}
	public void search(String accno) throws SQLException{
		setgetform s2=new setgetform();
		s2.setaccno(accno);
		String query;
		
		query="select accno,name,balance "+" "+"from bankaccount where accno="+"'"+s2.getaccno()+"'";
		//System.out.println(query);
		databaseconnection c=new databaseconnection("BankInfo");
		Statement stmt=(Statement) c.getconnection();

		ResultSet result1=stmt.executeQuery(query);
		String accno1 =" ",name1=null;
		Double balance1 =null;
		while(result1.next()){
			accno1=result1.getString(1);
			name1=result1.getString(2);
			balance1=result1.getDouble(3);
			
		}
		if(accno1.equals(s2.getaccno())){
			JOptionPane.showMessageDialog(null, accno1+" "+name1+" "+balance1);
	
		}
		else{
			JOptionPane.showMessageDialog(null, "Not Found!!");
		}

	}
	public void update(String accno,Double balance,int n) throws SQLException{
		setgetform s3=new setgetform();
		s3.setaccno(accno);
			String query;
			Double d,w=null;
			Double balance3=null;
			String accno3=" ";
			
			databaseconnection c=new databaseconnection("BankInfo");
			Statement stmt=(Statement) c.getconnection();
			query="select accno,name,balance "+" "+"from bankaccount where accno="+"'"+s3.getaccno()+"'";
			//System.out.println(query);
			ResultSet result3=stmt.executeQuery(query);
				while(result3.next()){
				accno3=result3.getString(1);
				balance3=result3.getDouble(3);
				}
				if(!accno3.equals(accno)){
					JOptionPane.showMessageDialog(null,"Your account is not found!! thanks");
				}
				else{
					int n1=n;
					switch(n1){
					case 1:
					Double d1=balance;
					balance3+=d1;
					query="UPDATE bankaccount SET "+"balance"+"="+"'"+balance3+"'"+" WHERE "+"accno"+"="+"'"+s3.getaccno()+"'";
					//System.out.println(query);
					stmt.executeUpdate(query);
					query="select accno,name,balance "+" "+"from bankaccount where accno="+"'"+s3.getaccno()+"'";
					//System.out.println(query);
					ResultSet result4=stmt.executeQuery(query);
					String accno4 =" ",name4=null;
					Double balance4 =null;
					while(result4.next()){
					accno4=result4.getString(1);
					name4=result4.getString(2);
					balance4=result4.getDouble(3);
					JOptionPane.showMessageDialog(null, "Your new balance is"+accno4+" "+name4+" "+balance4);
					}
					break;
					case 2:
					Double d3=balance;
					if(balance3<d3){
					JOptionPane.showMessageDialog(null, "Insufficient amount!Can't withdraw!!");
					}
					else{
					balance3=balance3-d3;
					query="UPDATE bankaccount SET "+"balance"+"="+"'"+balance3+"'"+" WHERE "+"accno"+"="+"'"+s3.getaccno()+"'";
					//System.out.println(query);
					stmt.executeUpdate(query);
					query="select accno,name,balance "+" "+"from bankaccount where accno="+"'"+s3.getaccno()+"'";
					//System.out.println(query);
					ResultSet result5=stmt.executeQuery(query);
					String accno5 =" ",name5=null;
					Double balance5 =null;
					while(result5.next()){
					accno5=result5.getString(1);
					name5=result5.getString(2);
					balance5=result5.getDouble(3);
					JOptionPane.showMessageDialog(null, "Your new balance is"+accno5+" "+name5+" "+balance5);
					}
					}break;
					}
					}
				
			
			c.disconnect();
			}
	public void displayoridinary() throws SQLException{
		String query,s="",s1="";
		databaseconnection c=new databaseconnection("BankInfo");
		Statement stmt=(Statement) c.getconnection();
		
		query="select accno,name,balance "+" "+"from bankaccount";
		// Read A RECORD
		
		ResultSet result=stmt.executeQuery(query);
		while(result.next()){
			String accno=result.getString(1);
			String name=result.getString(2);
			Double balance=result.getDouble(3);
			s1=s1.format("%-15s%15s%20.2f%n", accno,name,balance);
			s+=s1;
			
		}
		//JOptionPane.showMessageDialog(null,s);
		displayordinary d=new displayordinary(s);
		c.disconnect();

	}
	public void displaygrosstotal() throws SQLException{
		String query;
		double d=0;
		databaseconnection c=new databaseconnection("BankInfo");
		Statement stmt=(Statement) c.getconnection();
		
		query="select accno,name,balance "+" "+"from bankaccount";
		// Read A RECORD
		
		ResultSet result=stmt.executeQuery(query);
		
		String s="",s1="";
		while(result.next()){
			String accno=result.getString(1);
			String name=result.getString(2);
			Double balance=result.getDouble(3);
			s1=s1.format("%-15s%15s%20.2f%n", accno,name,balance);
			s+=s1;
			

			Double balance1=result.getDouble(3);
			d+=balance;
		}
		//JOptionPane.showMessageDialog(null,"Account no "+" Name "+" Balance \n"+s+"\nGross Total "+d);
		new displaygrossprofit(s,d);
		c.disconnect();

	}
	
	public void disconnect() throws SQLException{
		conn.close();
	}
	
		
}

