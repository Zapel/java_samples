package Generics;

public class Main {
    @Override
    public String toString() {
        return "Main{}";
    }

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.<String>method("test");
        main.<Integer>method(123);
        main.methodOne(456);
        main.methodTwo("TEST");
        main.method(new Main());
    }

    <T> T method(T type) {
        System.out.println(type);
        return type;
    }

    <T> void methodOne(T type) {
        System.out.println(type);
    }

    <T> T methodTwo(T type) {
        System.out.println(type);
        return type;
    }

}
