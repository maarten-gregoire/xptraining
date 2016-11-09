package be.cegeka.battle;

import be.cegeka.battle.weapon.Axe;

import be.cegeka.battle.weapon.BareFist;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BareFistTest {

    @Test
    public void Axe_givenBareFist_thenDamageIsOne(){
        Weapon bareFist = new BareFist(1);
        assertThat(bareFist.getDamage()).isEqualTo(2);
    }
}