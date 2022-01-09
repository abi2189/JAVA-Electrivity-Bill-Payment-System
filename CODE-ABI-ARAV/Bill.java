// MAIN REQUIREMENTS
// bill {COMPOSITION tariff,COMPOSITION otherCharges}{extends payment(use get bill_amt, call/pass values into payment method)}
// (bill contains consumption_units and bill_amt)

import java.util.*;
import java.text.*;

public class Bill extends Payment{
    private otherCharges objOC;
    private energyCharges objEC;

    private float tEnergyCharges, tOtherCharges;

    private float billAmt;

    private long billNo;

    private int consUnits;
    
    private Date issueDate = new Date();
    private Date dueDate = new Date();
    private Date disconDate = new Date();

    public Bill(){}

    public Bill(int billNo,int  consUnits){//add issure date as well
        this.billNo = billNo;
        this.consUnits = consUnits;

        objEC = new energyCharges();
        objEC.setConsUnits(this.consUnits);
        this.tEnergyCharges = objEC.calculateEnergyCharges();
        System.out.println(objEC);//prints everything abt energy charges

        objOC = new otherCharges();
        this.tOtherCharges = objOC.calculateTotalOtherCharges(this.consUnits, this.tEnergyCharges);
        System.out.println(objOC);
        
        this.billAmt = this.tEnergyCharges + this.tOtherCharges;
        System.out.println("\nBill Amount: " + this.billAmt);
    }

    public float getBillAmt(){
        return billAmt;
    } 

    public void viewBillDates(){
        
    }


    
}
