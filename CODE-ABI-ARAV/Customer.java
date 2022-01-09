import java.util.*;
import java.text.*;

public class Customer extends User implements UserDetailsUpdate{

    private payAccount objPayAccount;
    private Feedback objFeedback;


    //CONSTRUCTORS
    public Customer(){
    }
    public Customer(long userID, String userName, String userPass, int userAge, String userEmail, long userPhn){
        super(userID, userName, userPass, userAge, userEmail, userPhn);
    }
    public void viewCustomerDetails(){
        System.out.println(objFeedback);
    }

    //FEEDBACK AND PAYMENT SET AND VIEW DETAILS 
    public void setFeedbackDetails(String feedbackDesc,Date feedbackDate){
        objFeedback= new Feedback(feedbackDesc,feedbackDate);
    }
    public void setPayAccountDetails(long accountNo, String cardholderName, int postalCode, String expiryDate){
        objPayAccount = new payAccount(accountNo, cardholderName, postalCode, expiryDate);
    }

    public void viewFeedbackDetails(){
        System.out.println(objFeedback);
    }
    public void viewPayAccountDetails(){
        System.out.println(objPayAccount);
    }

    //UPDATE USER DETAIL FUNCTIONS
    public void changeUserName(String userName){
        super.userName=userName;
        System.out.println("User Name UPDATED!");
    }
    public void changeUserAge(int userAge){
        super.userAge=userAge;
        System.out.println("User Age UPDATED!");
    }
    public void changeUserPhn(long userPhn){
        super.userPhn=userPhn;
        System.out.println("User Phone Number UPDATED!");
    }
    //override abstract function from interface UserDetailsUpdate
    @Override
    public void changeEmail(String userEmail){
        if(userEmail.endsWith("@gmail.com")){
            super.userEmail=userEmail;
            System.out.println("Email UPDATED!");
        }else{
            System.out.println("Invalid Email!");
        }
    }

}
