package be.cegeka.battle;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by glennb on 8/11/2016.
 */
public class ArmyTest {

    @Test
    public void Army_whenEnlisted_areAddedToList() {
        Army army = new Army();
        Soldier soldier1 = new Soldier("soldier1");
        Soldier soldier2 = new Soldier("soldier2");
        army.enlist(soldier1);
        army.enlist(soldier2);
        assertThat(army.getSoldiers()).containsExactly(soldier1, soldier2);
        assertThat(army.getFrontMan()).isSameAs(soldier1);
    }
}
