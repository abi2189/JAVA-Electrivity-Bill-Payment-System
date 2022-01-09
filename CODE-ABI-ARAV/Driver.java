import java.util.Scanner;
public class Driver {
    static int custCount=0;
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int intChoice;
        char charChoice;
        Customer[] objCustomer;
        //Allocating memory not initiallizing
        objCustomer = new Customer[100];
        Tools objTools = new Tools();
        objTools.preCustomer(objCustomer);

        Admin[] objAdmin;
        objAdmin = new Admin[3];

        String printLine="--------------------------------------------------------------";
        System.out.println(printLine+"\n\t\t\tWELCOME");
        do{
            System.out.println(printLine+"\n\t\t\tADMIN/CUSTOMER");
            System.out.println("\t\tEnter 1.CUSTOMER 2.ADMIN\n"+printLine);

            intChoice = scan.nextInt();
            switch(intChoice) {
                //-----------------------------------------------------CUSTOMER --------------------------------------------
                case 1:{
                    do{
                        System.out.println(printLine+"\n\t\t\tCUSTOMER");
                        System.out.println("\t\tEnter 1.REGISTER 2.LOGIN\n"+printLine);
        
                        intChoice = scan.nextInt();
        
                        switch(intChoice) {
                            case 1:{
                                int newCustomerIndex = objTools.linearSearchIndex(objTools.createUserID());
                                System.out.println("Your Auto-Generated Customer ID: " + objTools.indexStoredUserID[newCustomerIndex]);

                                System.out.print(printLine+"\nEnter User Name: ");
                                String custUsername=scan.next();
                                System.out.print("Set Password: ");
                                String custPass=scan.next();
                                System.out.println("Enter User Age:");
                                int custUserAge=scan.nextInt();
                                String custEmail;
                                do{
                                    System.out.println("Enter User Email:");
                                    custEmail=scan.next();
                                    if(!custEmail.endsWith("@gmail.com")){
                                        System.out.println("Invalid Email!");
                                    }
                                }while(!custEmail.endsWith("@gmail.com"));  
                                Long custPhn;   
                                String str;     
                                do{
                                    System.out.println("Enter Phone Number:");
                                    custPhn=scan.nextLong();
                                    str=Long.toString(custPhn);
                                    if(str.length()!=10){
                                        
                                        System.out.println("Invalid Phone Number!");
                                    }
                                }while(str.length()!=10);  

                                objCustomer[newCustomerIndex] = new Customer(objTools.indexStoredUserID[newCustomerIndex], custUsername, custPass, custUserAge, custEmail, custPhn);

                                objCustomer[newCustomerIndex].viewCustomerDetails();


                                break;
                            }
                                
                            case 2:{
                                // System.out.println("ha");
                                int loggedCustomer=0;
                                boolean userCheck=false;
                                int userCheckCount=5;
                                do{
                                    System.out.print("Enter User ID: ");
                                    Long custLogID=scan.nextLong();
                                    System.out.print("Enter Password: ");
                                    String custLogPass=scan.next();
                                    for(int i=0;i<3;i++){
                                        if(custLogID==objCustomer[i].userID&&objCustomer[i].userPass.equals(custLogPass)){
                                            System.out.println("Login Successfull...\n"+printLine);
                                            loggedCustomer=i;
                                            userCheck=true;
                                            break;
                                        }
                                    }
                                    if(userCheck==false){
                            
                                        System.out.println(printLine+"\nINVALID CREDENTIALS TRY AGAIN");
                                        System.out.println("ATTEMPTS LEFT:"+userCheckCount%3 +"\n"+printLine);
                                        userCheckCount--;
                                        
                                    }
                                    if(userCheckCount==2){
                                        System.out.println("\nNo of attempts exceeded!!!");
                                        break;
                                    }
                                }while((!userCheck)&&userCheckCount>=3);
                                if(userCheckCount==2){
                                    break;
                                }
                                do{
                                    System.out.println(printLine);
                                    System.out.println("\t\t\tMenu\n\t\t1.Update Profile\n\t\t2.Bill Payment\n\t\t3.LOG OUT");
                                    intChoice = scan.nextInt();
                                    switch(intChoice){
                                        case 1:{
                                            do{
                                                System.out.println(printLine);
                                                System.out.println("\t\t\tMenu\n\t\t1.Update User Name\n\t\t2.Update Age\n\t\t3.Update Mobile Number\n\t\t4.Update Email\n\t\t5.EXIT");
                                                intChoice = scan.nextInt();
                                                switch(intChoice){
                                                    case 1:{
                                                        System.out.println(printLine);
                                                        System.out.println("Enter New User Name:");
                                                        String updateName = scan.next();
                                                        objCustomer[loggedCustomer].changeUserName(updateName);
                                                        System.out.println(printLine);
                                                        System.out.println(objCustomer[loggedCustomer]);
                                                        break;
                                                    }
                                                    case 2:{
                                                        System.out.println(printLine);
                                                        System.out.println("Enter New Age:");
                                                        int updateAge = scan.nextInt();
                                                        objCustomer[loggedCustomer].changeUserAge(updateAge);
                                                        System.out.println(printLine);
                                                        System.out.println(objCustomer[loggedCustomer]);
                                                        break;
                                                    }
                                                    case 3:{
                                                        System.out.println(printLine);
                                                        System.out.println("Enter New Mobile Number:");
                                                        long updatePhn = scan.nextLong();
                                                        objCustomer[loggedCustomer].changeUserPhn(updatePhn);
                                                        System.out.println(printLine);
                                                        System.out.println(objCustomer[loggedCustomer]);
                                                        break;
                                                    }
                                                    case 4:{
                                                        System.out.println(printLine);
                                                        System.out.println("Enter New Email:");
                                                        String updateEmail = scan.next();
                                                        objCustomer[loggedCustomer].changeEmail(updateEmail);
                                                        System.out.println(printLine);
                                                        System.out.println(objCustomer[loggedCustomer]);
                                                        break;
                                                    }
                                                    case 5:{break;}
                                                }
                                                if(intChoice==5){break;}
                                            }while(true);
                                        }
            
                                       
                                        case 2:
            
                                        case 3:{break;}
            
                                    }
                                    if(intChoice==3){
                                        System.out.println(printLine+"\nLOGGING OUT.....");
                                        break;
                                    }
                                }while(true);
                                
                                // objCustomer[0].viewCustomerDetails();
                                
                                // break;
                            }
                
                                
                            default:
                                
                        }
                        System.out.println(printLine+"\nDo you want to logout?(y/n)");
                        charChoice = scan.next().charAt(0);
                        if(charChoice=='y'){
                            System.out.println(printLine+"\nLOGGING OUT.....");
                        }


                    }while(charChoice!='y');
                    break;

                }
                    
                //-----------------------------------------------------ADMIN --------------------------------------------
                case 2:{
                    boolean userCheck=false;
                    int userCheckCount=5;
                    int loggedAdmin=0;
                    System.out.println(printLine+"\n\t\t\tADMIN LOGIN");
                    // System.out.println(printLine);

                    
                    objAdmin[0] =new Admin(12345678L,"lucas", "admin123", 25, "lucas123@eboi.co.in", 7834672366L);
                    objAdmin[1] =new Admin(22345678L,"Harry", "admin223", 26, "Harry223@eboi.co.in", 9449047389L);
                    objAdmin[2] =new Admin(32345678L,"Cole", "admin323", 29, "Cole323@eboi.co.in", 6734892578L);

                    do{
                        System.out.println("ENTER ADMIN ID:");
                        long adminID=scan.nextLong();
                        System.out.println("ENTER ADMIN PASSWORD:");
                        String adminPass=scan.next();
                        for(int i=0;i<3;i++){
                            // System.out.println("check");
                            // System.out.println(objAdmin[i]);
                            if(objAdmin[i].userID==adminID &&objAdmin[i].userPass.equals(adminPass)){
                                // System.out.println("id check");
                                // System.out.println("pass check");
                                loggedAdmin=i;
                                userCheck=true;
                                System.out.println("Login Successfull...\n"+printLine+"\nUSER DETAILS");
                                System.out.println(objAdmin[i]);
                                break;                                
                            }
                        }
                        if(userCheck==false){
                            
                            System.out.println(printLine+"\nINVALID CREDENTIALS TRY AGAIN");
                            System.out.println("ATTEMPTS LEFT:"+userCheckCount%3 +"\n"+printLine);
                            userCheckCount--;
                            
                        }
                        if(userCheckCount==2){
                            System.out.println("\nNo of attempts exceeded!!!");
                            break;
                        }
                    }while((!userCheck)&&userCheckCount>=3);
                    if(userCheckCount==2){
                        break;
                    }
                    
                    do{
                        System.out.println(printLine);
                        System.out.println("\t\t\tMenu\n\t\t1.Update Profile\n\t\t2.View All User\n\t\t3.Approve New User\n\t\t4.LOG OUT");
                        System.out.print("Enter Choice:");
                        intChoice = scan.nextInt();
                        switch(intChoice){
                            case 1:{
                                do{
                                    System.out.println(printLine);
                                    System.out.println("\t\t\tMenu\n\t\t1.Update User Name\n\t\t2.Update Age\n\t\t3.Update Mobile Number\n\t\t4.Update Email\n\t\t5.EXIT");

                                    System.out.print("Enter Choice:");
                                    intChoice = scan.nextInt();
                                    switch(intChoice){
                                        case 1:{
                                            System.out.println(printLine);
                                            System.out.print("Enter New User Name:");
                                            String updateName = scan.next();
                                            objAdmin[loggedAdmin].changeUserName(updateName);
                                            System.out.println(printLine);
                                            System.out.println(objAdmin[loggedAdmin]);
                                            break;
                                        }
                                        case 2:{
                                            System.out.println(printLine);
                                            System.out.print("Enter New Age:");
                                            int updateAge = scan.nextInt();
                                            objAdmin[loggedAdmin].changeUserAge(updateAge);
                                            System.out.println(printLine);
                                            System.out.println(objAdmin[loggedAdmin]);
                                            break;
                                        }
                                        case 3:{
                                            System.out.println(printLine);
                                            System.out.print("Enter New Mobile Number:");
                                            long updatePhn = scan.nextLong();
                                            objAdmin[loggedAdmin].changeUserPhn(updatePhn);
                                            System.out.println(printLine);
                                            System.out.println(objAdmin[loggedAdmin]);
                                            break;
                                        }
                                        case 4:{
                                            System.out.println(printLine);
                                            System.out.print("Enter New Email:");
                                            String updateEmail = scan.next();
                                            objAdmin[loggedAdmin].changeEmail(updateEmail);
                                            System.out.println(printLine);
                                            System.out.println(objAdmin[loggedAdmin]);
                                            break;
                                        }
                                        case 5:{break;}
                                    }
                                    if(intChoice==5){break;}
                                }while(true);
                            }

                            //-------------------view all customers 
                            case 2:

                            //-------------------approve new customers
                            case 3:

                            case 4:{break;}
                        }
                        if(intChoice==4){break;}


                    }while(true);
                }
                
            } 
            
            
            System.out.println(printLine+"\nDo you want to go to the main menu?(y/n)");
            charChoice = scan.next().charAt(0);

        }while(charChoice=='y');



    scan.close();
    }
    
}