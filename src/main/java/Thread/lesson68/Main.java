package Thread.lesson68;

public class Main {
    public static void main(String[] args) throws Exception {
        Resource resource = new Resource();
        resource.setI(5);

        MyThread myThread = new MyThread();
        myThread.setName("one");
        MyThread myThread2 = new MyThread();
        myThread2.setName("two");

        myThread.setResource(resource);
        myThread2.setResource(resource);

        myThread.start();
        myThread2.start();

        myThread.join();
        myThread2.join();

        System.out.println(resource.getI());
    }
}

class MyThread extends Thread {
    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
        resource.changeINew();
    }
}

class Resource {
    private int i;

    public int getI() {
        return i;
    }

    public synchronized void setI(int i) {
        this.i = i;
    }

    public synchronized void changeI() {
        System.out.println(this.i);
        int i = this.i;
        if(Thread.currentThread().getName().equals("one")) {
            Thread.yield();
        }
        i ++;
        this.i = i;
    }

    public void changeINew() {
        System.out.println(this.i);
        synchronized (this) {
            int i = this.i;
            if (Thread.currentThread().getName().equals("one")) {
                Thread.yield();
            }
            i++;
            this.i = i;
        }
    }
}
