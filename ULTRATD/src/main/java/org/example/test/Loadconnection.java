package org.example.test;

import org.example.model.connection.DBproperties;
import org.example.utils.XMLManager;

public class Loadconnection {
    public static void main(String[] args) {
        DBproperties c = XMLManager.readXML(new DBproperties(),"connection.xml");
        System.out.println(c);
    }
}
