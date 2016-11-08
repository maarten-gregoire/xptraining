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

}
