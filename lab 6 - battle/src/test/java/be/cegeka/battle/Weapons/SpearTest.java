package be.cegeka.battle.Weapons;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by glennb on 8/11/2016.
 */
public class SpearTest {

    @Test
    public void Spear_does2Damage() {
        Spear spear = new Spear();
        assertThat(spear.getDamage()).isEqualTo(2);
    }

}
