package org.example.model.entity;

public class Unit {


    private int id;

    private String description;

    private int atk;

    private int hp;

    private String type;

    private int id_skill;

    private int id_user;
    public Unit(){
        this.id = 0;
        this.description = "";
        this.atk = 0;
        this.hp = 0;
        this.type = "";
        this.id_skill = 0;
        this.id_user = 0;
    }

    public Unit(int id, String description, int atk, int hp, String type, int id_skill, int id_user) {
        this.id = id;
        this.description = description;
        this.atk = atk;
        this.hp = hp;
        this.type = type;
        this.id_skill = id_skill;
        this.id_user = id_user;
    }

    public Unit(String description, int atk, int hp, String type, int id_skill, int id_user) {
        this.description = description;
        this.atk = atk;
        this.hp = hp;
        this.type = type;
        this.id_skill = id_skill;
        this.id_user = id_user;
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
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

    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }
}
