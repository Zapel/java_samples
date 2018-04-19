package Thread.lesson69;

public class Main {
    public static void main(String[] args) throws Exception {
        Resource.i = 5;

        MyThread myThread = new MyThread();
        myThread.setName("one");
        MyThread myThread2 = new MyThread();
        myThread2.setName("two");

        myThread.start();
        myThread2.start();

        myThread.join();
        myThread2.join();

        System.out.println(Resource.i);
    }
}

class MyThread extends Thread {
    Resource resource;

    @Override
    public void run() {
        Resource.changeStaticI();
        new Resource().changeI();
    }
}

class Resource {
    static int i;

    public static void changeStaticI() {
        synchronized (Resource.class) {
            int i = Resource.i;
            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            i++;
            Resource.i = i;
        }
    }

    public void changeI() {
        synchronized (this) {
            int i = Resource.i;
            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            i++;
            Resource.i = i;
        }
    }
}
