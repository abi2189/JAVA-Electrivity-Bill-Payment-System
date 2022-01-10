import java.util.Scanner;
import java.util.function.IntFunction;

import java.io.*;
import java.lang.Thread;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class Driver extends Thread {
    static int custCount = 0;

    public static void main(String[] args) throws Exception{

        Scanner scan = new Scanner(System.in);

        int intChoice;
        char charChoice;
        Customer[] objCustomer;
        // Allocating memory not initiallizing
        objCustomer = new Customer[100];
        Tools objTools = new Tools();
        objTools.preCustomer(objCustomer);
        
        Admin[] objAdmin;
        objAdmin = new Admin[3];
        objTools.preAdmin(objAdmin);

        String printLine = "--------------------------------------------------------------";
        System.out.println(printLine + "\n\t\t\tWELCOME");
        do {
            System.out.println(printLine + "\n\t\t\tADMIN/CUSTOMER");
            System.out.println("\t\t1.CUSTOMER 2.ADMIN");
            System.out.print("ENTER CHOICE: ");

            intChoice = scan.nextInt();
            

            switch (intChoice) {
                // -----------------------------------------------------CUSTOMER--------------------------------------------
                case 1: {
                    do {
                        System.out.println(printLine + "\n\t\t\tCUSTOMER");
                        System.out.println("\t\t1.REGISTER 2.LOGIN");
                        System.out.print("ENTER CHOICE: ");

                        intChoice = scan.nextInt();

                        switch (intChoice) {
                            // -----------------------------------------------------CUSTOMER REGISTER--------------------------------------------
                            case 1: {
                                int newCustomerIndex = objTools.linearSearchIndex(objTools.createUserID());
                                System.out.println(printLine+"\nYour Auto-Generated Customer ID: "
                                        + objTools.indexStoredUserID[newCustomerIndex]);
                                System.out.println(printLine);

                                System.out.print("Enter User Name: ");
                                String custUsername = scan.next();
                                System.out.print("Set Password: ");
                                String custPass = scan.next();
                                System.out.print("Enter User Age: ");
                                int custUserAge = scan.nextInt();
                                String custEmail;
                                do {
                                    System.out.print("Enter User Email: ");
                                    custEmail = scan.next();
                                    if (!custEmail.endsWith("@gmail.com")) {
                                        System.out.println("********Invalid Email!********");
                                    }
                                } while (!custEmail.endsWith("@gmail.com"));
                                Long custPhn;
                                String str;
                                do {
                                    System.out.print("Enter Phone Number: ");
                                    custPhn = scan.nextLong();
                                    str = Long.toString(custPhn);
                                    if (str.length() != 10) {

                                        System.out.println("********Invalid Phone Number!********");
                                    }
                                } while (str.length() != 10);

                                //NEW CUSTOMER CREATION
                                objCustomer[newCustomerIndex] = new Customer(objTools.indexStoredUserID[newCustomerIndex], custUsername, custPass, custUserAge, custEmail, custPhn);

                                int houseNo;
                                String streetName;
                                String city;
                                String district;
                                long pinCode;

                                Address objAddress;//just ref
                                serviceNo objServiceNo;
                                int newServiceNoIndex;

                                int[] serviceNoIndices = new int[10];
                                int SNI;
                                SNI = 0;

                                char strC;

                                do{

                                    System.out.println(printLine+"\nEnter Address Details of the building/office for which your paying electricity");
                                    System.out.print("Enter house No.: ");
                                    houseNo = scan.nextInt();
                                    System.out.print("Enter street name: ");
                                    streetName = scan.next();
                                    System.out.print("Enter city: ");
                                    city = scan.next();
                                    System.out.print("Enter district: ");
                                    district = scan.next();
                                    System.out.print("Enter pincode: ");
                                    pinCode = scan.nextLong();

                                    objAddress = new Address(houseNo, streetName, city, district, pinCode);

                                    newServiceNoIndex = objTools.linearSearchIndex(objTools.createServiceNo());
                                    System.out.println("Your Auto-Generated Service No. for this address: " + objTools.indexStoredServiceNo[newServiceNoIndex]);

                                    serviceNoIndices[SNI] = newServiceNoIndex;
                                    SNI++;

                                    objServiceNo = new serviceNo(objTools.indexStoredServiceNo[newServiceNoIndex],objAddress);
                                    objCustomer[newCustomerIndex].passServiceNo(objServiceNo, newServiceNoIndex);
                                    System.out.print(printLine+"\nDo you want to add address of another building that you own?(y/n): ");
                                    strC = scan.next().charAt(0);
                                }while((strC == 'y') || (strC == 'Y'));

                                System.out.println();
                                objCustomer[newCustomerIndex].viewCustomerDetails();

                                objCustomer[newCustomerIndex].viewServiceNo(serviceNoIndices, SNI);

                                // System.out.println(objServiceNo);//last obj
                                System.out.println(printLine+"\nRegistration Process Done! Wait for the APPROVAL!\n\t\tThank You\n\tRedirecting to LOGIN PAGE");


                                break;
                            }
                            // -----------------------------------------------------CUSTOMER LOGIN--------------------------------------------

                            case 2: {
                                // System.out.println("ha");
                                int loggedCustomerIndex = 0;//index
                                boolean userCheck = false;//for some printing statements
                                int userCheckCount = 5;//attempts
                                do {
                                    System.out.print(printLine+"\nEnter User ID: ");
                                    Long custLogID = scan.nextLong();
                                    System.out.print("Enter Password: ");
                                    String custLogPass = scan.next();

                                    
                                    loggedCustomerIndex = objTools.linearSearchIndex(custLogID);
                                    if(loggedCustomerIndex == 999){
                                        userCheck=false;
                                    } else if (loggedCustomerIndex != 999) {
                                        userCheck=false;//partially true
                                        
                                        if(objCustomer[loggedCustomerIndex].userPass.equals(custLogPass)){
                                            userCheck=true;
                                            System.out.println("Logging in...");
                                            try { Thread.sleep(1500);} catch (Exception e) {}
                                            System.out.println("\t\tLOGGED IN");

                                            try { Thread.sleep(1500);} catch (Exception e) {}
                                            break;
                                        }
                                    }



                                    // for (int i = 0; i < 3; i++) {
                                    //     if (custLogID == objCustomer[i].userID
                                    //             && objCustomer[i].userPass.equals(custLogPass)) {
                                    //         System.out.println("Login Successfull...\n" + printLine);
                                    //         loggedCustomerIndex = i;
                                    //         userCheck = true;
                                    //         break;
                                    //     }
                                    // }
                                    if (userCheck == false) {

                                        System.out.println(printLine + "\n*********INVALID CREDENTIALS TRY AGAIN*********");
                                        System.out.println("ATTEMPTS LEFT:" + userCheckCount % 3 + "\n" + printLine);
                                        userCheckCount--;

                                    }
                                    if (userCheckCount == 2) {
                                        
                                        System.out.println("\nNo of attempts exceeded!!!");
                                        try { Thread.sleep(1500);} catch (Exception e) {}

                                        break;
                                    }
                                } while ((!userCheck) && userCheckCount >= 3);
                                if (userCheckCount == 2) {
                                    break;
                                }
                                do {
                                    System.out.println(printLine);
                                    System.out.println("\t\t\tUSER MENU\n\t\t1.Update Profile\n\t\t2.Bill Payment\n\t\t3.LOG OUT");
                                    System.out.print("ENTER CHOICE: ");

                                    intChoice = scan.nextInt();
                                    switch (intChoice) {
                                        case 1: {
                                            do {
                                                System.out.println(printLine);
                                                System.out.println(
                                                        "\t\tUPDATE PROFILE MENU\n\t\t1.Update User Name\n\t\t2.Update Age\n\t\t3.Update Mobile Number\n\t\t4.Update Email\n\t\t5.EXIT");
                                                System.out.print("ENTER CHOICE: ");

                                                intChoice = scan.nextInt();
                                                switch (intChoice) {
                                                    case 1: {
                                                        System.out.println(printLine);
                                                        System.out.println("Enter New User Name:");
                                                        String updateName = scan.next();
                                                        objCustomer[loggedCustomerIndex].changeUserName(updateName);
                                                        System.out.println(printLine);
                                                        System.out.println(objCustomer[loggedCustomerIndex]);
                                                        break;
                                                    }
                                                    case 2: {
                                                        System.out.println(printLine);
                                                        System.out.println("Enter New Age:");
                                                        int updateAge = scan.nextInt();
                                                        objCustomer[loggedCustomerIndex].changeUserAge(updateAge);
                                                        System.out.println(printLine);
                                                        System.out.println(objCustomer[loggedCustomerIndex]);
                                                        break;
                                                    }
                                                    case 3: {
                                                        System.out.println(printLine);
                                                        System.out.println("Enter New Mobile Number:");
                                                        long updatePhn = scan.nextLong();
                                                        objCustomer[loggedCustomerIndex].changeUserPhn(updatePhn);
                                                        System.out.println(printLine);
                                                        System.out.println(objCustomer[loggedCustomerIndex]);
                                                        break;
                                                    }
                                                    case 4: {
                                                        System.out.println(printLine);
                                                        System.out.println("Enter New Email:");
                                                        String updateEmail = scan.next();
                                                        objCustomer[loggedCustomerIndex].changeEmail(updateEmail);
                                                        System.out.println(printLine);
                                                        System.out.println(objCustomer[loggedCustomerIndex]);
                                                        break;
                                                    }
                                                    case 5: {
                                                        System.out.println("EXITING...");

                                                        try { Thread.sleep(1500);} catch (Exception e) {}
                                                        break;
                                                    }
                                                }
                                                if (intChoice == 5) {
                                                    break;
                                                }System.out.println(printLine + "\nDo you want to go to the UPDATE PROFILE MENU?(y/n)");
                                                charChoice = scan.next().charAt(0);

                                            } while (charChoice == 'y'||charChoice == 'Y');
                                            break;
                                        }
            
                                       
                                        case 2:{
                                            do{
                                                System.out.print(printLine+"\n\t\tBILL PAYMENT\n");

                                                objCustomer[loggedCustomerIndex].viewServiceNoLogged();
                                                System.out.print(printLine+"\nChoose service number:");
                                                int serviceNumberCh =scan.nextInt();
                                                // serviceNumberCh=0;////jus to check for the predefined value for 1st customer 1 service number
                                                System.out.println(printLine);
                                                System.out.println("\t\t\tBill Payment Menu\n\t\t1.PAID BILLS\n\t\t2.UNPAID BILLS\n\t\t3.Back to USER MENU");
                                                System.out.print("ENTER CHOICE: ");

                                                intChoice = scan.nextInt();
                                                switch(intChoice){
                                                    case 1:{
                                                        objCustomer[loggedCustomerIndex].objServiceNo[serviceNumberCh].getPaidBills();
                                                        break;

                                                    }
                                                    case 2:{
                                                        objCustomer[loggedCustomerIndex].objServiceNo[serviceNumberCh].getUnpaidBills();
                                                        System.out.print(printLine+"\nChoose Bill number to PAY:");
                                                        int payBillCh =scan.nextInt();
                                                        System.out.println(printLine+"\n\t\t\tPAYMENT\n"+printLine);
                                                        System.out.print("Enter Account Number: ");
                                                        Long accountNo = scan.nextLong();
                                                        System.out.print("Enter Card Holder Name: ");
                                                        String cardHolderName = scan.next();
                                                        System.out.print("Enter Postal Code: ");
                                                        int postalCode = scan.nextInt();
                                                        System.out.print("Enter Expiry Date(MM/yyyy): ");
                                                        String expiryDate = scan.next();
                                                        
                                                        System.out.print(printLine+"\nDo you want to save the card?(y/n): ");
                                                        charChoice = scan.next().charAt(0);
                                                        if(charChoice == 'y' || charChoice == 'Y'){
                                                            payAccount objPayAccount=new payAccount(accountNo,cardHolderName,postalCode,expiryDate);
    
                                                            objCustomer[loggedCustomerIndex].passPayAccountObj(objPayAccount);
                                                            
                                                            //only if he saves it 
                                                            System.out.println(printLine);
    
                                                            objCustomer[loggedCustomerIndex].objPayAccount.viewCardDetails();
                                                            System.out.println(printLine);

                                                        }

                                                        System.out.println("Payment processing....");
                                                        try { Thread.sleep(1500);} catch (Exception e) {}
                                                        System.out.println("*******Payment Successful*******");


                                                        long transID = objTools.createTransactionNo();
                                                        Payment objPayment = new Payment(transID, "Payment Successful");

                                                        objCustomer[loggedCustomerIndex].objServiceNo[serviceNumberCh].objBillUnpaid[payBillCh].generateTransactionID(objPayment);

                                                        System.out.println(printLine);
                                                        System.out.println(objPayment.toString());

                                                        System.out.println(printLine);

                                                        System.out.print("Do you want a PAYMENT RECEIPT?(y/n): ");
                                                        charChoice = scan.next().charAt(0);
                                                        
                                                        if(charChoice == 'y' || charChoice == 'Y'){
                                                            try {
                                                                FileWriter myWriter = new FileWriter("billReceipt"+objCustomer[loggedCustomerIndex].userID+".txt");

                                                                // myWriter.write("Files in Java might be tricky, but it is fun enough!");

                                                                myWriter.write(objCustomer[loggedCustomerIndex].objServiceNo[serviceNumberCh].objBillUnpaid[payBillCh].viewBillDatesFile());
                                                                myWriter.write(objPayment.toString()+"\n-----------------------------------\t");


                                                                myWriter.close();
                                                                System.out.println("Bill Receipt Generated!");
                                                              } catch (IOException e) {
                                                                System.out.println("An error occurred.");
                                                                e.printStackTrace();
                                                              }
                                                        }
                                                        break;

                                                    }
                                                    case 3:{break;}
                                                }
                                                if(intChoice==3){break;}

                                                System.out.print(printLine + "\nDo you want to go to the BILL PAYMENT?(y/n): ");
                                                charChoice = scan.next().charAt(0);

                                            } while (charChoice == 'y'||charChoice == 'Y');

                                            // objCustomer[loggedCustomerIndex].viewServiceNoLogged();
                                            /*
                                            objCustomer[loggedCustomerIndex].viewServiceNoLogged();
                                            objCustomer[loggedCustomerIndex].objServiceNo[0].getPaidBills();
                                            objCustomer[loggedCustomerIndex].objServiceNo[0].getUnpaidBills();
                                            */

                                        }
            
                                        case 3:{
                                            try { Thread.sleep(1500);} catch (Exception e) {}
                                            break;
                                        }
            
                                    }
                                    if (intChoice == 3) {
                                        break;
                                    }
                                } while (true);
                                if (intChoice == 3) {
                                    System.out.println(printLine + "\nLOGGING OUT.....");
                                    break;
                                }
                            }

                        }
                        System.out.print(printLine + "\nDo you want to go to LOGIN PAGE?(y/n): ");
                        charChoice = scan.next().charAt(0);
                        if (charChoice == 'y'||charChoice == 'y') {
                        }

                    } while (charChoice == 'y'||charChoice == 'y');
                    break;

                }

                // -----------------------------------------------------ADMIN
                // --------------------------------------------
                case 2: {
                    boolean userCheck = false;
                    int userCheckCount = 5;
                    int loggedAdmin = 0;
                    System.out.println(printLine + "\n\t\t\tADMIN LOGIN");
                    // System.out.println(printLine);                    

                    do {
                        System.out.print("ENTER ADMIN ID: ");
                        long adminID = scan.nextLong();
                        System.out.print("ENTER ADMIN PASSWORD: ");
                        String adminPass = scan.next();
                        for (int i = 0; i < 3; i++) {
                            // System.out.println("check");
                            // System.out.println(objAdmin[i]);
                            if (objAdmin[i].userID == adminID && objAdmin[i].userPass.equals(adminPass)) {
                                // System.out.println("id check");
                                // System.out.println("pass check");
                                loggedAdmin = i;
                                userCheck = true;
                                System.out.println("Logging in...");
                                try { Thread.sleep(1500);} catch (Exception e) {}
                                // System.out.println("\t\tLOGGED IN");
                                System.out.println("LOGGED IN\n" + printLine + "\n\t\tADMIN DETAILS");
                                System.out.println(objAdmin[i]);
                                break;
                            }
                        }
                        if (userCheck == false) {

                            System.out.println(printLine + "\nINVALID CREDENTIALS TRY AGAIN");
                            System.out.println("ATTEMPTS LEFT:" + userCheckCount % 3 + "\n" + printLine);
                            userCheckCount--;

                        }
                        if (userCheckCount == 2) {
                            System.out.println("\nNo of attempts exceeded!!!");
                            break;
                        }
                    } while ((!userCheck) && userCheckCount >= 3);
                    if (userCheckCount == 2) {
                        break;
                    }

                    do {
                        System.out.println(printLine);
                        System.out.println(
                                "\t\t\tADMIN MENU\n\t\t1.Update Profile\n\t\t2.View All User\n\t\t3.Approve New User\n\t\t4.LOG OUT");
                        System.out.print("Enter Choice:");
                        intChoice = scan.nextInt();
                        switch (intChoice) {
                            case 1: {
                                do {
                                    System.out.println(printLine);
                                    System.out.println(
                                            "\t\t\tUPDATE PROFILE MENU\n\t\t1.Update User Name\n\t\t2.Update Age\n\t\t3.Update Mobile Number\n\t\t4.Update Email\n\t\t5.EXIT");

                                    System.out.print("Enter Choice:");
                                    intChoice = scan.nextInt();
                                    switch (intChoice) {
                                        case 1: {
                                            System.out.println(printLine);
                                            System.out.print("Enter New User Name:");
                                            String updateName = scan.next();
                                            objAdmin[loggedAdmin].changeUserName(updateName);
                                            System.out.println(printLine);
                                            System.out.println(objAdmin[loggedAdmin]);
                                            break;
                                        }
                                        case 2: {
                                            System.out.println(printLine);
                                            System.out.print("Enter New Age:");
                                            int updateAge = scan.nextInt();
                                            objAdmin[loggedAdmin].changeUserAge(updateAge);
                                            System.out.println(printLine);
                                            System.out.println(objAdmin[loggedAdmin]);
                                            break;
                                        }
                                        case 3: {
                                            System.out.println(printLine);
                                            System.out.print("Enter New Mobile Number:");
                                            long updatePhn = scan.nextLong();
                                            objAdmin[loggedAdmin].changeUserPhn(updatePhn);
                                            System.out.println(printLine);
                                            System.out.println(objAdmin[loggedAdmin]);
                                            break;
                                        }
                                        case 4: {
                                            System.out.println(printLine);
                                            System.out.print("Enter New Email:");
                                            String updateEmail = scan.next();
                                            objAdmin[loggedAdmin].changeEmail(updateEmail);
                                            System.out.println(printLine);
                                            System.out.println(objAdmin[loggedAdmin]);
                                            break;
                                        }
                                        case 5: {
                                            break;
                                        }
                                    }
                                    if (intChoice == 5) {
                                        break;
                                    }
                                } while (true);
                                break;
                            }

                            // -------------------view all customers
                            case 2: {
                                System.out.println("USERID\tUSER NAME  AGE\tEMAIL\t\tPHONE NO\n" + printLine);

                                for (int i = 0; i < objTools.getUserIDLastIndex()-1; i++) {
                                    objCustomer[i].adminViewCustomerDetails();
                                }
                                break;
                            }

                            // -------------------approve new customers
                            case 3:{
                                System.out.println("NEW USER REGISTRATIONS");
                                System.out.println("USERID\tUSER NAME  AGE\tEMAIL\t\tPHONE NO\n" + printLine);

                                //                         last plus one value(n)
                                for (int i = 3; i < objTools.getUserIDLastIndex(); i++) {
                                
                                    objCustomer[i].adminViewCustomerDetails();
                                    System.out.println("Approve User?(y/n)");
                                    charChoice = scan.next().charAt(0);
                                    if(charChoice=='y'||charChoice=='Y'){
                                        System.out.println("USER APPROVED!!!");

                                    }else{
                                        System.out.println("USER REGISTRATION DENIED!!!");
                                    }
                                }
                                break;
                            }

                            case 4: {
                                
                                System.out.println(printLine + "\nLogging out...");
                                try { Thread.sleep(1500);} catch (Exception e) {}
                                break;
                            }
                        }
                        if (intChoice == 4) {
                            break;
                        }
                        System.out.print(printLine + "\nDo you want to go to ADMIN MENU?(y/n): ");
                        charChoice = scan.next().charAt(0);
                        

                    } while (charChoice == 'y'||charChoice == 'y');
                }

            }

            System.out.println(printLine + "\nDo you want to go to the MAIN MENU?(y/n)");
            charChoice = scan.next().charAt(0);

        } while (charChoice == 'y');
        System.out.println(printLine + "\n\t\tTHANK YOU\n"+printLine);


        scan.close();
    }

}