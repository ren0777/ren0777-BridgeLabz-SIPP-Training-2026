// Create a program to find the maximum number of handshakes among students.
// Hint =&gt;
// a. Get integer input for the numberOfStudents variable.
// b. Use the combination = (n * (n - 1)) / 2 formula to calculate the maximum number of
// possible handshakes.
// c. Write a method to use the combination formulae to calculate the number of handshakes
// d. Display the number of possible handshakes.

public class handshakes {
    int calculateHandShakes(int n){
        return (n*(n-1))/2;
    }
    public static void main(String[] args){
        int n=5;
        handshakes h=new handshakes();
        int result=h.calculateHandShakes(n);
        System.out.println("The maximum number of handshakes is: " + result);
    }
}
