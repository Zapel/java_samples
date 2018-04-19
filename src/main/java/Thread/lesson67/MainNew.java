package Thread.lesson67;


public class MainNew {
    public static void main(String[] args) throws Exception {
        MyThreadNew myThreadNew = new MyThreadNew();

        myThreadNew.start();
        //Thread.sleep(100);
        Thread.yield();
        System.out.println("start - " + Thread.currentThread().getName());
    }
}

class MyThreadNew extends Thread {
    @Override
    public void run() {
        System.out.println("start - " + Thread.currentThread().getName());
    }
}
