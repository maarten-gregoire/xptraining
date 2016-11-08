package be.cegeka.battle.Weapons;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by glennb on 8/11/2016.
 */
public class AxeTest {

    @Test
    public void Axe_does3Damage() {
        Axe axe = new Axe();
        assertThat(axe.getDamage()).isEqualTo(3);
    }

}
