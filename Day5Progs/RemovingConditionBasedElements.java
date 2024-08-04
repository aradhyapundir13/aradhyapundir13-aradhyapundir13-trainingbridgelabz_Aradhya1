package Day5Progs;

import java.util.*;

public class RemovingConditionBasedElements {
    public static void main(String args[])
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(9,5,37,8,11));
        TreeSet<Integer> treeSet= new TreeSet<>(list);
        int thresold =9;
        remove(treeSet,thresold);}
    private static void remove(TreeSet<Integer> treeSet, int thresold)
    {
        Iterator<Integer> it = treeSet.iterator();
        while(it.hasNext())
        {
            Integer present=it.next();
            if(present<thresold)
            {
                it.remove();
            }
            else
            {
                System.out.print(present+" ");
            }
        }
    }
}