package Patterns;

public class SingeltonLesson {
    public static void main(String[] args) {
        Singelton singelton = Singelton.getInstsnce();
        Singelton singelton1 =Singelton.getInstsnce();

    }
}

class Singelton {
    int i =0;
    private Singelton() {
        System.out.println("Created Singelton!");
    }

    static Singelton singelton = new Singelton();

    public static Singelton getInstsnce() {
        return singelton;
    }
}
