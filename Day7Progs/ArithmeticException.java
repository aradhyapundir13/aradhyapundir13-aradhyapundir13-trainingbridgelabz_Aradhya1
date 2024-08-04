import java.util.*;
public class ArithmeticException  {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int z=sc.nextInt();
        try{
            int k=100/z;
            System.out.println(k);
        }
        catch(Exception e)
        {
            System.out.println("we can't divide zero");
        }
    }
}