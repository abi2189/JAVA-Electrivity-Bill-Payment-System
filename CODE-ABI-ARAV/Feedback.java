import java.util.*;
import java.text.*;

public class Feedback {
    private String feedbackDesc;
    private Date feedbackDate= new Date();

    SimpleDateFormat ft = 
      new SimpleDateFormat ("yyyy.MM.dd 'at' hh:mm:ss");
    
    public Feedback(){
    }
    public Feedback(String feedbackDesc, Date feedbackDate){
        this.feedbackDesc=feedbackDesc;
        this.feedbackDate=feedbackDate;
    }
    public void setCardholderName(String feedbackDesc){
        this.feedbackDesc=feedbackDesc;
    }
    public void setDate(Date feedbackDate){
        this.feedbackDate=feedbackDate;
    }
    public String getFeedbackDesc(){
        return this.feedbackDesc;
    }
    
    public String getFeedbackDate(){
        return ft.format(feedbackDate);
    }
    public String toString(){
        return String.format("Feedback Description: %s\nFeedback Date: %s", feedbackDate,ft.format(feedbackDate));
    }
}
