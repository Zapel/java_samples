package Overloading;

import java.io.IOException;

public class Main {
    /*
    private synchronized void method(String s) throws IOException {
        System.out.println("string");
    }

    void method(int i) throws RuntimeException{
        System.out.println("int");
    }
    */

    void method(Parent p) {
        System.out.println("parent");
    }

    void method(Child c) {
        System.out.println("child");
    }



    public static void main(String[] args) throws IOException {
        Main main = new Main();
        //main.method(5);
        //main.method("str");
        main.method(null);
    }
}

class Parent {

}

class Child extends Parent {

}