import java.text.DecimalFormat;
import java.util.*;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    public int setCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber(){
        return customerNumber;
    }

    public int setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    public int getPinNumber(){
        return pinNumber;
    }

    public double getCurrentBalance(){
        return currentBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    public double calcCurrentWithdraw(double amount){
        currentBalance = (currentBalance - amount);
        return currentBalance;
    }

    public double calcSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calcCurrentDeposit(double amount){
        currentBalance = (currentBalance + amount);
        return currentBalance;
    }

    public double calcSavingDeposit(double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    public void getCurrentWithdrawInput(){
        System.out.println("Current Account Balance: " + moneyFormat.format(currentBalance));
        System.out.println("Amount you want to withdraw from Current Account: ");
        double amount = input.nextDouble();

        if((currentBalance - amount) >= 0){
            calcCurrentWithdraw(amount);
            System.out.println("New Current Account Balance: " + moneyFormat.format(currentBalance));
        } else{
            System.out.println("Insufficient account balance." + "\n");
        }
    }

    public void getsavingWithdrawInput(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to withdraw from saving account: ");
        double amount = input.nextDouble();

        if((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else{
            System.out.println("Insufficient account balance." + "\n");
        }
    }

    public void getCurrentDepositInput(){
        System.out.println("Current Acoount Balance: " + moneyFormat.format(currentBalance));
        System.out.println("Amount you want to deposit to Current Account: ");
        double amount = input.nextDouble();

        if((currentBalance + amount) >= 0){
            calcCurrentDeposit(amount);
            System.out.println("New Current Account Balance: " + moneyFormat.format(currentBalance));
        } else{
            System.out.println("Insufficient account balance." + "\n");
        }
    }

    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to Deposit to saving Account: ");
        double amount = input.nextDouble();

        if((savingBalance + amount) >= 0){
            calcSavingDeposit(amount);
            System.out.println("New Saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Insufficient account balance." + "\n");
        }
    }

    private int customerNumber;
    private int pinNumber;
    private double currentBalance = 0;
    private double savingBalance = 0;
}