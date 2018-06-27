package Patterns;

public class AdapterLesson {
    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        //carWash.washCar(new Honda());
        carWash.washCar(new TrackWrap(new MyTrack()));
    }
}

interface CarAd {
    void wash();
}

class CarWash {
    public void washCar(CarAd car) {
        car.wash();
    }
}

class Honda implements CarAd {
    @Override
    public void wash() {
        System.out.println("Wash car.");
    }
}

interface Track {
    void clean();
}

class MyTrack implements Track {
    @Override
    public void clean() {
        System.out.println("Track is cleaned.");
    }
}

class TrackWrap implements CarAd {
    Track track;

    public TrackWrap(Track track) {
        this.track = track;
    }

    @Override
    public void wash() {
        track.clean();
    }
}