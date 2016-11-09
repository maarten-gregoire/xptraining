package be.cegeka.battle;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by maarteng on 8/11/2016.
 */
public class FightTest {
    @Test
    public void Fight_givenFightStarted_thenStrongestWeaponWins() {
        Soldier attacker = new Soldier("Maximus");
        Soldier defender = new Soldier("Maarten");

        assertThat(attacker.attack(defender).getWinner()).isEqualTo(attacker);
    }

    @Test
    public void Fight_givenStrongerWeapon_thenShouldWinFight() {
        Soldier attacker = new Soldier("Pierre");
        Soldier defender = new Soldier("Marie");

        attacker.equip(new Weapon(4));
        defender.equip(new Weapon(2));

        assertThat(attacker.attack(defender).getWinner()).isEqualTo(attacker);
    }

    @Test
    public void Fight_givenWeakerWeapon_thenShouldLoseFight() {
        Soldier attacker = new Soldier("Pierre");
        Soldier defender = new Soldier("Marie");

        attacker.equip(new Weapon(1));
        defender.equip(new Weapon(2));

        assertThat(attacker.attack(defender).getWinner()).isEqualTo(defender);
    }
}
