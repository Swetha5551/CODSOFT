import java.util.Scanner;
class bankaccount{
private double balance;
public bankaccount(double initialbalance){
this.balance=initialbalance;}
public double getbalance(){
return balance;}
public void deposit(double amount){
if(amount>0){
balance+=amount;
System.out.println("Deposit successful.\nNew balance:"+balance);
}else{
System.out.println("invalid deposit amount");
}}
public void withdraw(double amount){
if(amount>0&&amount<=balance){
balance-=amount;
System.out.println("Withdrawal successful.\nNew balance: "+balance);}
else{
System.out.println("invalid withdrawal amount for insufficient balance");
}}}
class ATM{
private bankaccount account;
public ATM(bankaccount account){
this.account=account;
}
public void start(){
Scanner scanner=new Scanner(System.in);
while(true){
System.out.println("1.CHECK BALANCE 2.DEPOSIT 3.WITHDRAW 4.EXIT");
System.out.println("Choose an option:");
int choice=scanner.nextInt();
switch(choice){
case 1:
System.out.println("current balance:"+account.getbalance());
break;
case 2:
{System.out.println("enter the deposit amount: ");
account.deposit(scanner.nextDouble());
break;
}
case 3:
{System.out.println("enter the withdrawal amount :");
account.withdraw(scanner.nextDouble());
break;
}
case 4:
{
System.out.println("Exits");
return;

}
default:
System.out.println("invalid choice.Please try again");}}}

public static void main(String[]args){
bankaccount account=new bankaccount(1000.0);
ATM abc=new ATM(account);
abc.start();
}}