import java.util.*;
public class EvenSqSum {
    public static void main(String[] args) {
        List<Integer> l=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("enter element to list or enter -1 to exit");
            int n=sc.nextInt();
            if(n==-1) break;
            l.add(n);
        }
        long sum=l.stream().filter(n->n%2==0).mapToInt(n->n*n).sum();
        System.out.println("sum of the square of even number is :"+ sum);
    }
}
