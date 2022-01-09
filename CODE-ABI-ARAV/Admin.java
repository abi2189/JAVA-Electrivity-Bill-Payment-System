public class Admin extends User implements UserDetailsUpdate{
    
    
    
    public Admin(){
    }
    public Admin(long userID, String userName, String userPass, int userAge, String userEmail, long userPhn){
        super(userID, userName, userPass, userAge, userEmail, userPhn);
    }
    public void changeUserName(String userName){
        super.userName=userName;
        System.out.println("User Name UPDATED!");
    }
    public void changeUserAge(int userAge){
        super.userAge=userAge;
        System.out.println("User Age UPDATED!");
    }
    public void changeUserPhn(long userPhn){
        String str=Long.toString(userPhn);
        if(str.length()==10){
            super.userPhn=userPhn;
            System.out.println("User Phone Number UPDATED!");
        }else{
            System.out.println("Invalid Phone! Detail Cannot be UPDATED!!!");
        }
    }
    //override abstract function from interface UserDetailsUpdate
    @Override
    public void changeEmail(String userEmail){
        if(userEmail.endsWith("@eboi.co.in")){
            super.userEmail=userEmail;
            System.out.println("Email UPDATED!");
        }else{
            System.out.println("Invalid Email! Detail Cannot be UPDATED!!!");
        }
    }
    
    public String toString(){
        return super.toString();
    }
    
}
