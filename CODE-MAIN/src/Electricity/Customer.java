package Electricity;

public class Customer extends Users {

	public String custScNo;
	public Address custAdd = new Address();
	public Consumption_Units u1=new Consumption_Units();
	public String custArea;
	public PayAccount p1;
	public Customer(String custScNo, Address custAdd, Consumption_Units u1, String custArea, PayAccount p1) {
		super();
		this.custScNo = custScNo;
		this.custAdd = custAdd;
		this.u1 = u1;
		this.custArea = custArea;
		this.p1 = p1;
	}
	@Override
	public void changePassword(String Password) {
		this.setUserPass(Password);
		
	}
	@Override
	public void changeUsername(String UserName) {
		this.setUserName(UserName);
	}
	@Override
	public void updateUserdetails() {
		
		
	}
	@Override
	public String getUserdetails() {
		
		return null;
	}
	
	

}
