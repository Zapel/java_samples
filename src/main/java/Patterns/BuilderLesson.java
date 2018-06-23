package Patterns;

public class BuilderLesson {
    public static void main(String[] args) {
        SportCar sportCar = SportCar.

    }
}

class SportCar {
    private String name;
    private String color = "black";
    private int maxSpeed = 200;

    public String getName() {
        return name;
    }
    /*
    public String getColor() {
        return color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public SportCar(String name) {
        this.name = name
    }

    public SportCar(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public SportCar(String name, String color, int maxSpeed) {
        this.name = name;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
    */

    private SportCar(Builder builder) {
        this.name = builder.name;
        this.color = builder.color;
        this.maxSpeed = builder.maxSpeed;

    }

    static class Builder {
        private String name;
        private String color;
        private int maxSpeed;

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