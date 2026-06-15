public class ProfitLoss {
  public static void main(String[] args) {
      int cost = 129;
      int sell = 191;

      int profit = sell - cost;

      double profPer = (profit * 100) / cost;

      System.out.println("The Cost Price is INR " + cost +  "and Selling Price is INR " + sell);
      System.out.println("The Profit is INR " + profit +" and the Profit Percentage is " + profPer);

  }
}
