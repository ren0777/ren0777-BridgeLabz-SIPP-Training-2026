import java.util.*;

class NegativeNo {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter your no :- ");
      int no = sc.nextInt();

      double sum = 0;

      int i = no;

      while(i != 0){
        if(no <= 0){
          break;
        }else{
          sum += no;

          System.out.print("Enter your no :- ");
          no = sc.nextInt();



      }
      }

      System.out.println("Total is :- " + sum);
  }
}
