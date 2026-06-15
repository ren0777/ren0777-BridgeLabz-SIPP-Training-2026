import java.util.*;

public class YardDistance {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int feet = sc.nextInt();

      double yard = feet / 3;

      double mile = yard / 1760;

      System.out.println("Your Height in mile is " +mile + " while in feet is " + feet + " and yard is " + yard  + "\n");


  }
}
