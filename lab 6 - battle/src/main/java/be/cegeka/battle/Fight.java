package be.cegeka.battle;

/**
 * Created by maarteng on 8/11/2016.
 */
public class Fight {

    private Soldier winner;

    public Fight(Soldier attacker, Soldier defender) {
        determineWinner(attacker, defender);
    }

    public Soldier getWinner() {
        return winner;
    }

    private void determineWinner(Soldier attacker, Soldier defender) {
        if (attacker.getDamage() >= defender.getDamage()) {
            winner = attacker;
        }
        else {
            winner = defender;
        }
    }
}
