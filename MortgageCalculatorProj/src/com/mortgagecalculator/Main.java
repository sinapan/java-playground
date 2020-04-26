package com.mortgagecalculator;

// to execute from command-line: javac Main.java; java Mai

public class Main {
    public static void main(String[] args) {
        float principle = (float) Console.readNumber("Principle: ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate (percent): ", 0, 30);
        byte period = (byte) Console.readNumber("Period (Years): ", 1, 30);
        var calculator = new MortgageCalculator(principle, annualInterest, period);
        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}

