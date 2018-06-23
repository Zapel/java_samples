package Patterns;

public class AbstractFactoryLesson {
    public static void main(String[] args) {
        Factory carFactory = new AbstractFactory().createFactory("Car");
        Factory tankFactory = new AbstractFactory().createFactory("Tank");

        Car toyota = carFactory.createCar("Toyota");
        Tank t51 = tankFactory.createTank("T51");

        toyota.drive();
        t51.drive();
    }
}

interface Car {
    void  drive();
}

class Toyota implements Car {
    @Override
    public void drive() {
        System.out.println("Drive Toyota");
    }
}

class Audi implements Car {
    @Override
    public void drive() {
        System.out.println("Drive Audi");
    }
}

class CarFactory implements Factory {
    public Car createCar(String typeOfCar) {
        switch (typeOfCar) {
            case "Toyota":
                return new Toyota();
            case "Audi":
                return new Audi();
            default:
                return null;
        }
    }
    @Override
    public Tank createTank(String typeOfTank) {
        return null;
    }
}

interface Tank {
    void  drive();
}

class T51 implements Tank {
    @Override
    public void drive() {
        System.out.println("Drive T51");
    }
}

class T52 implements Tank {
    @Override
    public void drive() {
        System.out.println("Drive T52");
    }
}

class TankFactory implements Factory{
    public Tank createTank(String typeOfTank) {
        switch (typeOfTank) {
            case "T51":
                return new T51();
            case "T52":
                return new T52();
            default:
                return null;
        }
    }
    @Override
    public Car createCar(String typeOfCar) {
        return null;
    }
}

interface Factory {
    Car createCar(String typeOfCar);
    Tank createTank(String typeOfTank);
}

class AbstractFactory {
    Factory createFactory(String typeOfFactory) {
        switch (typeOfFactory) {
            case "Tank":
                return new TankFactory();
            case "Car":
                return new CarFactory();
            default:
                return null;
        }
    }
}
