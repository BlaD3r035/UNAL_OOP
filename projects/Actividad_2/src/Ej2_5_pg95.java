public class Ej2_5_pg95 {
    static public void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter owner first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter owner last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter account number: ");
        int accountNumber = Integer.parseInt(sc.nextLine());
        System.out.print("Enter account type (SAVINGS or CURRENT): ");
        BankAccount.type accountType = BankAccount.type.valueOf(sc.nextLine().toUpperCase());

        BankAccount account = new BankAccount(firstName, lastName, accountNumber, accountType);

        account.print();

        System.out.print("Enter first deposit amount: ");
        int deposit1 = Integer.parseInt(sc.nextLine());
        account.deposit(deposit1);

        System.out.print("Enter second deposit amount: ");
        int deposit2 = Integer.parseInt(sc.nextLine());
        account.deposit(deposit2);

        System.out.print("Enter withdraw amount: ");
        int withdraw = Integer.parseInt(sc.nextLine());
        account.withdraw(withdraw);

        sc.close();
    }
}
