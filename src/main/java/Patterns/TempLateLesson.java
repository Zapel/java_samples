package Patterns;

public class TempLateLesson {
    public static void main(String[] args) {
        Template template = new Job ();
        template.run ();
    }
}

abstract class Template {
    abstract void stepOne();
    abstract void stepTwo();
    abstract void stepThree();

    void run() {
        stepOne ();
        stepTwo ();
        stepThree ();
    }
}

class Job extends Template {
    @Override
    void stepOne() {
        System.out.println ("first step");
    }

    @Override
    void stepTwo() {
        System.out.println ("second step");
    }

    @Override
    void stepThree() {
        System.out.println ("third step");
    }
}
