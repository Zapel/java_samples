package Thread.lesson71;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    //static int i;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        for(int j = 0; j < 10000; j ++) {
            new MyThread().start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(i);
        System.out.println(atomicInteger.get());
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            //i ++;
            atomicInteger.incrementAndGet();
        }
    }
}
