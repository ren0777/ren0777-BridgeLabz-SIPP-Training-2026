// Create a program to divide N number of chocolates among M children. Print the number of
// chocolates each child will get and also the remaining chocolates
// Hint =&gt;
// a. Get an integer value from user for the numberOfchocolates and numberOfChildren.
// b. Write the method to find the number of chocolates each child gets and number of
// remaining chocolates
// public static int[] findRemainderAndQuotient(int number, int divisor)

public class chocolates {
    public static int[] findRemainderAndQuotient(int numberOfChocolates, int numberOfChildren){
        int[] result=new int[2];
        result[0]=numberOfChocolates/numberOfChildren;
        result[1]=numberOfChocolates%numberOfChildren;
        return result;
    }
    public static void main(String[] args){
        int numberOfChocolates=10;
        int numberOfChildren=3;
        int[] result=findRemainderAndQuotient(numberOfChocolates,numberOfChildren);
        System.out.println("Each child gets: " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);
    }
}
