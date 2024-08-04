package Day5Progs;

import java.util.Set;
import java.util.TreeSet;

public class UnionAndDifferofCusotmObj {
    public static void main(String[] args) {
        Set<Person> set1 = new TreeSet<>();
        Set<Person> set2 = new TreeSet<>();
        set1.add(new Person("Aradhya", 30));
        set1.add(new Person("Ayushi", 25));
        set2.add(new Person("Yash", 25));
        set2.add(new Person("Anil", 35));
        System.out.println(set1);
        System.out.println(set2);
        Set<Person> union = findUnion(set1, set2);
        System.out.print("Union : ");
        System.out.println(union);
        Set<Person> difference = findDifference(set1, set2);
        System.out.println("Difference : ");
        System.out.println(difference);
    }

    static Set<Person> findUnion(Set<Person> set1, Set<Person> set2) {
        Set<Person> set = new TreeSet<>(set1);
        set.addAll(set2);
        return set;
    }
    static Set<Person> findDifference(Set<Person> set1, Set<Person> set2) {
        Set<Person> difference = new TreeSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }
}