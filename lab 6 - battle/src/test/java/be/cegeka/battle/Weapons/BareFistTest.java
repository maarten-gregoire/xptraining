package be.cegeka.battle.Weapons;

import be.cegeka.battle.Weapons.BareFist;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
/**
 * Created by glennb on 8/11/2016.
 */
public class BareFistTest {

    @Test
    public void BareFist_does1Damage() {
        BareFist fist = new BareFist();
        assertThat(fist.getDamage()).isEqualTo(1);
    }

    @Test
    public void BareFist_hasNoBonusVsOthers() {
        BareFist fist = new BareFist();
        Axe axe = new Axe();
        Sword sword = new Sword();
        Spear spear = new Spear();
        assertThat(fist.getBonusDmgVs(sword)).isEqualTo(0);
        assertThat(fist.getBonusDmgVs(fist)).isEqualTo(0);
        assertThat(fist.getBonusDmgVs(axe)).isEqualTo(0);
        assertThat(fist.getBonusDmgVs(spear)).isEqualTo(0);
    }

}
