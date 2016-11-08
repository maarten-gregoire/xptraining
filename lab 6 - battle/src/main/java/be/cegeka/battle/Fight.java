package be.cegeka.battle;

/**
 * Created by glennb on 8/11/2016.
 */
public class Fight {

    private Soldier attacker;
    private Soldier defender;

    public Fight(Soldier attacker, Soldier defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public Soldier determineWinner() {
        if(defender.getWeapon().getDamage() > attacker.getWeapon().getDamage()) {
            return defender;
        }
        return attacker;
    }
}
