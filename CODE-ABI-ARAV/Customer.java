import java.util.*;
import java.text.*;

public class Customer extends User implements UserDetailsUpdate{
    static String printLine = "--------------------------------------------------------------";
    public payAccount objPayAccount;
    private Feedback objFeedback;

    // public Tools objTools1;
    public serviceNo[] objServiceNo = new serviceNo[100];
    public int[] serviceNoIndices = new int[10];
    public int SNI;

    public void passServiceNo(serviceNo objServiceNo, int newServiceNoIndex) {

        this.objServiceNo[newServiceNoIndex] = objServiceNo;//create new obj service no outside in the driver
        // ref cuz [] allocating mem, passed service no. is a new obj.
    }

    //only for register part
    public void viewServiceNo(int[] serviceNoIndices, int SNI){
        this.SNI = SNI;
        for (int i = 0; i < SNI; i++) {
            // System.out.println("LOOP: " + i);
            this.serviceNoIndices[i] = serviceNoIndices[i];
            System.out.println(this.objServiceNo[serviceNoIndices[i]].toString());
        }
    }

    //only for logged in part
    public void viewServiceNoLogged(){
        System.out.println(printLine);
        for (int i = 0; i < SNI; i++) {
            System.out.println("\n"+(i+1)+"."+this.objServiceNo[serviceNoIndices[i]].viewServiceNoLoggedC());
        }

    }

    //pass only if user opts to save his card
    public void passPayAccountObj(payAccount objPayAccount){
        this.objPayAccount = objPayAccount;
        System.out.println(printLine+"\nCARD SAVED!");
    }


    //CONSTRUCTORS
    public Customer(){
        
    }
    public Customer(long userID, String userName, String userPass, int userAge, String userEmail, long userPhn){
        super(userID, userName, userPass, userAge, userEmail, userPhn);//parent class constructor
        // this.objTools1 = objTools1;
    }
    public void viewCustomerDetails(){
        System.out.println(super.toString());
    }
    public void adminViewCustomerDetails(){
        System.out.println(UadminViewCustomerDetails());
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
