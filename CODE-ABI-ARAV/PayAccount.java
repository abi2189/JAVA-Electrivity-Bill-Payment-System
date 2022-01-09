import java.util.*;
import java.text.*;

public class PayAccount {
    private  long accountNo;
    private String cardholderName;
    private int postalCode;
    private Date expiryDate= new Date();

    SimpleDateFormat ft = 
      new SimpleDateFormat ("yyyy.MM.dd");
    //constructor
    public PayAccount(){
    }
    public PayAccount(long accountNo, String cardholderName, int postalCode, Date expiryDate){
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
    public void setDate(Date expiryDate){
        this.expiryDate=expiryDate;
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
    public String getDate(){
        return ft.format(expiryDate);
    }

    
    //tostring
    public String toString(){
        return String.format("Account Number: %o\nCard-Holder Name: %s\nPostal Code: %o\nEpiry Date: %s", accountNo,cardholderName,postalCode,ft.format(expiryDate));
    }
}
