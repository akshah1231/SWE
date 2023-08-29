package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

public class SecondBiggestFinder {
    public static int findSecondBiggest(int[] numbers) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("Array must have at least two elements");
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }

        if (secondMax == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second biggest element found");
        }

        return secondMax;
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 3, 4, 5};
        int[] numbers2 = {19, 9, 11, 0, 12};

        System.out.println("Second biggest in numbers1: " + findSecondBiggest(numbers1));
        System.out.println("Second biggest in numbers2: " + findSecondBiggest(numbers2));
    }
}
