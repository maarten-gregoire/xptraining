package be.cegeka.battle;

/**
 * Created by maarteng on 8/11/2016.
 */
public class Weapon {

    private int damage;
    private String name;

    public Weapon(int damage) {
        this.damage = damage;
    }

    public Weapon(String name) {
        this.name = name;
        if ("Bare fist".equals(name))
            damage = 1;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}
