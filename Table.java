import java.util.Random;
import java.util.Scanner;

public class Table {

    // Method to print the table
    public static int printTable(int[][] array, int highlight) {

        int size = array.length;
        int count = 0;

        // Print column numbers
        System.out.print("     ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%02d  ", i);
        }
        System.out.println();

        // Print top border
        System.out.print("   +");
        for (int i = 0; i < size; i++) {
            System.out.print("----+");
        }
        System.out.println();

        // Print rows
        for (int i = 0; i < size; i++) {

            System.out.printf("%02d |", i);

            for (int j = 0; j < size; j++) {

                if (array[i][j] == highlight) {
                    System.out.printf("[%2d]|", array[i][j]);
                    count++;
                } else {
                    System.out.printf(" %2d |", array[i][j]);
                }
            }

            System.out.println();

            System.out.print("   +");
            for (int j = 0; j < size; j++) {
                System.out.print("----+");
            }
            System.out.println();
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int size;

        // Input array size
        while (true) {
            System.out.print("Enter array size (for P×P array): ");

            if (sc.hasNextInt()) {
                size = sc.nextInt();

                if (size > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive integer.");
                }

            } else {
                System.out.println("Invalid input! Please enter an integer.");
                sc.next();
            }
        }

        // Create array
        int[][] array = new int[size][size];

        // Fill with random even numbers (2-16)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = (rand.nextInt(8) + 1) * 2;
            }
        }

        System.out.println("\nGenerated 2D array:");
        printTable(array, -1);

        int highlight;

        // Input number to highlight
        while (true) {

            System.out.print("\nEnter a number to highlight (even number 2-16): ");

            if (sc.hasNextInt()) {

                highlight = sc.nextInt();

                if (highlight >= 2 && highlight <= 16 && highlight % 2 == 0) {
                    break;
                } else {
                    System.out.println("Please enter an even number between 2 and 16.");
                }

            } else {
                System.out.println("Invalid input! Please enter an integer.");
                sc.next();
            }
        }

        System.out.println("\nArray with " + highlight + " highlighted:");

        int count = printTable(array, highlight);

        System.out.println("\nNumber " + highlight + " appeared " + count + " time(s).");

        sc.close();
    }
}