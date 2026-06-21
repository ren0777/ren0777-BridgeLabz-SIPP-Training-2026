// Write a program to input the Principal, Rate, and Time values and calculate Simple Interest.
// Hint =&gt;
// a. Simple Interest = Principal * Rate * Time / 100
// b. Take user input for principal, rate, time
// c. Write a method to calculate the simple interest given principle, rate and time as
// parameters
// d. Output “The Simple Interest is ___ for Principal ___, Rate of Interest ___ and Time ___”t

import java.util.Scanner;
class Simple_interest{
    double calculateSimpleinterest(double principal,double rate,double time){
        return (principal*rate*time)/100;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double p=sc.nextDouble();
        double r=sc.nextDouble();
        double t=sc.nextDouble();
        Simple_interest si=new Simple_interest();
        double interest=si.calculateSimpleinterest(p,r,t);
        System.out.println("The Simple Interest is "+interest+" for Principal "+p+", Rate of Interest "+r+" and Time "+t);
    }
}