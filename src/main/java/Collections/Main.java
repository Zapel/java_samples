package Collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[15];
        Collection collection = new ArrayList();
        List collection1 = new ArrayList();
        Set collection2 = new HashSet();
        Queue collection3 = new PriorityQueue();
        Map map = new HashMap();

        //Collections collections;
        //Arrays arrays;

        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.remove(2);

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        collection.add(2);

        for (Object o : collection) {
            System.out.println(o);
        }


    }
}
