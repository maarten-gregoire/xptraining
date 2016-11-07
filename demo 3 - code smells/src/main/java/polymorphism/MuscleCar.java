package polymorphism;

public class MuscleCar extends Car {

    private double muscleFactor = 1.5;

    @Override
    protected double getSpeed() {
        return muscleFactor * baseSpeed();
    }
}
