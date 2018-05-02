package Debugging;

public class Car {

    public int run(int speed, int accelerate) {
        return speed + accelerate;
    }

    public static void main(String[] args) {
        System.out.println(new Car().run(5,4));
    }
}
