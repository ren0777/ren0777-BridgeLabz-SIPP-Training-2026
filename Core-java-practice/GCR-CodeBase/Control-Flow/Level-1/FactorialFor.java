import java.util.*;

class FactorialFor {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int no = sc.nextInt();

      int fact = 1;

      for(int i = no ; i > 0 ; i--){
        fact = fact * i;
      }

      System.out.println("Factorial is :- " + fact);

  }
}
