package Map;

import java.util.*;

public class MapMain {
    public static void main(String[] args) {
        Map map = new HashMap();
        Map map2 = new Hashtable();
        Map map3 = new LinkedHashMap();
        Map map4 = new TreeMap();

        map3.put("1", "one");
        map3.put("3", "three");
        map3.put("2", "two");

        System.out.println(map3.get("3"));

        Set set = map3.entrySet();
        for(Object o : set) {
            System.out.println(o);
        }
    }
}
