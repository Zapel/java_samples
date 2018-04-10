package Collections;

import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set collection = new HashSet();
        collection.add("1");
        collection.add("2");
        collection.add("2");
        collection.add("3");
        collection.add("3");
        collection.add("3");

        for(Object o : collection) {
            System.out.println(o);
        }
    }
}
