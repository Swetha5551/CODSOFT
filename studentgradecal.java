import java.util.Scanner;
class studentgradecal{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the number of subjects:");
int numberofsubjects=sc.nextInt();
int marks[]=new int[numberofsubjects];
System.out.println("Enter the marks obtained in each subjects (out of 100):");
System.out.println();
for(int i=0;i<numberofsubjects;i++){
System.out.println("Enter the mark for subject "+(i+1)+":");
marks[i]=sc.nextInt();}
int lengthofarray=marks.length;
int sum=0;
for(int i=0;i<=lengthofarray-1;i++){
sum=sum+marks[i];}
int average=sum/numberofsubjects;
char Grade;
if(average>=90){
Grade='S';}
else if( average>=80&&average<90){
Grade='A';}
else if(average>=70&&average<80){
Grade='B';}
else if(average>=60&&average<70){
Grade='C';}
else if(average>=50&&average<60){
Grade='D';}
else{
Grade='F';
}
System.out.println("Total is: "+sum);
System.out.println("Average percentage is: "+average+"%");
System.out.println("Grade is: "+Grade);
}}