import java.util.Scanner;

public class HelloData1 {
    private static int num1 = 0;
    private static int num2 = 0;
    private static char operator;
    private static int result = 0;

    static Scanner scanner = new Scanner(System.in);

    public static void readInput() {
        // Prompt user for input
        System.out.print("Enter first number: ");
        num1 = scanner.nextInt();
        System.out.print("Enter operator (+, -, *, /): ");
        operator = scanner.next().charAt(0);
        System.out.print("Enter second number: ");
        num2 = scanner.nextInt();
    }

    public static int getNum1() {
        return num1;
    }

    public static int getNum2() {
        return num2;
    }

    public static char getOperator() {
        return operator;
    }

    public static void closeScanner() {
        // Close the scanner
        scanner.close();
    }
}
