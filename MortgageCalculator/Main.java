
// javac Main.java; java Mai
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static void main(String[] args) {
        float principle = (float)readNumber("Principle: ", 1000, 1_000_000);
        float annualInterest = (float)readNumber("Annual Interest Rate (percent): ", 0, 30);
        byte period = (byte)readNumber("Period (Years): ", 1, 30);

        printMortgage(principle, annualInterest, period);
        printPaymentSchedule(principle, annualInterest, period);
    }

    private static void printMortgage(float principle, float annualInterest, byte period) {
        double mortgage = calculateMortgage(principle, annualInterest, period);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.err.println("--------");
        System.out.println("Monthly Payments: ");
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(float principle, float annualInterest, byte period) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        double balance;
        for (short month = 1; month <= period * MONTHS_IN_YEAR; month++){
            balance = calculateBalance(principle, annualInterest, period, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double value;
        while(true){
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (min <= value && value <= max)
                break;
            else
                System.out.println("Please enter a value above or equal to" + min + "and less than or equal to" + max);
        }
        // scanner.close();
        return value;
    }

    public static double calculateBalance(
        float principle,
        float annualInterest,
        byte period,
        short numberOfPaymentsMade) {
            float monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_YEAR;
            short numberOfPayments = (short) (period * MONTHS_IN_YEAR);

            double balance = principle
                    * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                    / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

            return balance;
    }

    public static double calculateMortgage(
        float principle, float annualInterest, byte period) {
            float monthlyInterest = (annualInterest / PERCENT) / MONTHS_IN_YEAR;
            short numberOfPayments = (short) (period * MONTHS_IN_YEAR);
            double mortgage = principle
                * monthlyInterest
                * Math.pow((1+monthlyInterest), numberOfPayments)
                / (Math.pow((1+monthlyInterest), numberOfPayments) - 1);

            return mortgage;
    }
}
