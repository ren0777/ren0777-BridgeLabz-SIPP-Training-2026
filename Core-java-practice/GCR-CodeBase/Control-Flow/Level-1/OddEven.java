import java.util.*;

class OddEven {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int no = sc.nextInt();

      for(int i = 0 ; i <= no ; i++){
        if(i % 2 == 0){
          System.out.println("This no is even :- " + i);
        }else{
          System.out.println("this no is odd :- " + i);
        }
      }


  }
}
