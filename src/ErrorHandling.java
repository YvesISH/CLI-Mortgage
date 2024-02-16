public class ErrorHandling {

    public static boolean isValidPrincipal(int principal) {
        return principal > 1000 && principal <= 1_000_000;
    }

    public static boolean isValidInterestRate(float interestRate) {
        return interestRate > 0 && interestRate <= 30;
    }

    public static boolean isValidYears(byte years) {
        return years >= 1 && years <= 30;
    }
}
