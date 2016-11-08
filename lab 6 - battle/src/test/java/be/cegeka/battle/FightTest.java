package be.cegeka.battle;

import be.cegeka.battle.Weapons.Sword;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by glennb on 8/11/2016.
 */
public class FightTest {

    @Test
    public void Fight_strongerWeaponWins() {
        Soldier fistSoldier = new Soldier("Caveman");
        Soldier swordSoldier = new Soldier("Legionnaire", new Sword());
        Fight fight = new Fight(fistSoldier, swordSoldier);
        assertThat(fight.determineWinner()).isSameAs(swordSoldier);
    }

    @Test
    public void Fight_whenSameWeapon_attackerWins() {
        Soldier attacker = new Soldier("Caveman1");
        Soldier defender = new Soldier("Caveman2");
        Fight fight = new Fight(attacker, defender);
        assertThat(fight.determineWinner()).isSameAs(attacker);
    }

    @Test
    public void Fight_weakerWeaponLoses() {
        Soldier fistSoldier = new Soldier("Caveman");
        Soldier swordSoldier = new Soldier("Legionnaire", new Sword());
        Fight fight = new Fight(swordSoldier, fistSoldier);
        assertThat(fight.determineWinner()).isSameAs(swordSoldier);
    }

}
