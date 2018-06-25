package Patterns;

public class BuilderLesson {
    public static void main(String[] args) {
        SportCar sportCar = new SportCar.Builder("Audi")
                //.setColor("red")
                //.setMaxSpeed(200)
                .build();
        System.out.println(sportCar.getName());
        System.out.println(sportCar.getColor());
        System.out.println(sportCar.getMaxSpeed());

        System.out.println();

        SportCar sportCarNew = new SportCar.Builder("BMW")
                .setColor("red")
                .setMaxSpeed(300)
                .build();
        System.out.println(sportCarNew.getName());
        System.out.println(sportCarNew.getColor());
        System.out.println(sportCarNew.getMaxSpeed());
    }
}

class SportCar {
    private String name;
    private String color;
    private int maxSpeed;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    private SportCar(Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.maxSpeed = builder.maxSpeed;
    }

    static class Builder {
        private String name;
        private String color = "black";
        private int maxSpeed = 200;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public SportCar build() {
            return new SportCar(this);
        }
    }
}