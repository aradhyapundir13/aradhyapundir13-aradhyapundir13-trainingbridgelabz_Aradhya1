import java.util.*;
import java.util.stream.Collectors;

public class filteringAList {
    public static void main(String[] args) {
        List<String> l=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("enter a String in the list : enter -1 to exit" );
            String c1=sc.next();
            if(c1.equals("-1")) break;
            l.add(c1);
        }
        List<String> l2=l.stream().filter(c->(c.charAt(0)=='A')).collect(Collectors.toList());
        for(String s: l2) System.out.print(s+" ");
    }
}