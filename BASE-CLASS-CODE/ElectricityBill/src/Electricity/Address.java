

public class Address {
    private String doorNo;
    private String streetName;
    private String placeName;
    private int pinCode;
	
    public String getDoorNo() {
		return doorNo;
	}
	public Address() {
		
	}
	public Address(String doorNo, String streetName, String placeName, int pinCode) {
		super();
		this.doorNo = doorNo;
		this.streetName = streetName;
		this.placeName = placeName;
		this.pinCode = pinCode;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
}
