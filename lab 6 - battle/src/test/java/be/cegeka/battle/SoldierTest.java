package be.cegeka.battle;

import be.cegeka.battle.Weapons.BareFist;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SoldierTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenConstructed_mustHaveNameNotNull() {
        Soldier soldierNull = new Soldier(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenConstructed_mustHaveNameNotEmpty() {
        Soldier soldierEmpty = new Soldier("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenConstructed_mustHaveNameNotAllSpaces() {
        Soldier soldierSpace = new Soldier("    ");
    }

    @Test
    public void whenAssignedAnotherWeapon_IsEquipped() {
        BareFist fist = new BareFist();
        Soldier soldier = new Soldier("Gladiator", fist);
        assertThat(soldier.getWeapon()).isSameAs(fist);
    }

    @Test
    public void whenNotAssignedAnotherWeapon_IsEquippedWithBareFist() {
        Soldier soldier = new Soldier("Ryan");
        assertThat(soldier.getWeapon()).isInstanceOf(BareFist.class);
    }

}
