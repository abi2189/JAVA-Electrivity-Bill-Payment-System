public class Customer extends User{
    
    public String custScNo;
	public Address custAdd = new Address();

	public String custArea;
	public PayAccount p1;

    public Customer(String custScNo, Address custAdd, ConsumptionUnits u1, String custArea, PayAccount p1) {
		super();
		this.custScNo = custScNo;
		this.custAdd = custAdd;
		this.u1 = u1;
		this.custArea = custArea;
		this.p1 = p1;
	}

    public void changePassword(String Password) {
		this.setUserPass(Password);
	}
	public void changeUsername(String UserName) {
		this.setUserName(UserName);
	}
	public void updateUserdetails() {
	}
	public String getUserdetails() {	
		return null;
	}

}
