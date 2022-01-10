public class serviceNo {
    private long serviceNo;
    private Address objAddress = new Address();//composition but not thru method
    public Bill[] objBillUnpaid = new Bill[10];
    public Bill[] objBillPaid = new Bill[10];

    public serviceNo(){};
    public serviceNo(long serviceNo, Address objAddress ){
        this.serviceNo = serviceNo;
        this.objAddress = objAddress;

    }

    private int ub=0, pb=0;
    public void generateUnpaidBills(Bill objBill){
        this.objBillUnpaid[ub] = objBill;
        ub++;
    }
    public void generatePaidBills(Bill objBill){
        this.objBillPaid[pb] = objBill;
        pb++;
    }

    public void getUnpaidBills() throws Exception{
        for (int i = 0; i < ub; i++) {
            this.objBillUnpaid[i].generateBill();            
        }
    }
    public void getPaidBills() throws Exception{
        for (int i = 0; i < pb; i++) {
            this.objBillPaid[i].generateBill();            
        }
    }

    public String toString(){
        return "\nService No.: " + this.serviceNo + "\nAssociated Address: \n" + this.objAddress.toString(); 
    }


}
