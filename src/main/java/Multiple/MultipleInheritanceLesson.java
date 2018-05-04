package Multiple;

import java.io.Serializable;
import java.util.List;

public class MultipleInheritanceLesson {
    public static void main(String[] args) {
        MyNewCar myNewCar = new MyNewCar();
        myNewCar.drive();
    }
}

interface Car {
    default void drive() {
        System.out.println("Car drive");
    }
}

class Toyota implements Car {
    public void drive() {
        System.out.println("toyota drive");
    }
}

interface Motorcycle {
    void drive();
}

class Yamaha implements Motorcycle {
    public void drive() {
        System.out.println("yamaha drive");
    }
}

class MyNewCar implements Car, Motorcycle {
    public void drive() {
        System.out.println("MyNewCar drive");
    }
}
