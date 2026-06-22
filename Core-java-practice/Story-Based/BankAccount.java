class BankAccount{
    String accountNumber;
    String holder;
    double balance;
    static int totalAccount=0;

    BankAccount(String accountNumber,String holder,double balance){
        this.accountNumber=accountNumber;
        this.holder=holder;
        this.balance=balance;

        totalAccount++;
    }
    void deposit(double amount){
        balance+= amount;
    }
    void withdraw(double amount){
        if(amount<=balance){
            balance-=amount;
            System.out.println(holder+"Withdrawal Successfull \n remaining balance"+balance);
        }
        else System.out.println(holder+"Insuffiecinet balance");
    }
    void getStatement(){
        System.out.println("\n----- ACCOUNT STATEMENT -----");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Holder Name    : " + holder);
        System.out.println("Balance        : ₹" + balance);
    }
    public static int getTotalAccounts() {
        return totalAccount;
    }
    public static void main(String[] args) {

        // Create 3 Accounts
        BankAccount acc1 = new BankAccount("101", "Faizan", 5000);
        BankAccount acc2 = new BankAccount("102", "Aadi", 8000);
        BankAccount acc3 = new BankAccount("103", "Rahul", 10000);

        // ===== Account 1 : 5 Transactions =====
        acc1.deposit(1000);
        acc1.withdraw(500);
        acc1.deposit(2000);
        acc1.withdraw(1000);
        acc1.deposit(300);

        // ===== Account 2 : 5 Transactions =====
        acc2.deposit(500);
        acc2.withdraw(100);
        acc2.deposit(700);
        acc2.withdraw(200);
        acc2.deposit(400);

        // ===== Account 3 : 5 Transactions =====
        acc3.deposit(300);
        acc3.withdraw(100);
        acc3.deposit(800);
        acc3.withdraw(200);
        acc3.deposit(1000);

        // Print Statements
        acc1.getStatement();
        acc2.getStatement();
        acc3.getStatement();

        // Total Accounts Created
        System.out.println("\nTotal Accounts Created: "
                + BankAccount.getTotalAccounts());
    }
}