package duplication;

public class Engine {

    private Player player;

    public Position walkNorth() {
        Player p = getPlayer();
        p.move("N");
        return p.getPosition();
    }

    public Position walkSouth() {
        Player player = getPlayer();
        player.move("S");
        return player.getPosition();
    }

    public Position walkEast() {
        Player player = getPlayer();
        player.move("E");
        return player.getPosition();
    }

    public Position walkWest() {
        Player player = getPlayer();
        player.move("W");
        return player.getPosition();
    }

    public Player getPlayer() {
        return player;
    }
}
