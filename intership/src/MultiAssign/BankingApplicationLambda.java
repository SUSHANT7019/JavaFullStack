package MultiAssign;


public class BankingApplicationLambda {
 
	public static void main(String[] args) {
	BankAccount_UserOperation1 myAccount=new BankAccount_UserOperation1(1000);
	
	Runnable objDiposit=()->myAccount.deposit(500);
	Runnable objWithdraw=()->myAccount.withdraw(500);
	Runnable objCheck =()->myAccount.checkBalance();
	
	Thread t1 =new Thread(objDiposit,"DepositThread1");
	
	Thread t2 =new Thread(objWithdraw,"WithdrawThread1");
	
	Thread t3 =new Thread(objCheck,"BalanceThread1");
	t1.start();
	t2.start();
	t3.start();
	
	}
 
}//BankingApplication
 
class BankAccount_UserOperation1{
	private double balance;
 
	public BankAccount_UserOperation1(double initbalance) {
		this.balance = initbalance;
	}
	
	public synchronized void deposit(double amount) {
		System.out.println(Thread.currentThread().getName()+" Depositing "+amount);
		this.balance +=amount;
		System.out.println("Updated balance after Deposit : "+this.balance);
	}
	
	public synchronized void withdraw(double amount) {
		if(amount>this.balance) {
			System.out.println(Thread.currentThread().getName()+" Insufficient Balance... transaction failed");
		}
		else {
			System.out.println(Thread.currentThread().getName()+" Withdrawing Amount "+amount);
			this.balance -=amount;
			System.out.println("Updated balance after Withdraw : "+this.balance);
		}
	}
	
	public synchronized void checkBalance() {
		System.out.println(Thread.currentThread().getName()+"Checking balance : "+this.balance);
	}
	
}//BankAccount
 

 
 
 
 
 
 