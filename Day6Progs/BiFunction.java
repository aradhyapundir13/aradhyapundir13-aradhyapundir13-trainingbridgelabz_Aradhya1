import java.util.Scanner;

public class BiFunction
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String str1 = sc.nextLine();
        System.out.println("Enter the second string: ");
        String str2 = sc.nextLine();

        java.util.function.BiFunction<String, String, String> concatenate = (s1, s2) -> s1 + " " + s2;
        String result = concatenate.apply(str1,str2);

        System.out.println("Concatenated string: " + result);

        sc.close();
    }
}