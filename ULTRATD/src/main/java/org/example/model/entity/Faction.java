package org.example.model.entity;

/**
 * Represents a faction in the system.
 * Each faction has an ID and a name.
 */
public class Faction {

    private int id;     // Unique identifier for the faction
    private String name; // Name of the faction

    /**
     * Parameterized constructor to create a faction with specified attributes.
     * @param id The ID of the faction.
     * @param name The name of the faction.
     */
    public Faction(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Default constructor initializes the faction with default values.
     */
    public Faction() {
        this.id = 0;
        this.name = "";
    }

    /**
     * Get the ID of the faction.
     * @return The ID of the faction.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID of the faction.
     * @param id The ID of the faction to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of the faction.
     * @return The name of the faction.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the faction.
     * @param name The name of the faction to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}

