package polymorphism;

public class NormalCar extends Car {

    @Override
    protected double getSpeed() {
        return baseSpeed();
    }
}
