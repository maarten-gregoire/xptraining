package be.cegeka.battle;

import be.cegeka.battle.Weapons.BareFist;
import be.cegeka.battle.Weapons.Weapon;

public class Soldier {

    private final String name;
    private Weapon weapon;

    public Soldier(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        weapon = new BareFist();
    }

    public Soldier(String name, Weapon weapon) {
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

}
