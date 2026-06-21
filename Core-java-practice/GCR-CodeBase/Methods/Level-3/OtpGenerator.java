import java.util.Arrays;

public class OtpGenerator {

    public static int generateOtp() {
        return 100000 + (int) (Math.random() * 900000);
    }

    public static boolean areUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOtp();
        }

        System.out.println("OTP values: " + Arrays.toString(otps));
        System.out.println("All OTPs unique: " + areUnique(otps));
    }
}