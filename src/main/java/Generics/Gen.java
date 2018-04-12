package Generics;

public class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Type T: " + ob.getClass().getName());
    }

    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen<>(77);

        iOb.showType();
        int value = iOb.getOb();
        System.out.println("Value T: "+ value);

        System.out.println();

        Gen<String> strOb = new Gen<>("Text!!!");

        strOb.showType();
        String str = strOb.getOb();
        System.out.println("Value T: "+ str);
    }
}


