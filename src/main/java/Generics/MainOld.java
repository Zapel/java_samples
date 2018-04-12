package Generics;

class Car {
    @Override
    public String toString() {
        return "Car{}";
    }
}

class MainOld<T> {
    T var;

    @Override
    public String toString() {
        return "Main{}";
    }

    public static void main(String[] args) throws Exception {
        MainOld main = new MainOld();
        main.<String>method("test");
        main.<Integer>method(123);
        main.methodOne(456);
        main.methodTwo("TEST");
        main.method(new Main());

        MainOld<String> mainNew = new MainOld();
        mainNew.var = "Zapel";
        System.out.println("mainNew.var = " + mainNew.var);

        MainOld<Car> mainCar = new MainOld();
        mainCar.var = new Car();
        System.out.println("mainCar.var = " + mainCar.var);
    }

    <T> T method(T type) {
        System.out.println(type);
        return type;
    }

    <T> void methodOne(T type) {
        System.out.println(type);
    }

    T methodTwo(T type) {
        System.out.println(type);
        return type;
    }
}

