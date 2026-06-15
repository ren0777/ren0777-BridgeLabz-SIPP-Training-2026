import java.util.*;

class SumOfNo {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter your no :- ");
      int no = sc.nextInt();

      double sum = 0;

      int i = no;

      while(no != 0){
        sum += no;
        
        System.out.print("enter no again :- ");
        no = sc.nextInt();
      }

      System.out.println(sum);


  }
}
