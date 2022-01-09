public class Customer extends User{


    public Customer(){
    }
    public Customer(long userID, String userName, String userPass, int userAge, String userEmail, String userPhn, Address addressObj){
        super.userID=userID;
        super.userName=userName;
        super.userPass=userPass; 
        super.userAge=userAge; 
        super.userEmail=userEmail; 
        super.userPhn=userPhn; 
    }
}
