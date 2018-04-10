package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Book {
    String nameAuthor;

    public Book(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "nameAuthor='" + nameAuthor + '\'' +
                '}';
    }
}

public class MapMain {
    public static void main(String[] args) {
        Map collection = new HashMap();
        collection.put("1", "Dan Brown");
        collection.put("2", new Book("Carnegie"));
        collection.put("3", "Jack London");

        //System.out.println(collection.get("2"));

        Set set = collection.entrySet();
        for (Object o : set) {
            System.out.println(o);
        }

        System.out.println();

        Set keySet = collection.keySet();
        for (Object o : keySet) {
            System.out.println(o);
        }
    }
}
