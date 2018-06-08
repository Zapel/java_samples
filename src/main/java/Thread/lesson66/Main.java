package Thread.lesson66;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getName());
        //MyThread myThread = new MyThread();
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 1; i <5; i ++) {
            System.out.println("Thread name is - " + Thread.currentThread().getName() + " i = " + i);
        }
        //System.out.println(Thread.currentThread().getName());
        //System.out.println("this is new thread ");
        //someMethod();
    }

    /*
    private void someMethod() {
        throw new RuntimeException();
    }
     */
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

}