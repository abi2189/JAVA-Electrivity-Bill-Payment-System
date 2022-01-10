import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

public class Payment {
    private long transactionID;
    private String payStatus;
    private LocalDateTime payDate;
    DateTimeFormatter dmy = DateTimeFormatter.ofPattern("yyyy/MM/dd"); 
    DateTimeFormatter hms = DateTimeFormatter.ofPattern("HH:mm:ss"); 

    // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    // LocalDateTime now = LocalDateTime.now();  
    // System.out.println(dtf.format(now));  

    public Payment(){};

    //pass objTools.createTransactionID,"Successful";
    public Payment(long transactionID,String payStatus){
        this.transactionID = transactionID;
        this.payStatus = payStatus;
        this.payDate = LocalDateTime.now();
    }

    public String toString(){
        return "\nTransaction ID: " + this.transactionID + "\nPayment Status: " + this.payStatus + "\nTransaction Date: " + dmy.format(payDate) + "\nTransaction Time: " + hms.format(payDate);
    }
    
}
