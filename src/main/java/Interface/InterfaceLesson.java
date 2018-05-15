package Interface;

public class InterfaceLesson {
    public static void main(String[] args) {

    }
}

interface Rozetka {
    int getVotage();
}

interface Animal {
    class MyInnerClass {

    }

    interface MyInnerInterface {
        int i = 5;
        void eat();
    }

    enum E {

    }

    int i = 5;
    void eat();
}

interface Cat extends Animal {
    void move();
}

class Tiger implements Animal, Cat {

    @Override
    public void eat() {

    }

    @Override
    public void move() {

    }
}