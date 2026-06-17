class MathClass{
    int instanceVariable=100;

    boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    int factorial(int n){
        if(n<0){
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
    double factorial(double n){
        if(n<0){
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);

    }
    int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }
    long power(long base,long exp){
        if(exp<0){
            return 1/power(base,-exp);
        }
        long result=1;
        for(int i=0;i<exp;i++){
            result*=base;
        }
        return result;
    }
    void showScope(){
        int localVar=50;
        System.out.println("Local Variable: "+localVar);
        System.out.println("Instance Variable: "+instanceVariable);
    }

}
public class MathWizard {
    public static void main(String[] args) {
        MathClass math=new MathClass();
        System.out.println("Is 7 prime? "+math.isPrime(7));
        System.out.println("Factorial of 5: "+math.factorial(5));
        System.out.println("Factorial of 5.0: "+math.factorial(5.0));
        System.out.println("GCD of 48 and 18: "+math.gcd(48,18));
        System.out.println("LCM of 48 and 18: "+math.lcm(48,18));
        System.out.println("2 raised to the power of 3: "+math.power(2,3));
        math.showScope();
    }
}