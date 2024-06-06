package org.example.model.entity;

import java.util.List;

/**
 * Represents a User entity in the system.
 * Each user has an ID, name, password, level, and ID of the faction they belong to.
 */
public class User {
    private int id;             // Unique identifier for the user
    private String name;        // User's name
    private String password;    // User's password
    private int lvl;            // User's level or access rights
    private Faction faction;
    private List<Unit> units;

    ////nooooo
    //private int id_faction;     // ID of the faction the user belongs to

    /**
     * Default constructor initializes the user with default values.
     */
    public User() {
        this.id = 0;
        this.name = "N/A";
        this.password = "";
        this.lvl = 0;
        this.faction = null;
    }

    /**
     * Parameterized constructor to create a user with specified attributes.
     * @param id The ID of the user.
     * @param name The name of the user.
     * @param password The password of the user.
     * @param lvl The level of the user.
     */
    public User(int id, String name, String password, int lvl, Faction faction) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.lvl = lvl;
        this.faction = faction;
    }

    public User(String name, String password, int lvl, Faction faction) {
        this.name = name;
        this.password = password;
        this.lvl = lvl;
        this.faction = faction;
    }

    /**
     * Constructor to create a user with specified ID, name, password, and level.
     * @param id The ID of the user.
     * @param name The name of the user.
     * @param password The password of the user.
     * @param lvl The level of the user.
     */
    public User(int id, String name, String password, int lvl) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.lvl = lvl;
    }

    /**
     * Constructor to create a user with only a name.
     * @param name The name of the user.
     */
    public User(String name) {
        this.name = name;
    }

    // Getters and setters for user attributes

    /**
     * Gets the ID of the user.
     * @return The ID of the user.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     * @param id The ID to set for the user.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the user.
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * @param name The name to set for the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the password of the user.
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * @param password The password to set for the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the level of the user.
     * @return The level of the user.
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * Sets the level of the user.
     * @param lvl The level to set for the user.
     */
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }
}

