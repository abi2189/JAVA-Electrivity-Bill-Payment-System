import java.util.Random;

public class Tools {
    long[] indexStoredFeedbackNo = new long[100];
    long[] indexStoredUserID = new long[100];
    long[] indexStoredServiceNo = new long[100];
    long[] indexStoredBillNo = new long[100];
    long[] indexStoredTransactionNo = new long[100];

    Random randNum = new Random();

    // TO INTIALIZE
    private int u = 0;//user
    private int s = 0;//service no
    private int b = 0;//bill no
    private int f = 0;//feedback no
    private int t = 0;//transaction no

    //SET INITIALIZE JUST IN CASE
    public void setUserIDInitialIndex(int u){
        this.u = u;
    }
    public int getUserIDLastIndex(){
        return this.u;
    }

    // CREATE NUMBERS
    public long createFeedbackNo(){
        this.indexStoredFeedbackNo[this.f] = randNum.nextLong(8999L)+1000L;//4-digits
        // System.out.println("createFeedbackNo1 : "+ (this.f) + " : " + this.indexStoredFeedbackNo[this.f]);
        this.linearSearchRand(this.indexStoredFeedbackNo[this.f],this.indexStoredFeedbackNo,this.f);
        // System.out.println("createFeedbackNo2 : "+ (this.f - 1));
        return this.indexStoredFeedbackNo[this.f - 1];//cuz f++
    }

    public long createUserID(){
        this.indexStoredUserID[this.u] = randNum.nextLong(899999L)+100000L;//6-digits
        this.linearSearchRand(this.indexStoredUserID[this.u],this.indexStoredUserID,this.u);
        // System.out.println("createUserID : "+(this.u - 1));
        return this.indexStoredUserID[this.u - 1];//cuz u++
    }
    
    public long createServiceNo(){
        this.indexStoredServiceNo[this.s] = randNum.nextLong(89999999L)+10000000L;//8-digits
        this.linearSearchRand(this.indexStoredServiceNo[this.s],this.indexStoredServiceNo,this.s);
        // System.out.println("createServiceNo : "+(this.s - 1));
        return this.indexStoredServiceNo[this.s-1];//cuz b++
    }

    public long createBillNo(){
        this.indexStoredBillNo[this.b] = randNum.nextLong(8999999999L)+1000000000L;//10-digits
        this.linearSearchRand(this.indexStoredBillNo[this.b],this.indexStoredBillNo,this.b);
        // System.out.println("createBillNo : "+(this.b - 1));
        return this.indexStoredBillNo[this.b - 1];//cuz b++
    }

    public long createTransactionNo(){
        this.indexStoredTransactionNo[this.t] = randNum.nextLong(899999999999L)+100000000000L;//12-digits
        this.linearSearchRand(this.indexStoredTransactionNo[this.t],this.indexStoredTransactionNo,this.t);
        // System.out.println("createTransactionNo : "+(this.t - 1));
        return this.indexStoredTransactionNo[this.t - 1];//cuz t++
    }

    //LINEAR SEARCH - CHECKING IF ANY DUPS EXIST
    public void linearSearchRand(long no, long[] arrStored, int size){
        for (int i = 0; i < size; i++) {//only less than
            if(no == arrStored[i]){
                if(no <= 9999L && no >= 1000L){
                    this.createFeedbackNo();//keeps recurring untill a new no. is made
                } else if(no <= 999999L && no >= 100000L){
                    this.createUserID();
                } else if(no <= 99999999L && no >= 10000000L){
                    this.createServiceNo();
                } else if(no <= 9999999999L && no >= 1000000000L){
                    this.createBillNo();
                } else if(no <= 999999999999L && no >= 100000000000L){
                    this.createTransactionNo();
                }
            }
        }//leaves loop only once non of the values are dups

        if(no <= 9999L && no >= 1000L){
            this.f = this.f +1;
        } else if(no <= 999999L && no >= 100000L){
            this.u = this.u +1;
        } else if(no <= 99999999L && no >= 10000000L){
            this.s = this.s +1;
        } else if(no <= 9999999999L && no >= 1000000000L){
            this.b = this.b +1;//for the next tym createBillNo() is called
        } else if(no <= 999999999999L && no >= 100000000000L){
            this.t = this.t +1;
        }
    }

