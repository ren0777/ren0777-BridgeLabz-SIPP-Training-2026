// Write a program to calculate various trigonometric functions using Math class given an angle
// in degrees
// Hint =&gt;
// a. Method to calculate various trigonometric functions, Firstly convert to radians and then
// use Math function to find sine, cosine and tangent.
// public double[] calculateTrigonometricFunctions(double angle)

import java.util.Scanner;
public class mathfunction {
    public double[] calculateTrigonometricFunctions(double angle){
        double[] result=new double[3];
        double radians=Math.toRadians(angle);
        result[0]=Math.sin(radians);
        result[1]=Math.cos(radians);
        result[2]=Math.tan(radians);
        return result;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double angle=sc.nextDouble();
        mathfunction mf=new mathfunction();
        double[] res=mf.calculateTrigonometricFunctions(angle);
        System.out.println("Sine: " + res[0]);
        System.out.println("Cosine: " + res[1]);
        System.out.println("Tangent: " + res[2]);
    }
}
