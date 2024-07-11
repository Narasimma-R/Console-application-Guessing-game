package Bank;

import java.util.UUID;

public class PlayerDetails {
    private final UUID uid= UUID.randomUUID();
    private final String name;
    private int points=0;

    public PlayerDetails(String name) {
        this.name = name;
    }

    public UUID getUserUid() {
        return uid;
    }

    public String getUserName() {
        return name;
    }

    public int getUserPoints() {
        return points;
    }

    public void updatePoints(int points){
        this.points+=points;
    }
}
