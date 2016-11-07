package longmethod;

public class Engine {

    private Player player;
    private Position home;

    public void goHome() {
        Position startPosition = getPlayer().getPosition();
        Position home = getHome();

        Vector vector = new Vector(startPosition, home);

        walk(vector);
    }

    private void walk(Vector vector) {
        player.walkX(vector.getX());
        player.walkY(vector.getY());
    }

    public Player getPlayer() {
        return player;
    }

    public Position getHome() {
        return home;
    }

    private class Vector {
        private int x;
        private int y;

        public Vector(Position startPosition, Position home) {
            calculate(startPosition, home);
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        private Vector calculate(Position startPosition, Position home) {
            x = home.getX() - startPosition.getX();
            y = home.getY() - startPosition.getY();
            return this;
        }
    }
}
