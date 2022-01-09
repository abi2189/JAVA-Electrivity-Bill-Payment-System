import java.util.*;
import java.text.*;

public class Customer extends User{

    private PayAccount objPayAccount = new PayAccount();
    private Feedback objFeedback;

    public Customer(){
    }
    public Customer(long userID, String userName, String userPass, int userAge, String userEmail, String userPhn, Address addressObj){
        super(userID, userName, userPass, userAge, userEmail, userPhn, addressObj);
    }
    public void setFeedbackDetails(String feedbackDesc,Date feedbackDate){
        objFeedback= new Feedback(feedbackDesc,feedbackDate);
    }
}
