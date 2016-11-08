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

    @Test
    public void Axe_hasBonusVsSpears() {
        Axe axe = new Axe();
        Spear spear = new Spear();
        assertThat(axe.getBonusDmgVs(spear)).isEqualTo(3);
    }

    @Test
    public void Axe_hasNoBonusVsOthers() {
        Axe axe = new Axe();
        Sword sword = new Sword();
        BareFist fist = new BareFist();
        assertThat(axe.getBonusDmgVs(sword)).isEqualTo(0);
        assertThat(axe.getBonusDmgVs(fist)).isEqualTo(0);
        assertThat(axe.getBonusDmgVs(axe)).isEqualTo(0);
    }

}
