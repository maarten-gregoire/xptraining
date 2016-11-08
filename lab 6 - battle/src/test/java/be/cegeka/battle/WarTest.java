package be.cegeka.battle;

import be.cegeka.battle.Weapons.Axe;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by glennb on 8/11/2016.
 */
public class WarTest {

    @Test
    public void War_strongestArmyWins() {
        Army strongest = new Army();
        strongest.enlist(new Soldier("Henk", new Axe()));
        Army weakest = new Army();
        for (int i = 0; i < 5; i++) {
            weakest.enlist(new Soldier(String.valueOf(i)));
        }
        War war = new War(strongest, weakest);
        assertThat(war.determineWinner()).isSameAs(strongest);
    }

}
