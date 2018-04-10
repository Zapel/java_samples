package Collections;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueMain {
    public static void main(String[] args) {
        Queue collection = new PriorityQueue();
        collection.offer("1");
        collection.offer("2");
        collection.offer("3");

        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(collection.poll());
            //System.out.println(iterator.next());
        }
        System.out.println("mun of elements " + collection.size());

        /*
        for (int i = 0; i < collection.size(); i++) {
            System.out.println(collection.peek());
        }
        System.out.println(collection.size());

        for (int i = 0; i <= collection.size(); i++) {
            System.out.println(collection.poll());
        }
        System.out.println(collection.size());
        */
    }
}
