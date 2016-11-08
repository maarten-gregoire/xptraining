package be.cegeka.battle;

/**
 * Created by glennb on 8/11/2016.
 */
public class War {

    private Army attacker;
    private Army defender;

    public War(Army attacker, Army defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public Army determineWinner() {
        while(attacker.getFrontMan() != null && defender.getFrontMan() != null) {
            Soldier attackingSoldier = attacker.getFrontMan();
            Soldier defendingSoldier = defender.getFrontMan();
            Fight fight = new Fight(attackingSoldier, defendingSoldier);
            Soldier winner = fight.determineWinner();
            Army loser;
            if(winner == attackingSoldier) {
                loser = defender;
            }
            else {
                loser = attacker;
            }
            loser.killFrontMan();
        }
        if(attacker.getFrontMan() == null) {
            return defender;
        }
        else {
            return attacker;
        }
    }

}
