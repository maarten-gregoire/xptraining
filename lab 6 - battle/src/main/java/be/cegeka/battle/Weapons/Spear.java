package be.cegeka.battle.Weapons;

/**
 * Created by glennb on 8/11/2016.
 */
public class Spear extends Weapon {

    @Override
    public int getDamage() {
        return 2;
    }

    @Override
    public int getBonusDmgVs(Weapon weapon) {
        return 0;
    }

}
