package be.cegeka.battle;

import be.cegeka.battle.weapon.Axe;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AxeTest {

    @Test
    public void Axe_givenAxe_thenDamageIsThree(){
        Weapon axe = new Axe();
        assertThat(axe.getDamage()).isEqualTo(3);
    }
}
