package org.example.test;

import org.example.model.connection.DBproperties;
import org.example.utils.XMLManager;

public class saveConnection {
    public static void main(String[] args) {
        DBproperties c = new DBproperties("localhost","3306","ultratd","root","root");
        XMLManager.writeXML(c,"connection.xml");
    }
}
