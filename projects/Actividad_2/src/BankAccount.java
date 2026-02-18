public class BankAccount {
    private String ownerFirstName;
    private String ownerLastName;
    private int accountNumber;
    public enum type {
        SAVINGS, CURRENT
    }
    private type accountType;
    private float balance = 0;
    private float interestRate = 0.05f;

    public BankAccount(String ownerFirstName, String ownerLastName, int accountNumber, type accountType) {
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;

    }

    public void print(){
        System.out.println("Owner: " + ownerFirstName + " " + ownerLastName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }

    public void print_balance(){
        System.out.println("Balance: " + balance);
    }

    public boolean deposit(int amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited " + amount + " USD in your bank account. The new balance is: " + balance + " USD");
            return true;
        }else {
            System.out.println("The amount to be deposited must be greater than 0");
            return false;
        }
    }

    public boolean withdraw(int amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("Withdrawn " + amount + " USD from your bank account. The new balance is: " + balance + " USD");
            return true;
        }else {
            System.out.println("The amount to be withdrawn exceeds the current balance");
            return false;
        }
    }
    public void calculateInterest(){
        float newBalance = balance + (balance * interestRate);
        System.out.println("The new balance after " + interestRate + " interest is: " + newBalance + " USD");
    }
}
