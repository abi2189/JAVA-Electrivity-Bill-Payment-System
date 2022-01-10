import java.util.*;
import java.text.*;

public class payAccount {
    private  long accountNo;
    private String cardHolderName;
    private int postalCode;
    private String expiryDate;
    // private Date date1;

    SimpleDateFormat formatter1=new SimpleDateFormat("MM/yyyy");  


    //constructor
    public payAccount(){
    }
    public payAccount(long accountNo, String cardHolderName, int postalCode, String expiryDate){
        this.accountNo=accountNo;
        this.cardHolderName=cardHolderName;
        this.postalCode=postalCode;
        this.expiryDate=expiryDate;
    }


    //getter-setter
    public void setAccountNo(long accountNo){
        this.accountNo=accountNo;
    }
    public void setCardHolderName(String cardHolderName){
        this.cardHolderName=cardHolderName;
    }
    public void setPostalCode(int postalCode){
        this.postalCode=postalCode;
    }
    public long getAccountNo(){
        return this.accountNo;
    }
    public String getCardholderName(){
        return this.cardHolderName;
    }
    public int getPostalCode(){
        return this.postalCode;
    }

    public void setExpiryDate(String expiryDate) throws Exception{
        this.expiryDate = expiryDate;
        // Date date1=formatter1.parse(expiryDate); 
    }
    public Date getExpiryDate() throws Exception{
        return formatter1.parse(expiryDate);
    }//System.out.println(formatter1.format(pay.getDate());//cuz return type is date

    //cannot use tosting since IT CANNOT THROW EXCEPTION
    public void viewCardDetails() throws Exception{
        System.out.println("CARD DETAILS:\n"+"Account Number: " + this.accountNo + "\nCard-Holder Name: " + this.cardHolderName + "\nPostal Code: " + this.postalCode +"\nEpiry Date: " + formatter1.format(this.getExpiryDate()));
    }
}
