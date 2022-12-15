import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

/*        int[] myIntArray = new int[25]; //{1,2,3,4,5,6,7,8,9,10};

        for (int i = 0; i < myIntArray.length; i++) {
            myIntArray[i] = i * 10;
        }

        int[] myIntegers = getIntegers(5);

        printArray(myIntegers);

        System.out.println("The average is " + getAverage(myIntegers));*/

/*        int[] myIntegers = getIntegers(5);
        System.out.println("-".repeat(30));

        *//*printArray(myIntegers);*//*
        System.out.println("My array contains: " + Arrays.toString(myIntegers));
        int[] sorted = sortIntegers(myIntegers);

        System.out.println("-".repeat(30));
        *//*printArray(sorted);*//*
        System.out.println("My sorted array contains: " + Arrays.toString(sorted));*/

        System.out.println("How many integers would you like to enter to your array?\r");
        int number = scanner.nextInt();
        scanner.nextLine(); // next line to process enter key

        int[] array = getIntegers(number);
        System.out.println("You entered numbers: " + Arrays.toString(array));
        System.out.println("The smallest integer you entered is: " + findMin(array));

        reverse(array);
        System.out.println("Reversed array is: " + Arrays.toString(array));

    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ", value is " + array[i]);
        }
    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static double getAverage(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (double) sum / (double) array.length;
    }

    public static int[] sortIntegers(int[] array){

/*        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
                sortedArray[i] = array[i];
            }*/

        int[] sortedArray = Arrays.copyOf(array, array.length);

        boolean flag = true;
        int tempNumber = 0;

        while(flag){
            flag = false;

            for(int i=0;i<sortedArray.length-1;i++){
                if(sortedArray[i] < sortedArray[i+1]){
                    tempNumber = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = tempNumber;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
    public static int findMin(int[] array){
        int[] sorted = sortIntegers(array);
        return sorted[sorted.length-1];
    }

    public static void reverse(int[] array){

         int maxIndex = array.length-1;
         int halfLength = array.length / 2;

         for(int i=0; i<halfLength; i++){

             int temp = array[i];
             array[i] = array[maxIndex-i];
             array[maxIndex-i] = temp;

         }
    }
}

