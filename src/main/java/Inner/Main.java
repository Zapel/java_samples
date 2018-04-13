package Inner;

public class Main {
    private int i = 5;
    static int q = 10;

    Inner inner3 = new Inner();

    static class StaticClass {
        static void method() {
            System.out.println(q);
        }
    }

    public static void main(String[] args) {
        StaticClass.method();
        Main main = new Main();
        main.method();
        Inner inner = main.new Inner();
        inner.method2();
    }

    void method() {
        class NewInner {
            void newMethod() {
                System.out.println("bla");
            }
        }
        NewInner newInner = new NewInner();
        newInner.newMethod();

        Inner inner = new Inner();
        inner.method2();
        System.out.println(inner.k);
        inner3.method2();
    }

    class Inner {
        private int k = 6;

        void method2() {
            System.out.println(i);
        }
    }
}

class Second {
    void method() {
        Main.Inner inner = new Main().new Inner();
        inner.method2();
    }
}
