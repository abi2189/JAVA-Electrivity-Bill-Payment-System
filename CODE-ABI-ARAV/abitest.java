import java.util.Scanner;
public class abitest {
    public static void main(String[] args) {
        Admin a = new Admin(12345678L,"lucas", "admin123", 25, "lucas1998@eboi.co.in", 7904028134L);
        Scanner scan = new Scanner(System.in);
        System.out.println("enter admin id");
        while(true){
            long adminid=scan.nextLong();
            if(a.userID!=adminid){
                System.out.println("enter valid id");
            }else {
                break;
            }
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("enter admin pass");
        while(true){
            String  =scan.nextLong();
            if(a.userID!=adminid){
                System.out.println("enter valid id");
            }else {
                break;
            }
        }
        

    }
}
