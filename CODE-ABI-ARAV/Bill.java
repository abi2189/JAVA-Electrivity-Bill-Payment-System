// MAIN REQUIREMENTS
// bill {COMPOSITION tariff,COMPOSITION otherCharges}{extends payment(use get bill_amt, call/pass values into payment method)}
// (bill contains consumption_units and bill_amt)

import java.util.*;
import java.text.*;

import java.time.LocalDate;

public class Bill extends Payment{
    private otherCharges objOC;
    private energyCharges objEC;

    private float tEnergyCharges, tOtherCharges;

    private float billAmt;

    private long billNo;

    private int consUnits;
    
    private String issueDate;
    private Date dueDate;
    private Date disconDate;

    SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy"); 

    public Bill(){}

    //PASS these three values and everything gets calculated auto.
    public Bill(long billNo, int consUnits, String issueD) throws Exception{
        this.billNo = billNo;
        this.consUnits = consUnits;

        objEC = new energyCharges();
        objEC.setConsUnits(this.consUnits);
        this.tEnergyCharges = objEC.calculateEnergyCharges();
        // System.out.println(objEC);//prints everything abt energy charges

        objOC = new otherCharges();
        this.tOtherCharges = objOC.calculateTotalOtherCharges(this.consUnits, this.tEnergyCharges);
        // System.out.println(objOC);

        this.billAmt = this.tEnergyCharges + this.tOtherCharges;
        // System.out.println("\nBill Amount: " + this.billAmt);

        this.issueDate = issueD;
        // this.setIssueDate(issueD);
        // this.viewBillDates();
    }

    //all that you got to do is ==> PASS A STRING TO set function, and viewBillDates to view everything changing automatically.
    public void setIssueDate(String issueDate) throws Exception{
        this.issueDate = issueDate;
    }
    public Date getIssueDate() throws Exception{
        return formatter.parse(this.issueDate);
    }//System.out.println(formatter1.format(pay.getDate());//cuz return type is date


    public void viewBillDates() throws Exception{
        System.out.println("\nIssue Date: "+ formatter.format(this.getIssueDate()));

        this.dueDate = getIssueDate();//date type
        this.dueDate.setDate((this.dueDate.getDate() + 10));
        System.out.println("Due Date: "+ formatter.format(this.dueDate));

        System.out.println("Bill Amount after Due date: " + ((0.1*billAmt)+billAmt));

        this.disconDate = getIssueDate();
        this.disconDate.setDate((this.disconDate.getDate() + 20));
        System.out.println("Discontinued Date: "+ formatter.format(this.disconDate));
    }

    public void generateBill() throws Exception{
        System.out.println(objEC);//prints everything abt energy charges
        System.out.println(objOC);
        System.out.println("\nBill Amount: " + this.billAmt);
        
        this.setIssueDate(this.issueDate);
        this.viewBillDates();


 
    }
}
