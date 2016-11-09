package be.cegeka.battle;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SoldierTest {

    @Test (expected = IllegalArgumentException.class)
    public void Soldier_givenSoldier_thenNameMustNotBeNull() {
        new Soldier(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void Soldier_givenSoldier_thenNameMustNotBeEmpty() {
        new Soldier("");
    }

    @Test (expected = IllegalArgumentException.class)
    public void Soldier_givenSoldier_thenNameMustNotBeSpaces() {
        new Soldier("   ");
    }

    @Test
    public void Soldier_givenSoldier_thenNameMustHaveName() {
        Soldier soldier = new Soldier("name");
        assertThat(soldier.getName()).isEqualTo("name");
    }

    @Test
    public void Soldier_givenNotAssignedAnotherWeapon_thenEquippedWithBareFist() {
        Soldier soldier = new Soldier("Piet soldaat");
        assertThat(soldier.getWeapon().getName()).isEqualTo("Bare fist");
    }
}
