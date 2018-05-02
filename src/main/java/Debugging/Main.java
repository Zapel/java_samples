package Debugging;

import java.util.logging.Logger;

public class Main {
    private static final Logger log = Logger.getGlobal();

    public static void main(String[] args) throws Exception {
        int i = 5;
        System.out.println(i);
        System.out.println();
        log.info("info message");

        Car car = new Car();
        System.out.println(car.run(5,2));
    }
}
