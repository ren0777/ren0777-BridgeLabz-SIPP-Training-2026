import java.util.*;

class NaturalFor {
  public static void main(String[] args) {
    
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int sum = 0;

      boolean result = false;

      for(int i = 0 ; i <= n ; i++){
        sum += i;
      }

      int no = (n * (n + 1)) / 2;

      if(no == sum){
        result = true;
      }

      System.out.println(result);
  }
}
