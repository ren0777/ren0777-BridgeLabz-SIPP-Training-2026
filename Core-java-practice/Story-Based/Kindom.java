public class Kindom {
  public static void main(String[] args) {
      
    int[] arr = {10000 , 20000, 65000, 45000, 90000, 85000, 70000, 6000, 57000, 30500};
    int sum = 0;
    int[] nums = new int[10];

    for(int i = 0; i< arr.length; i++){
      if(arr[i] < 10000 ){
        sum = arr[i] + ((arr[i] * 5) / 100);
        nums[i] = sum;

      }else if (arr[i] >= 10000 || arr[i] <= 50000) {
          sum = arr[i] + ((arr[i] * 15) / 100);
          nums[i] = sum;
      }else{
          sum = arr[i] + ((arr[i] * 50) / 100);
          nums[i] = sum;
      }
    }

    System.out.println("Ammonut ------------- Amount + Tax");
    for(int i = 0 ; i < arr.length ;i++){
      
      System.out.println(arr[i] + " -------------- > " + nums[i]);
    }
  }
}
