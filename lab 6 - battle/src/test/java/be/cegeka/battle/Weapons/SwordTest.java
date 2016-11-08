package be.cegeka.battle.Weapons;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by glennb on 8/11/2016.
 */
public class SwordTest {

    @Test
    public void Sword_does2Damage() {
        Sword sword = new Sword();
        assertThat(sword.getDamage()).isEqualTo(2);
    }

}
