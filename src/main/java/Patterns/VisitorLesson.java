package Patterns;

public class VisitorLesson {
    public static void main(String[] args) {
        AnimalVisitor animal = new Dog ();
        animal.doJob ( new ConcreteVisitor () );
    }
}

interface AnimalVisitor {
    void doJob(Visitor visitor);
}

class Dog implements AnimalVisitor {
    @Override
    public void doJob(Visitor visitor) {
        visitor.doDog ();
    }
}

class Cat implements AnimalVisitor {
    @Override
    public void doJob(Visitor visitor) {
        visitor.doCat ();
    }
}

interface Visitor {
    void doDog();
    void doCat();
}

class ConcreteVisitor implements Visitor{
    @Override
    public void doDog() {
        System.out.println ("dog");
    }

    @Override
    public void doCat() {
        System.out.println ("cat");
    }
}

