import java.util.Random;
import java.util.Scanner;
public class NumberGame{
public static void main(String[]args){
Scanner scanner=new Scanner(System.in);
Random random=new Random();
boolean playagain=true;
while(playagain){
int numbertoguess=random.nextInt(100)+1;
int numberofattempts=0;
int maxattempts=10;
boolean guessedcorrectly=false;
System.out.println("Welcome to the number Game");
System.out.println("I have picked a number between 1 and 100.Try to guess it!");
System.out.println("you have a maximum of "+maxattempts+" attempts.");
while(!guessedcorrectly && numberofattempts < maxattempts){
System.out.print("Enter your guess:");
int userguess=scanner.nextInt();
numberofattempts++;
if(userguess<numbertoguess){
System.out.println("too low!");
}else if(userguess>numbertoguess){
System.out.println("too high!");}
else{
System.out.println("Congragulations! you guessed the correct number in "+numberofattempts+" attempts");
guessedcorrectly=true;
}}
if(!guessedcorrectly){
System.out.println("Sorry,you have used all your attempts.the correct number was"+numbertoguess);
}
int score=calculatescore(numberofattempts,guessedcorrectly,maxattempts);
System.out.println("Your score for this round: "+score);
System.out.print("Do you want to play again.(yes/no): ");
String userresponse=scanner.next();
playagain=userresponse.equalsIgnoreCase("yes");}
System.out.println("Thanks for playing the number game!");
scanner.close();
}
private static int calculatescore(int attempts,boolean guessedcorrectly,int maxattempts){
if(!guessedcorrectly){
return 0;}
return (maxattempts-attempts+1)*10;
}}