package com.codersbay;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] numbers = new int[12];
        Random randomNumber = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = randomNumber.nextInt(1000000);
            // System.out.println(numbers[i]);
        }
        System.out.println("Divide and conquer");

        System.out.println("result " + divideAndConquer(numbers));


    }

    public static int divideAndConquer(int[] array) {

        if (array.length > 2) {
            System.out.println();
            int[] firstArray = new int[array.length / 2];
            int[] secondArray = new int[(array.length / 2) + 1];  //+1 -> for the odd case
            // even or odd query
            int modulo = array.length % 2;
            //System.out.println(modulo);
            if (modulo == 0) {
                for (int i = 0, j = array.length / 2; i < (array.length / 2); i++, j++) {
                    firstArray[i] = array[i];
                    secondArray[i] = array[j];
                }
            } else {
                for (int i = 0; i < (array.length / 2); i++) {
                    firstArray[i] = array[i];
                }
                for (int i = 0, j = array.length / 2; j < (array.length); i++, j++) {
                    secondArray[i] = array[j];
                }
            }

         /*   System.out.println("array.length " + array.length);
            System.out.println("array " + Arrays.toString(array));
            System.out.println("first " + Arrays.toString(firstArray));
            System.out.println("second " + Arrays.toString(secondArray));
            int firstMaximum = firstArray[0];

            for (int number : firstArray) {
                if (number > firstMaximum) {
                    firstMaximum = number;
                }
            }
            System.out.println("recursive firstmax " + firstMaximum);


            int secondMaximum = secondArray[0];

            for (int number2 : secondArray) {
                if (number2 > secondMaximum) {
                    secondMaximum = number2;
                }
            }
            System.out.println("recursive secondmax " + secondMaximum);*/

            divideAndConquer(firstArray);
            divideAndConquer(secondArray);

            //  int maximum = firstMaximum > secondMaximum ? firstMaximum : secondMaximum;

            // return 0;

            return maximum;

        } else if (array.length == 2) {
            System.out.println("else if " + (Math.max(array[0], array[1])));
            if (Math.max(array[0], array[1]) > maximum) {
                maximum = Math.max(array[0], array[1]);
            }

            return maximum;
        } else {
            System.out.println("else " + array[0]);
            if (array[0] > maximum) {
                maximum = array[0];
            }
            return maximum;
        }

    }

}
