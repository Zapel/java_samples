package Thread.lesson85;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Run());
        new Sportsman(cyclicBarrier);
        new Sportsman(cyclicBarrier);
        new Sportsman(cyclicBarrier);
    }

    static class Run  extends Thread {
        @Override
        public void run() {
            System.out.println("Run is began.");
        }
    }

    static class Sportsman extends Thread {
        CyclicBarrier barrier;

        public Sportsman(CyclicBarrier barrier) {
            this.barrier = barrier;
            start();
        }

        @Override
        public void run() {
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
