package Thread.lesson84;

import java.util.concurrent.Exchanger;

public class Sem {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Zapel(exchanger);
        new Form(exchanger);
    }

    static class Zapel extends Thread {
        Exchanger<String> exchanger;

        public Zapel(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                exchanger.exchange("Hi my name is Zapel.");
                exchanger.exchange("I am 39 years old.");
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Form extends Thread {
        Exchanger<String> exchanger;

        public Form(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
            start();
        }

        @Override
        public void run() {
            try {
                System.out.println(exchanger.exchange(null));
                System.out.println(exchanger.exchange(null));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
