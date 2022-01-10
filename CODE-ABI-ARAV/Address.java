public class Address {

    private int houseNo;
    private String streetName;
    private String city;
    private String district;
    private long pinCode;


    //concstructor
    public Address(){
    }

    public Address(int houseNo, String streetName, String city, String district ,long pinCode){
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


