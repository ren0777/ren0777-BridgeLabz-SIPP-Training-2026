public class Bonus{
  public static void main(String[] args) {
      String name = "Ravi";
      int age = 20;
      char rank = 'A';
      double salary = 50000;
      float fees = 1000.5f;


      double bonus = salary * 0.12;

      double annualfess = (int)(bonus);

      System.out.println("    Welcome Card      ");
      System.out.println("Name            : " + name);
      System.out.println("Age             : " + age);
      System.out.println("Rank            : " + rank);
      System.out.println("Salary          : " + salary);
      System.out.println("fees            : " + fees);
      System.out.println("Annual Fees     : " + annualfess);
      


  }
}