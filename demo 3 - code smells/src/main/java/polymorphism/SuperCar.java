package polymorphism;

public class SuperCar extends Car {

    private double amountOfMoneySpent = 1000000;

    @Override
    protected double getSpeed() {
        return baseSpeed() * amountOfMoneySpent;
    }
}
