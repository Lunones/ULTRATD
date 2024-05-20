package org.example.model.entity;

/**
 * Represents a skill in the system.
 * Each skill has an ID and a description.
 */
public class Skill {

    private int id;             // Unique identifier for the skill
    private String description; // Description of the skill

    /**
     * Default constructor initializes the skill with default values.
     */
    public Skill() {
        id = 0;
        description = "";
    }

    /**
     * Parameterized constructor to create a skill with specified attributes.
     * @param id The ID of the skill.
     * @param description The description of the skill.
     */
    public Skill(int id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * Get the ID of the skill.
     * @return The ID of the skill.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID of the skill.
     * @param id The ID of the skill to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the description of the skill.
     * @return The description of the skill.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the skill.
     * @param description The description of the skill to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}

