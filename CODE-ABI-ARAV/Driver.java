import java.util.Scanner;
public class Driver {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int userChoice,logChoice;

        String printLine="===========================================================";
        System.out.println(printLine+"\n\t\t\tWELCOME");
        System.out.println(printLine+"\n\t\t\tADMIN/CUSTOMER");
        System.out.println("\t\tEnter 1.CUSTOMER 2.ADMIN\n"+printLine);

        userChoice = scan.nextInt();

        switch(userChoice) {
            case 1:
                System.out.println(printLine+"\n\t\t\tCUSTOMER");
                System.out.println("\t\tEnter 1.REGISTER 2.LOGIN\n"+printLine);

                logChoice = scan.nextInt();

                switch(logChoice) {
                    case 1:
                        
                        break;
                    case 2:
                        // code block
                        break;
                    default:
                        // code block
                  }

                break;
            case 2:
              // code block
                break;
            default:
              // code block
          } 





    scan.close();
    }
    
}