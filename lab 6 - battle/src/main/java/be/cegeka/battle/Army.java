package be.cegeka.battle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by glennb on 8/11/2016.
 */
public class Army {

    private List<Soldier> soldiers = new ArrayList<>();

    public List<Soldier> getSoldiers() {
        return soldiers;
    }

    public Soldier getFrontMan() {
        return soldiers.get(0);
    }

    public void enlist(Soldier soldier) {
        soldiers.add(soldier);
    }
}
