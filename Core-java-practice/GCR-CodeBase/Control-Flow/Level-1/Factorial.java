import java.util.*;

class Factorial {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int no = sc.nextInt();

      int sum = 1;

      int i = no;

      while(i > 0){
        sum = sum * i;
        i--;
      }

      System.out.println("Factorial is :- " + sum);
  }
}
