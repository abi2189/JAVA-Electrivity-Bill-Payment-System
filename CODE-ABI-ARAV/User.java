interface UserDetailsUpdate{
    public abstract void changeEmail(String userEmail);
}


public class User {
    protected long userID;
    protected String userName;
    protected String userPass;
    protected int userAge;
    protected String userEmail;
	protected long userPhn;

    public User(){
        
    }
    public User(long userID, String userName, String userPass, int userAge, String userEmail, long userPhn){
        this.userID=userID;
        this.userName=userName;
        this.userPass=userPass; 
        this.userAge=userAge; 
        this.userEmail=userEmail; 
        this.userPhn=userPhn; 
    }
    public String UadminViewCustomerDetails(){
        return userID+"\t"+userName+"\t  "+userAge+"\t"+userEmail+"\t"+userPhn;
    }
    public String toString(){
        return "User ID: "+userID+"\nUser Name: "+userName+"\nUser Age: "+userAge+"\nUser Email: "+userEmail+"\nUser Phn: "+userPhn;
    }
}
