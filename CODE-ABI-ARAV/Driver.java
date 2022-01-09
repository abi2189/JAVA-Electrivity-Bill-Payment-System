import java.util.Scanner;
public class Driver {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int choice;

        String printLine="===========================================================";
        System.out.println(printLine+"\n\t\t\tWELCOME");
        do{
            System.out.println(printLine+"\n\t\t\tADMIN/CUSTOMER");
            System.out.println("\t\tEnter 1.CUSTOMER 2.ADMIN\n"+printLine);

            choice = scan.nextInt();
            switch(choice) {
                case 1:{
                    do{
                        System.out.println(printLine+"\n\t\t\tCUSTOMER");
                        System.out.println("\t\tEnter 1.REGISTER 2.LOGIN\n"+printLine);
        
                        choice = scan.nextInt();
        
                        switch(choice) {
                            case 1:
                                
                                break;
                            case 2:
                                
                                break;
                            default:
                                
                        }

                    }while(choice==1);
                    break;

                }
                    
                    
                case 2:{
                    boolean userCheck=false;
                    int userCheckCount=5;
                    System.out.println(printLine+"\n\t\t\tADMIN LOGIN");
                    System.out.println(printLine);

                    Admin[ ] objAdmin;
                    objAdmin = new Admin[3];
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
                                System.out.println("id check");
                                System.out.println("pass check");
                                userCheck=true;
                                System.out.println(objAdmin[i]);
                                break;                                
                            }
                        }
                        if(userCheck==false){
                            
                            System.out.println("INVALID CREDENTIALS TRY AGAIN");
                            System.out.println("ATTEMPS LEFT:"+userCheckCount%3 );
                            userCheckCount--;
                            
                        }
                        if(userCheckCount==2){
                            System.out.println("No of attempts exceeded!!!");
                        }
                    }while((!userCheck)&&userCheckCount>=3);
                    




                    // System.out.println(objAdmin[0]);
                    // System.out.println(objAdmin[1]);
                    // System.out.println(objAdmin[2]);

                }
                     
                break;
                default:
                      // code block
                } 


        }while(choice==1);









        // System.out.println(printLine+"\n\t\t\tADMIN/CUSTOMER");
        // System.out.println("\t\tEnter 1.CUSTOMER 2.ADMIN\n"+printLine);

        // userChoice = scan.nextInt();


        // switch(userChoice) {
        //     case 1:
        //         System.out.println(printLine+"\n\t\t\tCUSTOMER");
        //         System.out.println("\t\tEnter 1.REGISTER 2.LOGIN\n"+printLine);

        //         logChoice = scan.nextInt();

        //         switch(logChoice) {
        //             case 1:
                        
        //                 break;
        //             case 2:
        //                 // code block
        //                 break;
        //             default:
        //                 // code block
        //           }

        //         break;
        //     case 2:
        //       // code block
        //         break;
        //     default:
        //       // code block
        //   } 





    scan.close();
    }
    
}