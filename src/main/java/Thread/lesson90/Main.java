package Thread.lesson90;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Math.random());
        System.out.println(ThreadLocalRandom.current().nextInt());

        //Thread.sleep(1000);
        //Thread.sleep(TimeUnit.DAYS.toMillis(14));

        System.out.println(TimeUnit.DAYS.toMillis(14));
    }
}
