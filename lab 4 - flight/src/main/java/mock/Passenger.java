package mock;

public class Passenger {
    private String name;

    public Passenger(String name) {
        if (name != null && !name.trim().isEmpty())
            this.name = name.trim();
        else
            throw new IllegalArgumentException();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
