public final class NumberChecker {

    private NumberChecker() {
    }

    public static int countDigits(int number) {
        number = Math.abs(number);
        if (number == 0) {
            return 1;
        }

        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static int[] getDigitsArray(int number) {
        number = Math.abs(number);
        int count = countDigits(number);
        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArmstrongNumber(int[] digits) {
        int power = digits.length;
        long sum = 0;
        for (int digit : digits) {
            sum += Math.round(Math.pow(digit, power));
        }

        long value = 0;
        for (int digit : digits) {
            value = value * 10 + digit;
        }
        return sum == value;
    }

    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }

        return new int[]{largest, secondLargest};
    }

    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }

        return new int[]{smallest, secondSmallest};
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquareOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += (int) Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return sum != 0 && number % sum == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[][] frequency = new int[10][2];
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
        }

        for (int digit : digits) {
            frequency[digit][1]++;
        }

        return frequency;
    }

    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean areEqual(int[] first, int[] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int[] digits) {
        return areEqual(digits, reverseDigits(digits));
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNeon(int number) {
        int square = number * number;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == number;
    }

    public static boolean isSpy(int[] digits) {
        int sum = 0;
        int product = 1;
        for (int digit : digits) {
            sum += digit;
            product *= digit;
        }
        return sum == product;
    }

    public static boolean isAutomorphic(int number) {
        long square = (long) number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    public static boolean isBuzz(int number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    public static boolean isPerfect(int number) {
        return sumOfProperDivisors(number) == number;
    }

    public static boolean isAbundant(int number) {
        return sumOfProperDivisors(number) > number;
    }

    public static boolean isDeficient(int number) {
        return sumOfProperDivisors(number) < number;
    }

    public static boolean isStrong(int number) {
        int[] digits = getDigitsArray(number);
        int sum = 0;
        for (int digit : digits) {
            sum += factorial(digit);
        }
        return sum == number;
    }

    private static int sumOfProperDivisors(int number) {
        if (number <= 1) {
            return 0;
        }

        int sum = 1;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                sum += i;
                int other = number / i;
                if (other != i) {
                    sum += other;
                }
            }
        }
        return sum;
    }

    private static int factorial(int number) {
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}