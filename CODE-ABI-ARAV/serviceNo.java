public class serviceNo {
    private long serviceNo;
    private Address objAddress = new Address();//composition but not thru method

    public serviceNo(){};
    public serviceNo(long serviceNo, Address objAddress ){
        this.serviceNo = serviceNo;
        this.objAddress = objAddress;
    }
    public String viewServiceNoLogged(){
        return "\nService No.: " + this.serviceNo + "\nAddress:" + this.objAddress.viewAddressLogged(); 
    }

    public String toString(){
        return "\nService No.: " + this.serviceNo + "\nAssociated Address: \n" + this.objAddress.toString(); 
    }


}
