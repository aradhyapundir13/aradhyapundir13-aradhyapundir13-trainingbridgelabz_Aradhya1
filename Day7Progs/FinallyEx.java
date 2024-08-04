import java.util.*;
public class FinallyEx
{
    public static void main(String[] args) throws ArithmeticException {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter an integer: ");
            int num = scanner.nextInt();
            int result = 100 / num;
            System.out.println("Result: " + result);
        } finally {
            System.out.println("Division operation is complete.");
            scanner.close();
        }
    }
}