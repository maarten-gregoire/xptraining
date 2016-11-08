package be.cegeka.battle;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeaponTest {

    @Test
    public void Weapon_givenWeapon_thenDoesDamage(){
        Weapon weapon = new Weapon(1);
        assertThat(weapon.getDamage()).isEqualTo(1);
    }

    @Test
    public void Weapon_givenWeaponBareFist_thenDoesOneDamage(){
        Weapon weapon = new Weapon("Bare fist");
        assertThat(weapon.getDamage()).isEqualTo(1);
    }
}
