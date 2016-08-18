package bankaccount;

public class person {
	String accno,name,ph,email,balance,address;
	
	person(String accno,String name,String ph,String email,String balance,String address){
		this.accno=accno;
		this.name=name;
		this.ph=ph;
		this.email=email;
		this.balance=balance;
		this.address=address;
	}
	person(){};
	
	public void setaccno(String accno){
		this.accno=accno;
		//System.out.println(accno);
	}
	public void setname(String name){
		this.name=name;
	}
	public void setph(String ph){
		this.ph=ph;
	}
	public void setemail(String email){
		this.email=email;
	}
	public void setbalane(String balance){
		this.balance=balance;
	}
	public void setaddress(String address){
		this.address=address;
	}

	
	public String getaccno(){
		return accno;
	}
	public String getname(){
		return name;
	}
	public String getph(){
		return ph;
	}
	public String getemail(){
		return email;
	}
	public String getbalance(){
		return balance;
	}
	public String getaddress(){
		return address;
	}
}
