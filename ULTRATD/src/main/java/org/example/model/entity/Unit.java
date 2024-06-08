package org.example.model.entity;

public class Unit {


    private int id;

    private String description;

    private int atk;

    private int hp;

    private String type;

    private User user;

    private Skill skill;


    //NOOO
    //private int id_skill;
    // private int id_user;

    public Unit(){
        this.id = 0;
        this.description = "";
        this.atk = 0;
        this.hp = 0;
        this.type = "";
        this.skill = null;
        this.user = null;
    }

    public Unit(int id, String description, int atk, int hp, String type, Skill skill, User user) {
        this.id = id;
        this.description = description;
        this.atk = atk;
        this.hp = hp;
        this.type = type;
        this.skill = skill;
        this.user = user;
    }

    public Unit(String description, int atk, int hp, String type, Skill skill, User user) {
        this.description = description;
        this.atk = atk;
        this.hp = hp;
        this.type = type;
        this.skill = skill;
        this.user = user;
    }

    public Unit(int id, String description, int atk, int hp, String type) {
        this.id = id;
        this.description = description;
        this.atk = atk;
        this.hp = hp;
        this.type = type;
    }

    public Unit(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
