package Thread.total;

public class Program {
    public static void main(String[] args) {
        Thread myThready = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Second Thread.");
            }
        });
        myThready.start();
        System.out.println("First Thread stop.");
    }
}
