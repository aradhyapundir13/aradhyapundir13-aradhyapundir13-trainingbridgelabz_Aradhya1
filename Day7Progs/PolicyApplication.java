
import java.util.*;
public class PolicyApplication
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the age :");
        int age = sc.nextInt();
        System.out.println("enter the driving history poor/good");
        String drive=sc.next();
        System.out.println("enter the health issues yes/no");
        String health=sc.next();
        try
        {
            if(age<18) throw new InvalidAgeException("age");
            if(drive.equals("poor")) throw new PoorDrivingException("poor");
            if(health.equals("yes")) throw new HealthIssueException("health");
        }
        catch(InvalidAgeException e)
        {
            System.out.println(e+ "under age");
        }
        catch(PoorDrivingException e)
        {
            System.out.println(e+ "poor driving skills");
        }
        catch(HealthIssueException e)
        {
            System.out.println(e+ "health isuues");
        }
    }
}