import java.util.*;
public class CustomUncheckedException
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter an integer: ");
            int num = scanner.nextInt();

            // Check if the number is negative
            if (num < 0) {
                throw new NegativeNumberException("Negative numbers are not allowed.");
            }

            System.out.println("You entered: " + num);

        } catch (NegativeNumberException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}