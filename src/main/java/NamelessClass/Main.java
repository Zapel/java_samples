package NamelessClass;

class Popcorn {
    void doSomething() {
        System.out.println("popcorn");
    }
    void secondMethod() {
        System.out.println("second");
    }
}

public class Main {
    public static void main(String[] args) {
        method(new Popcorn() {
            void doSomething() {
                System.out.println("bla");
            }
        });
        
        Popcorn popcorn = new Popcorn() {
            void doSomething() {
                System.out.println("main");
            }
        };
        popcorn.doSomething();
        popcorn.secondMethod();

        Comparable comparable= new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
        comparable.compareTo(new Object());
    }

    static void method(Popcorn popcorn){
        popcorn.doSomething();
    }
}
