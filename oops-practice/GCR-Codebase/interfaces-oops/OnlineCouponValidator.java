interface CouponValidator {
    boolean validateCoupon(String code);

    static boolean isLengthValid(String code) {
        return code != null && code.length() >= 6 && code.length() <= 12;
    }
}

class ShoppingCart implements CouponValidator {

    private String[] validCoupons = {"SAVE20", "DISCOUNT50", "OFFER100", "FESTIVE30"};

    @Override
    public boolean validateCoupon(String code) {
        if (!CouponValidator.isLengthValid(code)) {
            return false;
        }
        for (String validCode : validCoupons) {
            if (validCode.equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
}

public class OnlineCouponValidator {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        String[] couponCodes = {"SAVE20", "ABC", "DISCOUNT50", "INVALID123", "OFFER100", "FESTIVE30", "XY", "NOCODE99"};

        System.out.println("--- Coupon Validation Results ---");
        for (String code : couponCodes) {
            if (!CouponValidator.isLengthValid(code)) {
                System.out.println("Coupon '" + code + "': INVALID (length out of range)");
            } else if (cart.validateCoupon(code)) {
                System.out.println("Coupon '" + code + "': VALID");
            } else {
                System.out.println("Coupon '" + code + "': INVALID (code not found)");
            }
        }
    }
}
