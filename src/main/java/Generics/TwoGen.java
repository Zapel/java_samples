package Generics;

public class TwoGen<T, V> {
    T ob1;
    V ob2;

    TwoGen(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    T getob1() {
        return ob1;
    }

    V getob2() {
        return ob2;
    }

    void showTypes() {
        System.out.println("Type T: " + ob1.getClass().getName());
        System.out.println("Type V: " + ob2.getClass().getName());
    }

    public static void main(String[] args) {
        TwoGen<Integer, String> twogenObj= new TwoGen<>(77, "Text!");
        twogenObj.showTypes();

        int value = twogenObj.getob1();
        System.out.println("Value T: " + value);

        String str = twogenObj.getob2();
        System.out.println("Value V: " + str);
    }
}
