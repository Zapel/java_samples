package Thread.lesson67;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Thread start - " + Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();
        //myThread.setPriority(Thread.MAX_PRIORITY);
        Thread.yield();
        //Thread.sleep(1000);
        //myThread.interrupt();
        //myThread.join();
        System.out.println("Thread finish - " + Thread.currentThread().getName());
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread start - " + Thread.currentThread().getName());
        for(int i = 0; i < 5; i ++) {
            /*
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            */
            System.out.println(Thread.currentThread().getName() + i);
        }
        System.out.println("Thread finish - " + Thread.currentThread().getName());
    }
}