    // LINEAR SEARCH --> id/no back to index
    public int linearSearchIndex(long no){
        int size=0;
        if(no <= 9999L && no >= 1000L){
            size = this.f;//this.f is n not n-1 since last create has incremented it
        } else if(no <= 999999L && no >= 100000L){
            size = this.u;
        } else if(no <= 99999999L && no >= 10000000L){
            size = this.s;
        } else if(no <= 9999999999L && no >= 1000000000L){
            size = this.b;
        } else if(no <= 999999999999L && no >= 100000000000L){
            size = this.t;
        }

        long[] arrStored = new long[size];
        if(no <= 9999L && no >= 1000L){
            for (int i = 0; i < size; i++) {
                arrStored[i] = this.indexStoredFeedbackNo[i];
            }
        } else if(no <= 999999L && no >= 100000L){
            for (int i = 0; i < size; i++) {
                arrStored[i] = this.indexStoredUserID[i];
            }
        } else if(no <= 99999999L && no >= 10000000L){
            for (int i = 0; i < size; i++) {
                arrStored[i] = this.indexStoredServiceNo[i];
            }
        } else if(no <= 9999999999L && no >= 1000000000L){
            for (int i = 0; i < size; i++) {
                arrStored[i] = this.indexStoredBillNo[i];
            }
        } else if(no <= 999999999999L && no >= 100000000000L){
            for (int i = 0; i < size; i++) {
                arrStored[i] = this.indexStoredTransactionNo[i];
            }
        }


        for (int i = 0; i < size; i++) {//only less than
            if(no == arrStored[i]){
                if(no <= 9999L && no >= 1000L){
                   return i;
                } else if(no <= 999999L && no >= 100000L){
                    return i;
                } else if(no <= 99999999L && no >= 10000000L){
                    return i;
                } else if(no <= 9999999999L && no >= 1000000000L){
                    return i;
                } else if(no <= 999999999999L && no >= 100000000000L){
                    return i;
                }
            }
        }//never leaves loop, always returns function
        return 999;
    }

    // PREDEFINED CUSTOMER DETAILS
    public void preCustomer(Customer[] objCustomer) throws Exception{
        int newCustomerIndex;
        int newServiceNoIndex;
        serviceNo objServiceNo;
        Address objAddress;
        Bill objBill;
        
        // =======================indexStoredUserID[0]
        indexStoredUserID[0] = 202208L;
        objCustomer[0] = new Customer(indexStoredUserID[0], "Abirami", "cust123", 22, "abi@gmail.com", 7834672366L);

        objCustomer[0].serviceNoIndices[0]=this.linearSearchIndex(this.createServiceNo());//auto updating the last index pointing variable
        newServiceNoIndex = objCustomer[0].serviceNoIndices[0];
        objAddress = new Address(402,"NCC Urban Senate, Thannikal Keerthy Nagar Rd","Elammakara","Kochi",560024L);
        objServiceNo = new serviceNo(indexStoredServiceNo[newServiceNoIndex], objAddress);
        
        objBill = new Bill(this.createBillNo(), 220, "23/11/2021");
        objServiceNo.generateUnpaidBills(objBill);
        objBill = new Bill(this.createBillNo(), 150, "23/12/2021");
        objServiceNo.generateUnpaidBills(objBill);
        
        objBill = new Bill(this.createBillNo(), 240, "23/7/2021");
        objServiceNo.generatePaidBills(objBill);
        objBill = new Bill(this.createBillNo(), 150, "23/8/2021");
        objServiceNo.generatePaidBills(objBill);
        objBill = new Bill(this.createBillNo(), 310, "23/9/2021");
        objServiceNo.generatePaidBills(objBill);
        objBill = new Bill(this.createBillNo(), 280, "23/10/2021");
        objServiceNo.generatePaidBills(objBill);
        
        objCustomer[0].passServiceNo(objServiceNo, newServiceNoIndex);
        // objServiceNo.getUnpaidBills();
        // objServiceNo.getPaidBills();


        objCustomer[0].serviceNoIndices[1]=this.linearSearchIndex(this.createServiceNo());
        newServiceNoIndex = objCustomer[0].serviceNoIndices[1];
        objAddress = new Address(190,"Dharani Nagar","Vennamalai","Karur",639009L);
        objServiceNo = new serviceNo(indexStoredServiceNo[newServiceNoIndex], objAddress);
        objCustomer[0].passServiceNo(objServiceNo, newServiceNoIndex);

        objCustomer[0].SNI=2;




        // =======================indexStoredUserID[1]
        indexStoredUserID[1] = 230308L;
        objCustomer[1] = new Customer(indexStoredUserID[1], "Aravind", "cust123", 26, "arav@gmail.com", 9449047389L);

       

        indexStoredUserID[2] = 247082L;
        objCustomer[2] = new Customer(indexStoredUserID[2], "Maddy", "cust123", 33, "maddy@gmail.com", 6734892578L);

        this.setUserIDInitialIndex(3);
    }


    
    public void preAdmin(Admin[] objAdmin){
        
        objAdmin[0] = new Admin(12345678L, "lucas", "admin123", 25, "lucas123@eboi.co.in", 7834672366L);
        objAdmin[1] = new Admin(22345678L, "Harry", "admin223", 26, "Harry223@eboi.co.in", 9449047389L);
        objAdmin[2] = new Admin(32345678L, "Cole", "admin323", 29, "Cole323@eboi.co.in", 6734892578L);
    }
}