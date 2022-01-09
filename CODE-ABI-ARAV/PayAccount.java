import java.util.*;
import java.text.*;

public class PayAccount {
    private  long accountNo;
    private String cardholderName;
    private int postalCode;
    private String expiryDate;
    private Date date1;

    SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");  


    //constructor
    public PayAccount(){
    }
    public PayAccount(long accountNo, String cardholderName, int postalCode, String expiryDate){
        this.accountNo=accountNo;
        this.cardholderName=cardholderName;
        this.postalCode=postalCode;
        this.expiryDate=expiryDate;
    }


    //getter-setter
    public void setAccountNo(long accountNo){
        this.accountNo=accountNo;
    }
    public void setCardholderName(String cardholderName){
        this.cardholderName=cardholderName;
    }
    public void setPostalCode(int postalCode){
        this.postalCode=postalCode;
    }
    public long getAccountNo(){
        return this.accountNo;
    }
    public String getCardholderName(){
        return this.cardholderName;
    }
    public int getPostalCode(){
        return this.postalCode;
    }

    public void setDate(String expiryDate) throws Exception{
        this.expiryDate = expiryDate;
        // Date date1=formatter1.parse(expiryDate); 
    }
    public Date getDate() throws Exception{
        return formatter1.parse(expiryDate);
    }


    
    //tostring
    // public String toString(){
    //     return String.format("Account Number: %o\nCard-Holder Name: %s\nPostal Code: %o\nEpiry Date: %s", accountNo,cardholderName,postalCode,ft.format(expiryDate));
    // }
}
