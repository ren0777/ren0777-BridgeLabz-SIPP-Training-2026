// Write a program SpringSeason that takes two int values month and day from the command
// line and prints “Its a Spring Season” otherwise prints “Not a Spring Season”.
// Hint =&gt; Spring Season is from March 20 to June 20. Write a Method to check for Spring
// season and return a boolean true or false


public class SpringSeason {
    boolean isSpringSeason(int month,int day){
        if((month==3 && day>=20) || (month==6 && day<=20) || (month>3 && month<6)){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        SpringSeason ss=new SpringSeason();
        int month=4;
        int day=15;
        boolean result = ss.isSpringSeason(month,day);
        if(result){
            System.out.println("Its a Spring Season");
        }
        else{
            System.out.println("Not a Spring Season");
        }
    }
    
}
