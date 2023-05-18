package ua.sida.javalabs;

import java.util.Scanner;

/**
 * Utility class to work with matrix developed
 * for lab work 2 for Java course
 */
public class MatrixUtility {

    /*
    Сканер для отримання даних, введених користувачем
    */
    private static final Scanner SCANNER = new Scanner(System.in);

    /*
    Матриця та її розміри
    */
    private static int[][] matrix;
    private static int rows = 0;
    private static int columns = 0;

    /*
    Границі для діапазону рандомних чисел
    */
    private static final int UPPER_BOUND = 50;
    private static final int LOWER_BOUND = 1;

    public static void main(String[] args) {
        System.out.println("\nHello in App to work with matrix.\n" +
                "This App was developed for lab work 2 for Java course\n" +
                "by Yulia Sida, student of 121-20-2");

        int customChose;

        do {
            printMainMenu(); // виводимо головне меню
            customChose = SCANNER.nextInt(); // отримуємо вибір користувача

            switch (customChose) {
                case 0 -> exit(); // говоримо "до побачення" :)
                case 1 -> randomMatrix();
                case 2 -> customMatrix();
                default -> System.out.println("There is no such option. Please try again");
            }

            if (customChose < 3 && customChose != 0) {
                int secondCustomChose;
                do {
                    printMatrixMenu();
                    secondCustomChose = SCANNER.nextInt();

                    switch (secondCustomChose) {
                        case 0 -> System.out.println("Back to main Menu");
                        case 1 -> findMin();
                        case 2 -> findMax();
                        case 3 -> findArithmeticMean();
                        case 4 -> findGeometricMean();
                        default -> System.out.println("There is no such option. Please try again.");
                    }
                } while (secondCustomChose != 0);
            }
        } while (customChose != 0);
    }

    /**
     * Метод, який виводить головне меню
     */
    public static void printMainMenu() {
        System.out.println("\nPlease choose option:\n" +
                "1. Create random matrix\n" +
                "2. Insert my custom matrix\n" +
                "0. Exit");
    }

    /**
     * Метод, який ініціалізує матрицю
     */
    private static void createMatrix() {
        System.out.println("Insert a number of rows for matrix (not more than 20):");
        rows = SCANNER.nextInt();
        System.out.println("Insert a number of columns for matrix (not more than 20):");
        columns = SCANNER.nextInt();

        if (rows > 20 || columns > 20) {
            System.out.println("We cannot use matrix with rows/columns with size bigger than 20.\n" +
                    "Insert new size.\n");
            createMatrix();
        } else {
            matrix = new int[rows][columns];
        }
    }

    /**
     * Метод, який створюю матрицю
     * та заповнює введеними числами
     */
    private static void customMatrix() {
        createMatrix();

        System.out.println("Insert next values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("[" + i + "][" + j + "]: ");
                matrix[i][j] = SCANNER.nextInt(); // заповнюємо матрицю випадковими числами
            }
            System.out.println();
        }

        System.out.println("Inserted matrix " + rows + "x" + columns + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Метод, який створюю матрицю
     * та заповнює її випадковими числами
     */
    private static void randomMatrix() {
        createMatrix();

        System.out.println("Generated matrix " + rows + "x" + columns + ":");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = (int) (Math.random() * UPPER_BOUND + LOWER_BOUND); // заповнюємо матрицю випадковими числами
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Метод, який виводить меню для роботи з матрицею
     */
    private static void printMatrixMenu() {
        System.out.println("\nPlease choose option:\n" +
                "1. Find min element\n" +
                "2. Find max element\n" +
                "3. Find arithmetic mean\n" +
                "4. Find geometric mean\n" +
                "0. Back");
    }

    /**
     * Метод, який знаходить та виводить у консоль
     * максимальний елемент матриці
     */
    private static void findMax() {
        int max = matrix[0][0];
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("The maximum element is matrix[" + maxRow + "][" + maxCol + "] = " + max);
    }

    /**
     * Метод, який знаходить та виводить у консоль
     * мінімальний елемент матриці
     */
    private static void findMin() {
        int min = matrix[0][0];
        int minRow = 0;
        int minCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }

        System.out.println("The minimum element is matrix[" + minRow + "][" + minCol + "] = " + min);
    }

    /**
     * Метод, який знаходить та виводить у консоль
     * геометричне середнє для матриці
     */
    private static void findGeometricMean() {
        double product = 1.0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                product *= matrix[i][j];
            }
        }

        double geometricMean = Math.pow(product, 1.0 / (rows * columns));
        System.out.println("The geometric mean of the matrix is " + geometricMean);
    }

    /**
     * Метод, який знаходить та виводить у консоль
     * середнє арифметичне для матриці
     */
    private static void findArithmeticMean() {
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += matrix[i][j];
            }
        }

        double arithmeticMean = sum * 1.0 / (rows * columns);
        System.out.println("The arithmetic mean of the matrix is " + arithmeticMean);
    }

    /**
     * Метод, який закінчує роботу з додатком
     */
    public static void exit() {
        System.out.println("\nBye! Thank you for using our app.\n");
    }
}
