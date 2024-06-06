package org.example.view;

public enum Scenes {

    // Enum constants representing different scenes and their corresponding FXML file paths
    ROOT("view/Layout.fxml"),
    LOGIN("view/Login.fxml"),
    FACTION("view/Faction.fxml"),
    SFACTION("view/SearchFaction.fxml"),
    USER("view/User.fxml"),
    NUSER("view/NewUser.fxml"),
    SUSER("view/SearchUser.fxml"),
    SKILL("view/Skill.fxml"),
    SSKILL("view/SearchSkill.fxml"),
    UNIT("view/Units.fxml"),
    SUNIT("view/SearchUnit.fxml"),
    TFACT("view/TableFaction.fxml"),
    TUSER("view/TableUser.fxml"),
    TUNIT("view/TableUnit.fxml"),
    TSKILL("view/TableSkill.fxml"),
    UTD("view/UTD.fxml"),
    UNDERCONST("view/UnderConst.fxml"),
    ERROR("view/Error.fxml"),
    SUCHOOSE("view/SUchoose.fxml");

    // Instance variable to store the URL of each scene
    private String url;

    // Constructor to initialize the URL of each scene
    Scenes(String url){
        this.url=url;
    }

    // Method to get the URL of a scene
    public String getURL(){
        return url;
    }
}

