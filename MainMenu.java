import java.text.DecimalFormat;
import java.util.*;
import java.io.IOException;

public class MainMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$' ###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do{
            try{
                data.put(123456, 654321);
                data.put(234567, 765432);
                data.put(345678, 876543);
                data.put(456789, 987654);

                System.out.println("Welcome to the ATM");
                System.out.println("Enter your customer number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your PIN number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e){
                System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
                x =2;
            }
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if(data.containsKey(cn) && data.get(cn) == pn){
                getAccountType();
            }
            else{
                System.out.println("\n" + "Please correct the input details" + "\n");
            }
        } while(x==1);
    }

    public void getAccountType(){
        System.out.println("Select the account you want to access: ");
        System.out.println("Press 1 - Current Account");
        System.out.println("Press 2 - Saving Account");
        System.out.println("Press 3 - Exit");

        int selection = menuInput.nextInt();

        switch(selection) {
            case 1: 
            getCurrent();
            break;

            case 2:
            getSaving();
            break;

            case 3: 
            System.out.println("ThankYou for using the ATM.\n\n");
            break;

            default:
            System.out.println("\n" + "Invalid choice." + "\n");
            getAccountType();
        }
    }

    public void getCurrent(){

        int selection = getChoice();
        switch(selection){
            case 1: 
            System.out.println("Current Account Balance: " + moneyFormat.format(getCurrentBalance()));
            getAccountType();
            break;

            case 2:
            getCurrentWithdrawInput();
            getAccountType();
            break;

            case 3: 
            getCurrentDepositInput();
            getAccountType();
            break;

            case 4: 
            System.out.println("ThankYou for using the ATM");
            break;

            default: 
            System.out.println("\n" + "Invalid choice." + "\n");
            getCurrent();
        }
    }

    public void getSaving(){

        int selection = getChoice();

        switch(selection) {
            case 1: 
            System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
            getAccountType();
            break;

            case 2:
            getsavingWithdrawInput();
            getAccountType();
            break;

            case 3:
            getSavingDepositInput();
            getAccountType();
            break;

            case 4:
            System.out.println("ThankYou for using the ATM.");
            break;

            default:
            System.out.println("\n" + "Invalid choice." + "\n");
            getCurrent();
        }
    }




    public int getChoice(){
        System.out.println("Saving Account");
        System.out.println("Press 1 - View Balance");
        System.out.println("Press 2 - Withdraw Funds");
        System.out.println("Press 3 - Deposit Funds");
        System.out.println("Press 4 - Exit");
        System.out.println("Choice: ");

        int choice = menuInput.nextInt();
        return choice;
    }
}