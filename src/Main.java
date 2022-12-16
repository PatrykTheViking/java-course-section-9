import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

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

/*        System.out.println("How many integers would you like to enter to your array?\r");
        int number = scanner.nextInt();
        scanner.nextLine(); // next line to process enter key

        int[] array = getIntegers(number);
        System.out.println("You entered numbers: " + Arrays.toString(array));
        System.out.println("The smallest integer you entered is: " + findMin(array));

        reverse(array);
        System.out.println("Reversed array is: " + Arrays.toString(array));*/

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while(!quit){
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    processArrayList();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    public static void printInstructions(){
        System.out.println("\nPress ");
        System.out.println("\t 0 - to print choice options");
        System.out.println("\t 1 - to print the list of grocery items");
        System.out.println("\t 2 - to add an item to the list");
        System.out.println("\t 3 - to modify an item in the list");
        System.out.println("\t 4 - to remove an item from the list");
        System.out.println("\t 5 - to search an item in the list");
        System.out.println("\t 6 - to quit the application");
    }

    public static void addItem(){
        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem(){
        System.out.print("Please enter the grocery item to modify: ");
        String number = scanner.nextLine();
        System.out.println("Enter new item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(number, newItem);
    }

    public static void removeItem(){
        System.out.print("Please enter the grocery item name to remove: ");
        String number = scanner.nextLine();
        scanner.nextLine();
        groceryList.removeGroceryItem(number);
    }

    public static void searchForItem(){
        System.out.println("Item to search for: ");
        String searchItem = scanner.nextLine();
        if(groceryList.onFile(searchItem)){
            System.out.println("Found " + searchItem + " in our grocery list");
        } else {
            System.out.println(searchItem + " is not in our shopping list");
        }
    }

    public static void processArrayList(){
        ArrayList<String> newArray = new ArrayList<>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<>(groceryList.getGroceryList());

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);

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

    public static void resize(int[] array){

        int[] original = array;
        array = new int[10]; // resize array to 10 slots

        for(int i =0;i< original.length; i++){
            array[i] = original[i];
        }
    }

}

