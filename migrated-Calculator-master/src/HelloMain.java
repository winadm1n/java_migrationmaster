public class HelloMain {
    public static void main(String[] args) {
        // Call method to read input
        HelloData.readInput();

        // Call method to perform calculation
        HelloProcedure.calculate();

        // Call method to display result
        HelloProcedure.displayResult();

        // Call method to close the scanner
        HelloData.closeScanner();
    }
}
