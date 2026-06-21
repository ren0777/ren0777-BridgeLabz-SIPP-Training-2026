// public An athlete runs in a triangular park with sides provided as input by the user in meters. If the
// athlete wants to complete a 5 km run, then how many rounds must the athlete complete
// Hint =&gt;
// a. Take user input for 3 sides of a triangle
// b. The perimeter of a triangle is the addition of all sides and rounds is distance/perimeter
// c. Write a Method to compute the number of rounds user needs to do to complete 5km run {
    
// }

import java.util.Scanner;
class athelete{
    double calculateRounds(double a,double b,double c){
        double p=a+b+c;
        double distance=5000;
        return distance/p;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble();
        double b=sc.nextDouble();
        double c=sc.nextDouble();
        athelte at=new athelete();
        double rounds=at.calculateRounds(a,b,c);
        System.out.println("The athlete needs to complete "+rounds+" rounds to complete a 5 km run.");
    }
}