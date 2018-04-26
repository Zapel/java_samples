package Thread.total;

public class Main {
    static SomeThing mThing;

    public static void main(String[] args) {
        mThing = new SomeThing();

        Thread myThready = new Thread(mThing);
        myThready.start();
        System.out.println("First Thread stop.");
    }
}

class SomeThing implements Runnable {
    @Override
    public void run() {
        System.out.println("Second Thread.");
    }
}