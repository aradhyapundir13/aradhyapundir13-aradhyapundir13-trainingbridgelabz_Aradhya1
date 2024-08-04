package Day5Progs;

import java.util.*;
public class NonDuplicate {
    public static void main(String[] args)
    {
        LinkedHashSet<Integer> ln=new LinkedHashSet<>();
        Scanner am=new Scanner(System.in);
        System.out.println("enter the size of the array :");
        int n=am.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=am.nextInt();
        for(int j: arr)
        {
            if(ln.contains(j)) ln.remove(j);
            else ln.add(j);
        }
        for(int j :ln)
        {
            System.out.println(j);
            return;
        }
        System.out.println(-1);
    }
}