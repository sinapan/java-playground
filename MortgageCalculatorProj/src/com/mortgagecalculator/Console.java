package com.mortgagecalculator;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = new Scanner(System.in);

    public static double readNumber(String prompt){
        System.out.print(prompt);
        return scanner.nextDouble();
    }
    public static double readNumber(
            String prompt,
            double min,
            double max) {
        double value;
        while(true){
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (min <= value && value <= max)
                break;
            else
                System.out.println("Please enter a value above or equal to" + min + "and less than or equal to" + max);
        }
        return value;
    }
}
