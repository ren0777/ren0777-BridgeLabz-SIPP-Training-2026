// Write a program to find the smallest and the largest of the 3 numbers.
// Hint =&gt;
// a. Take user input for 3 numbers

// b. Write a single method to find the smallest and largest of the three numbers
// public static int[] findSmallestAndLargest(int number1, int number2, int number3)


public class sma_lar {
    public static int[] findSmallestAndLargest(int n1,int n2,int n3){
        int smallest=Math.min(n1,Math.min(n2,n3));
        int largest=Math.max(n1,Math.max(n2,n3));
        return new int[]{smallest,largest};
    }
    public static void main(String[] args){
        int n1=5,n2=10,n3=300; 
        int[] result=findSmallestAndLargest(n1,n2,n3);
        System.out.println("Smallest: " + result[0]);
        System.out.println("Largest: " + result[1]);
    }
}
