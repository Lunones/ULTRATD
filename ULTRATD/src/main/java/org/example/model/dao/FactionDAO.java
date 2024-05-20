package org.example.model.dao;

import org.example.model.connection.DBconnection;
import org.example.model.entity.Faction;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FactionDAO implements DAO<Faction, String> {

    // SQL queries for CRUD operations on the Faction table
    private final static String INSERT = "INSERT INTO Faction (id, name) VALUES (?, ?)";
    private final static String UPDATE = "UPDATE Faction SET name=? WHERE id=?";
    private final static String FINDALL = "SELECT name FROM Faction";
    private final static String FINDBYNAME = "SELECT a.id, a.name FROM Faction AS a WHERE a.name=?";
    private final static String FINDBYID = "SELECT a.id, a.name FROM Faction AS a WHERE a.id=?";
    private final static String DELETE = "DELETE FROM Faction WHERE id=?";
    private final static String ULID="SELECT MAX(id)+1 FROM Faction";

    // Connection object for database interactions
    private Connection conn;
    private int ul=0;



    // Constructor to establish database connection
    public FactionDAO() {
        conn = DBconnection.getConnection();
    }

    // Method to delete a Faction entity from the database
    @Override
    public Faction delete(Faction entity) throws SQLException {
        if (entity == null || entity.getName() == null) return entity;
        try (PreparedStatement pst = conn.prepareStatement(DELETE)) {
            pst.setInt(1, entity.getId());
            pst.executeUpdate();
        }
        return entity;
    }

    // Method to update a Faction entity in the database
    public Faction update(Faction entity) throws SQLException {
        if (entity == null || entity.getName() == null) return entity;
        try (PreparedStatement pst = conn.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, entity.getName());
            pst.setInt(2, entity.getId());
            pst.executeUpdate();
        }
        return entity;
    }

    // Method to save a new Faction entity in the database
    public Faction save(Faction entity) {
        Faction result = entity;
        ul=ultid();
        if (entity == null || entity.getId() == 0) return result;
        Faction existingFaction = findById(entity.getId());
        if (existingFaction.getId() == 0) {
            try (PreparedStatement pst = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                pst.setInt(1,ul);
                pst.setString(2, entity.getName());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public int ultid() {

        try (PreparedStatement pst = conn.prepareStatement(ULID)) {
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                ul = res.getInt(1);
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ul;
    }
    // Method to find a Faction entity by its ID
    public Faction findById(int key) {
        Faction result = new Faction();
        if (key == 0) return result;
        try (PreparedStatement pst = conn.prepareStatement(FINDBYID)) {
            pst.setInt(1, key);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                result.setId(res.getInt("id"));
                result.setName(res.getString("name"));
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Method to find a Faction entity by its name
    public Faction findByName(String name) {
        Faction result = new Faction();
        if (name.equalsIgnoreCase("")) return result;
        try (PreparedStatement pst = conn.prepareStatement(FINDBYNAME)) {
            pst.setString(1, name);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                result.setId(res.getInt("id"));
                result.setName(res.getString("name"));
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Method to retrieve all Faction entities from the database
    @Override
    public List<String> findAll() {
        List<String> result = new ArrayList<>();
        try (PreparedStatement pst = conn.prepareStatement(FINDALL)) {
            try (ResultSet res = pst.executeQuery()) {
                while (res.next()) {
                    result.add(res.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Unimplemented method required by the DAO interface, not used
    @Override
    public Faction findById(String key) {
        return null;
    }

    // Static method to build and return a new FactionDAO instance
    public static FactionDAO build() {
        return new FactionDAO();
    }

    // Close method to release any resources, required by the DAO interface
    @Override
    public void close() throws IOException {
        // Implement resource cleanup here if needed
    }
}