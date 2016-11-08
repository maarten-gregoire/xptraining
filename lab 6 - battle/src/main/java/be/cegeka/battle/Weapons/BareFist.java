package be.cegeka.battle.Weapons;

import be.cegeka.battle.Weapons.Weapon;

/**
 * Created by glennb on 8/11/2016.
 */
public class BareFist extends Weapon {

    @Override
    public int getDamage() {
        return 1;
    }

    @Override
    public int getBonusDmgVs(Weapon weapon) {
        return 0;
    }

}
