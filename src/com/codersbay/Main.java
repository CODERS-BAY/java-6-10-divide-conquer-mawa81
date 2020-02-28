package com.codersbay;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] numbers = new int[60];
        Random randomNumber = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = randomNumber.nextInt(1000000);
            // System.out.println(numbers[i]);
        }
        System.out.println("Divide and conquer");

        System.out.println(divideAndConquer(numbers));


    }

    private static int divideAndConquer(int[] array) {

        if (array.length > 2) {
            System.out.println();
            int[] firstArray = new int[array.length / 2];
            int[] secondArray = new int[array.length / 2];
            for (int i = 0, j = array.length / 2; i < (array.length / 2); i++, j++) {
                firstArray[i] = array[i];
                secondArray[i] = array[j];
            }

            System.out.println("array.length " + array.length);
            System.out.println("array " + Arrays.toString(array));
            System.out.println("first " + Arrays.toString(firstArray));
            System.out.println("second " + Arrays.toString(secondArray));
            int firstMaximum = firstArray[0];

            for (int number : firstArray) {
                if (number > firstMaximum) {
                    firstMaximum = number;
                }
            }
            System.out.println("recursive fir " + firstMaximum);


            int secondMaximum = secondArray[0];

            for (int number2 : secondArray) {
                if (number2 > secondMaximum) {
                    secondMaximum = number2;
                }
            }
            System.out.println("recursive sec " + secondMaximum);

            divideAndConquer(firstArray);
            divideAndConquer(secondArray);

            return firstMaximum;
        } else {
            System.out.println("Array.length is lower than 2");
            return 0;
        }
    }

}
