public class Address {

    private String houseNo;
    private String streetName;
    private String city;
    private String district;
    private int pinCode;


    //concstructor
    public Address(){
    }

    public Address(String houseNo, String streetName, String city, String district ,int pinCode){
        this.houseNo= houseNo;
        this.streetName= streetName;
        this.city= city;
        this.district= district;
        this.pinCode= pinCode;
    }

    public String toString() {
        return "House No: " + this.houseNo + "\nStreet Name: " + this.streetName + "\nCity: " + this.city + "\nDistrict: " + this.district + "\nPincode: " + this.pinCode;
    }
}


