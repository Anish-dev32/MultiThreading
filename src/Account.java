public class Account {
    private long accountNumber;
    private long Amount;

    public void setAccountNumber(long number){
        this.accountNumber = number;
    }
    public long getAccountNumber() {
        return accountNumber;
    }

    public void deposit(long amount){
        Amount += amount;
        System.out.println("Current balance is:"+Amount);
    }

    public void withdraw(long amount){
        if(this.Amount < amount){
            System.out.println("Not having sufficient balance");
        }else{
            Amount -= amount;
            System.out.println("remaining balance: "+Amount);
        }
    }

    public static void main(String[] args) { 
        Account acc = new Account();
        acc.setAccountNumber(1234);
        acc.withdraw(5000);
        acc.deposit(2500);
        acc.withdraw(500);
    }
}
