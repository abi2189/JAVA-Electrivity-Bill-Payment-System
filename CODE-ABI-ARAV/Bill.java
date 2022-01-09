// MAIN REQUIREMENTS
// bill {COMPOSITION tariff,COMPOSITION otherCharges}{extends payment(use get bill_amt, call/pass values into payment method)}
// (bill contains consumption_units and bill_amt)

import java.util.*;
import java.text.*;

public class Bill extends Payment{
    private otherCharges OC;
    private energyCharges EC;

    private float billAmt;

    private long billNo;

    private int consUnits;
    
    private Date issueDate = new Date();
    private Date dueDate = new Date();
    private Date disconDate = new Date();

    public Bill(){

    }
    public Bill(int billNo,int  consUnits){//add issure date as well
        this.billNo = billNo;
        this.consUnits = consUnits;
        EC.
        OC.calculateTotalOtherCharges(consUnits, );
    }

    // public long createBillNo(){
        
    // }
    public void setBillAmt(float amt){
        this.billAmt = amt;
    }

    public float getBillAmt(){
        return billAmt;
    } 

    public void viewBillDates(){
        
    }


    
}
