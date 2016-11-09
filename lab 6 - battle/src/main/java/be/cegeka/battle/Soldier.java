package be.cegeka.battle;

public class Soldier {

    private String name;
    private Weapon weapon = new Weapon("Bare fist");

    public Soldier(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return weapon.getDamage();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void equip(Weapon weapon) {
        this.weapon = weapon;
    }

    public Fight attack(Soldier defender) {
        return new Fight(this, defender);
    }
}

