public class StudentDiscount {
  public static void main(String[] args) {
      int fees = 125000;

      double discount = fees / 10;

      double discountamount = fees - discount;

      System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR ___\n" + discountamount);
  }
}
