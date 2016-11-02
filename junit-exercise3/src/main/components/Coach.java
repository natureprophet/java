package main.components;

/**
 * Created by simon.gomez on 10/12/2016.
 */
public class Coach extends Profesional {

    private int experience;

    public Coach(String name, int age, int skill, int experience) {
        super(name, age, skill);
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }
}
