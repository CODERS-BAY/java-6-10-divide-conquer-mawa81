package com.codersbay;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] numbers = new int[21];
        Random randomNumber = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = randomNumber.nextInt(1000000);
            System.out.println(numbers[i]);
        }
        System.out.println("Divide and conquer!!!");
        System.out.println("maximum = " + divideAndConquer(numbers, 0));
    }

    public static int divideAndConquer(int[] array, int depth) {

        if (array.length > 2) {
            System.out.println("depth = " + depth + " " + "*".repeat(array.length * 20));
            System.out.println(Arrays.toString(array));
            // even or odd query
            int modulo = array.length % 2;
            int[] firstArray = new int[array.length / 2];
            int[] secondArray = new int[(array.length / 2)];  //-> for the even case

            //System.out.println(modulo);
            if (modulo == 0) {
                for (int i = 0, j = array.length / 2; i < (array.length / 2); i++, j++) {
                    firstArray[i] = array[i];
                    secondArray[i] = array[j];
                }
            } else {
                int[] temp = new int[(array.length / 2) + 1]; //+1 -> for the odd case
                secondArray = temp;
                for (int i = 0; i < (array.length / 2); i++) {
                    firstArray[i] = array[i];
                }
                for (int i = 0, j = array.length / 2; j < (array.length); i++, j++) {
                    secondArray[i] = array[j];
                }
            }
            System.out.print("\t".repeat(depth));
            System.out.println("first " + Arrays.toString(firstArray));
            int maxLeft = divideAndConquer(firstArray, depth + 1);
            System.out.print("\t".repeat(depth));
            System.out.println("second " + Arrays.toString(secondArray));
            int maxRight = divideAndConquer(secondArray, depth);

            return Math.max(maxLeft, maxRight);

        } else if (array.length == 2) {
            System.out.println("array.length == 2 " + (Math.max(array[0], array[1])));
            System.out.println();
            return Math.max(array[0], array[1]);
        } else if (array.length == 1) {
            System.out.println("array.length == 1 " + array[0]);
            System.out.println();
            return array[0];
        } else {
            throw new IllegalArgumentException("this is not a legal Argument");
        }

    }

}
