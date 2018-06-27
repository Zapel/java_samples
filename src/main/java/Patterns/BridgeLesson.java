package Patterns;

public class BridgeLesson {
    public static void main(String[] args) {
        ICar car = new ToyotaCar(new CarBridge());
        car.drive();

    }
}

abstract class ICar {
    IBridge iBridge;

    public ICar(IBridge iBridge) {
        this.iBridge = iBridge;
    }

    public abstract void drive();
}

abstract class ITrack {
    IBridge iBridge;

    public ITrack(IBridge iBridge) {
        this.iBridge = iBridge;
    }

    public abstract void drive();
}

interface IBridge {
    void drive();
}

class CarBridge implements IBridge {
    @Override
    public void drive() {
        System.out.println("Drive Car.");
    }
}

class TrackBridge implements IBridge {
    @Override
    public void drive() {
        System.out.println("Drive Track.");
    }
}

class ToyotaCar extends ICar {
    public ToyotaCar(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("Drive Toyota.");
    }
}

class AudiCar extends ICar {
    public AudiCar(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("Drive Audi.");
    }
}




