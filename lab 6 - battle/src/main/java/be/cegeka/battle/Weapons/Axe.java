package be.cegeka.battle.Weapons;

/**
 * Created by glennb on 8/11/2016.
 */
public class Axe extends Weapon {

    @Override
    public int getDamage() {
        return 3;
    }

    @Override
    public int getBonusDmgVs(Weapon weapon) {
        if(weapon instanceof Spear) {
            return 3;
        }
        return 0;
    }

}
