import java.util.*;

class NaturalNo {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      int sum = 0;

      if(n >= 0){
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println("The sum of " + n + " natural no is : " + sum);
      }else{
        System.out.println("the no " + n + "is not nautal no");
      }


  }
}
