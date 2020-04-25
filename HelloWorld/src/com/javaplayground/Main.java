package com.javaplayground;

import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        byte age = 30;
        long viewsCount = 3_123_456_789L;
        float price = 10.99F;
        char letter = 'A';
        boolean isEligable = true;

        String message = " Hello World!";
        Date now = new Date();

        int[] numbers = { 3, 4, 2, 1, 5};
//        int[] numbers = new int[5];
//        numbers[0] = 1;
//        numbers[1] = 2;
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));

        double x = 1D / 2D;
        int y = (int)Math.round(0.5F);
        System.out.println(y);


    }
}
