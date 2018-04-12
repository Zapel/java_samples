package Collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMainNew {
    public static void main(String[] args) {
        Set set = new HashSet();
        Set set1 = new LinkedHashSet();
        Set set2 = new TreeSet();

        set.add("1");
        set.add("2");
        set.add("2");
        set.add("1");
        set.add("1");

        for(Object o : set) {
            System.out.println(o);
        }
    }
}
