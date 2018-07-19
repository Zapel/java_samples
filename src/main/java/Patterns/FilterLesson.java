package Patterns;

import java.util.ArrayList;
import java.util.List;

public class FilterLesson {
    public static void main(String[] args) {
        CarF carF = new CarF ( 200, 4, "green");
        CarF carF1 = new CarF ( 150, 4, "black");
        CarF carF2 = new CarF ( 300, 2, "red");

        List<CarF> cars = new ArrayList<>();

        cars.add(carF);
        cars.add(carF1);
        cars.add(carF2);

        //ars = new SpeedFilter().filter(cars);
        //cars = new DoorsFilter().filter(cars);

        //AndFilter andFilter = new AndFilter ( new SpeedFilter(), new DoorsFilter());
        //cars = andFilter.filter(cars);

        OrFilter orFilter = new OrFilter ( new SpeedFilter(), new DoorsFilter());
        cars = orFilter.filter(cars);

        for (CarF car : cars) {
            System.out.println (car.getMaxSpeed ());
        }
    }
}

interface CarFilter {
    List<CarF> filter (List<CarF> cars);
}

class SpeedFilter implements CarFilter {
    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = new ArrayList<>();

        for (CarF car : cars ) {
            if (car.getMaxSpeed() > 180) {
                list.add(car);
            }
        }
        return list;
    }
}

class DoorsFilter implements CarFilter {
    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = new ArrayList<>();

        for (CarF car : cars ) {
            if (car.getDoors () > 2) {
                list.add(car);
            }
        }
        return list;
    }
}

class AndFilter implements CarFilter {
    CarFilter filterOne;
    CarFilter filterTwo;

    public AndFilter(CarFilter filterOne, CarFilter filterTwo) {
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = filterOne.filter(cars);
        return filterTwo.filter(list);
    }
}

class OrFilter implements CarFilter {
    CarFilter filterOne;
    CarFilter filterTwo;

    public OrFilter(CarFilter filterOne, CarFilter filterTwo) {
        this.filterOne = filterOne;
        this.filterTwo = filterTwo;
    }

    @Override
    public List<CarF> filter(List<CarF> cars) {
        List<CarF> list = filterOne.filter(cars);
        List<CarF> list2 = filterOne.filter(cars);
        for (CarF car : list2) {
            if(!list.contains(car)) {
                list.add (car);
            }
        }
        return list;
    }
}


class CarF {
    private int maxSpeed;
    private int doors;
    private String color;

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CarF(int maxSpeed, int doors, String color) {
        this.maxSpeed = maxSpeed;
        this.doors = doors;
        this.color = color;
    }
}
