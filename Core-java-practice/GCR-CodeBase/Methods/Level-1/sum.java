// Write a program to find the sum of n natural numbers using loop
// Hint =&gt; Get integer input from the user. Write a Method to find the sum of n natural numbers
// using loop
public class sum {
    int calculateSum(int n){
        int sum=0;
        for(int i=0;i<=n;i++){
            sum+=i;
        }
        return sum;
    }
    public static void main(String[] args){
        int n=5; // Example input
        sum obj = new sum();
        int result = obj.calculateSum(n);
        System.out.println("The sum of first " + n + " natural numbers is: " + result);
    }
    
}
