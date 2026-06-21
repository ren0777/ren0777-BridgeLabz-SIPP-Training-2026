// Write a program to take 2 numbers and print their quotient and reminder
// Hint =&gt;
// a. Take user input as integer
// b. Use division operator (/) for quotient and moduli operator (%) for reminder
// c. Write Method to find the reminder and the quotient of a number
// public static int[] findRemainderAndQuotient(int number, int divisor)

import java.util.Scanner;
public class rem_qou {
    public static int[] findRemainderAndQuotient(int number, int divisor){
        int[] result = new int[2];
        result[0]=number/divisor;
        result[1]=number%divisor;
        return result;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int divisor=sc.nextInt();
            int [] result=findRemainderAndQuotient(number,divisor);
            System.out.println("Quotient: " + result[0]);
            System.out.println("Remainder: " + result[1]);
        }
    }