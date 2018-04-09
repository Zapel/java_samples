package Hash;

public class Main extends Object{
    int value;
    public static void main(String[] args) {
        Main main =new Main();
        main.value = 5;
        System.out.println(main.toString());
        System.out.println(main + "");
    }

    @Override
    public String toString(){
        return "value" + value;
    }
}
