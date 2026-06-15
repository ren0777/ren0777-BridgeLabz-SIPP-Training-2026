import java.util.*;
class Natural {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();

      int i = 0;

      int sum = 0;

      boolean result = false;

      if(n >= 0){
        while(i <= n){
          sum += i;
          i++;
        }
      }

      int no = (n * (n + 1)) / 2 ;

      if(no == sum){
        result = true;
      }

      System.out.println(result);


  }
}
