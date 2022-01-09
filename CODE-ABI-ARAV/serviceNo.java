public class serviceNo {
    private long serviceNo;
    private Address objAddress = new Address();//composition but not thru method

    public serviceNo(){};
    public serviceNo(long serviceNo, Address objAddress ){
        this.serviceNo = serviceNo;
        this.objAddress = objAddress;
    }

    public String toString(){
        return this.objAddress.toString();
    }


}
