package Examples;

public class EnumSimple {
    enum CoffeeSize {SMALL(100), MEDIUM(200), BIG(300) {
        String getCoffeeClass() {
            return "B";
        }
    };
    String coffeeClass = "A";
    int coffeeSize;

        CoffeeSize(int coffeeSize){
            this.coffeeSize = coffeeSize;
        }

        int getCoffeeSize(){
            return coffeeSize;
        }

        String getCoffeeClass(){
            return coffeeClass;
        }
    }

    public static void main(String[] args) {
        CoffeeSize coffeeSize = CoffeeSize.SMALL;
        System.out.println(coffeeSize);
        System.out.println(coffeeSize.getCoffeeSize());
        System.out.println(coffeeSize.getCoffeeClass());
    }
}
