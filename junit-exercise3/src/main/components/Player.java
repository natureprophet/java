package main.components;

/**
 * Created by simon.gomez on 10/12/2016.
 */
public class Player extends Profesional {

    Position position;

    public Player(String name, int age, int skill, Position position) {
        super(name, age, skill);
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
