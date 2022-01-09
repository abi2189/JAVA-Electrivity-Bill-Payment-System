// -------------------------INTERFACE---------------------------
// interface UserLogin {

//     String EBoard="Tamil Nadu Electricity Board";
// 	String yearofImplementation="1st July 1957";
    
//     public abstract void changePassword(String Password);
//     public abstract void changeUsername(String UserName);
    
// }

// -------------------------CLASS--------------------------------
public abstract class User implements UserLogin{

// // --------------------DATA MEMBERS-------------------
//     private String userId;
// 	private String userName;
// 	private String userPass;
// 	private int userAge;
// 	private String userEmail;
// 	private String userPhn;

// --------------------ABSTRACT METHODS-------------------
    public abstract void changePassword(String Password);
    public abstract void changeUsername(String UserName);
    public abstract void updateUserdetails();
    public abstract String getUserdetails();

// --------------------GETTER/SETTER METHODS-------------------
    public String getUserId() {
		return userId;
	}
    public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhn() {
		return userPhn;
	}
	public void setUserPhn(String userPhn) {
		this.userPhn = userPhn;
	}

}