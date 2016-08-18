package bankaccountwithGUI;

public class setgetform {
	String accno,name;
	double balance;
	setgetform(){
		
	}
	public setgetform(String accno,String name){
		this.accno=accno;
		this.name=name;
		balance=0;
		
	}
	public void setaccno(String accno){
		this.accno=accno;
	}
	public void setname(String name){
		this.name=name;
	}
	public void setbalance(Double balance){
		this.balance=balance;
	}
	public String getaccno(){
		return accno;
	}
	public String getname(){
		return name;
	}
	public Double getbalance(){
		return balance;
	}
}
