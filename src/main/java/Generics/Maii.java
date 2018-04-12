package Generics;

import java.io.Serializable;

class Bus extends Main implements Comparable, Serializable {
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class Main <T extends Main & Comparable & Serializable>{
    T var;
    public static void main(String[] args) {
        Main main = new Main();
        main.var = new Bus();
        System.out.println(main.var);
        System.out.println();
        main.method(new Bus());
    }

    T method (T type) {
        type.someMethod();
        return type;
    }

    void someMethod() {
        System.out.println("bla");
    }
}
