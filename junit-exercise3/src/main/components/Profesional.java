package main.components;

/**
 * Created by simon.gomez on 10/12/2016.
 */
public abstract class Profesional {

    protected String name;
    protected int age;
    protected int skill;

    public Profesional(String name, int age, int skill) {
        this.name = name;
        this.age = age;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSkill() {
        return skill;
    }
}
