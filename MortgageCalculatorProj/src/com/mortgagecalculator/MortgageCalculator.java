package com.mortgagecalculator;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private float principle;
    private float annualInterest;
    private byte period;

    public MortgageCalculator(float principle, float annualInterest, byte period) {
        this.principle = principle;
        this.annualInterest = annualInterest;
        this.period = period;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();
        double balance = principle
                * (Math.pow(1 + monthlyInterest, numberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
        return balance;
    }

    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month-1] = calculateBalance(month);
        return balances;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();
        double mortgage = principle
                * monthlyInterest
                * Math.pow((1+monthlyInterest), numberOfPayments)
                / (Math.pow((1+monthlyInterest), numberOfPayments) - 1);
        return mortgage;
    }

    private float getMonthlyInterest() {
        return (annualInterest / PERCENT) / MONTHS_IN_YEAR;
    }

    private short getNumberOfPayments() {
        return (short) (period * MONTHS_IN_YEAR);
    }

    private short getPeriod() {
        return period;
    }
}
