import java.util.*;
public class InputMisMatch
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        try
        {
            int t=sc.nextInt();
            int z=100/t;
            System.out.println(z);
        }
        catch(ArithmeticException e)
        {
            System.out.println("cannot divide by zero");
        }
        catch(InputMismatchException e)
        {
            System.out.println("invalid input ");
        }

    }
}