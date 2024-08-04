import java.util.function.Function;
import java.util.*;
public class Area {
    public static void main(String[] args) {
        Function<Double, Double> calculateArea = radius -> Math.PI * radius * radius;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the radius :");
        double radius =sc.nextDouble();
        double area = calculateArea.apply(radius);
        System.out.println("Area of the circle with radius " + radius + " is: " + area);
    }
}