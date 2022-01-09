public class User {
    protected long userID;
    protected String userName;
    protected String userPass;
    protected int userAge;
    protected String userEmail;
	protected String userPhn;

    public User(){
        
    }
    public User(long userID, String userName, String userPass, int userAge, String userEmail, String userPhn, Address addressObj){
        this.userID=userID;
        this.userName=userName;
        this.userPass=userPass; 
        this.userAge=userAge; 
        this.userEmail=userEmail; 
        this.userPhn=userPhn; 
    }
}
