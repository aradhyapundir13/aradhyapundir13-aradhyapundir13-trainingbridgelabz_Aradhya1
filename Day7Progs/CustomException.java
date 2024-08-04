import java.util.*;
public class CustomException
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the age :");
        int t=sc.nextInt();
        try{
            if(t<18) throw new InvalidAgeException("something happend");
            else System.out.println("age is valid ");
        }
        catch(InvalidAgeException e)
        {
            System.out.println("age should be above 18");
        }
    }
}