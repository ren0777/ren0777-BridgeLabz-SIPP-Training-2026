import java.util.*;

public class StudentDisInput {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int fees = sc.nextInt();
      int discount = sc.nextInt();

      int discountAmount = fees / discount;

      int remaining = fees - discountAmount;

      System.out.println("The discount amount is INR " +discountAmount + " and final discounted fee is INR " + remaining);

  }
}
