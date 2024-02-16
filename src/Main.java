import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.NumberFormat;

public class Main {

    public static void main(String...args){

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        float annualInterestRate = 0;
        byte years = 0;
        Scanner scanner = new Scanner(System.in);

        // Error handling for principal input
        while(true) {
            System.out.println("Principal:");
            try {
                principal = scanner.nextInt();
                if(ErrorHandling.isValidPrincipal(principal))
                    break;
                System.out.println("Enter a value between 1000 and 1000000");
            } catch (InputMismatchException e) {
                System.err.println("Error: Please enter a valid integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        // Error handling for interest rate input
        while(true) {
            System.out.println("Annual Interest Rate:");
            try {
                annualInterestRate = scanner.nextFloat();
                if(ErrorHandling.isValidInterestRate(annualInterestRate))
                    break;
                System.out.println("Enter a value greater than 0 and less than or equal to 30");
            } catch (InputMismatchException e) {
                System.err.println("Error: Please enter a valid floating-point number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        float monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;

        // Error handling for years input
        while(true) {
            System.out.println("Period (Years):");
            try {
                years = scanner.nextByte();
                if(ErrorHandling.isValidYears(years))
                    break;
                System.out.println("Enter a value between 1 and 30");
            } catch (InputMismatchException e) {
                System.err.println("Error: Please enter a valid byte integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        int numberOfPayments = years * MONTHS_IN_YEAR;

        // Calculating mortgage
        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
