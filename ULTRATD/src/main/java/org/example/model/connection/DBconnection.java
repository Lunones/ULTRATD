package org.example.model.connection;

import org.example.utils.XMLManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBconnection {
    private final static String FILE="connection.xml";
    private static DBconnection _instance;
    private static Connection conn;

    private DBconnection(){
        DBproperties properties = (DBproperties) XMLManager.readXML(new DBproperties(),FILE);

        try {
            conn = DriverManager.getConnection(properties.getURL(),properties.getUser(),properties.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
            conn=null;
        }
    }

    public static Connection getConnection(){
        if(_instance==null){
            _instance = new DBconnection();
        }
        return conn;
    }

    public static void closeConnection(){
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

