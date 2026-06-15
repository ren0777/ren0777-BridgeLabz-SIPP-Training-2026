class LargestNo {
  public static void main(String[] args) {
      
    int num1 = 60;
    int num2 = 70;
    int num3 = 80;

    if(num1 > num2 && num1 > num2){
      System.out.println("First no is largest : " + num1);
    }else if(num2 > num1 && num2 > num3){
      System.out.println("Second no is largest : " + num2);
    }else{
      System.out.println("Third no is largest : " + num3);
    }
  }
  
}
