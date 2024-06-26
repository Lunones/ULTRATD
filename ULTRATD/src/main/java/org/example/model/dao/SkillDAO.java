package org.example.model.dao;

import org.example.model.connection.DBconnection;
import org.example.model.entity.Faction;
import org.example.model.entity.Skill;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDAO implements DAO<Skill, String> {

    private final static String INSERT="INSERT INTO Skill (id,description) VALUES (?,?)";
    private final static String UPDATE="UPDATE Skill SET description=? WHERE id=?";
    private final static String FINDALL="SELECT description FROM Skill";
    private final static String FINDBYNAME="SELECT a.id, a.description FROM Skill AS a WHERE a.description=?";
    private final static String FINDBYID="SELECT a.id, a.description FROM Skill AS a WHERE a.id=?";
    private final static String DELETE="DELETE FROM Skill WHERE id=?";
    private final static String ULID="SELECT MAX(id)+1 FROM Skill";

    private Connection conn;
    private int ul=-1;
    public SkillDAO(){
        conn = DBconnection.getConnection();
    }
    public static SkillDAO build() {
        return new SkillDAO();
    }
    @Override
    public Skill save(Skill entity) {
        Skill result = entity;
        if(entity==null || entity.getId()==0) return result;
        Skill a = findById(entity.getId());  //si no está devuelve un usuario por defecto
        if(a.getId()==0){
            //INSERT
            try(PreparedStatement pst = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {

                pst.setInt(1,entity.getId());
                pst.setString(2,entity.getDescription());
                pst.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public Skill delete(Skill entity) throws SQLException {
        if (entity == null || entity.getDescription() == null) return entity;
        try (PreparedStatement pst = conn.prepareStatement(DELETE)) {
            pst.setInt(1, entity.getId());
            pst.executeUpdate();
        }
        return entity;
    }

    @Override
    public Skill findById(String key) {
        return null;
    }

    public Skill update(Skill entity) throws SQLException {
        if (entity == null || entity.getDescription() == null) return entity;
        try (PreparedStatement pst = conn.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, entity.getDescription());
            pst.setInt(2, entity.getId());
            pst.executeUpdate();
        }
        return entity;
    }



    public Skill findById(int key) {
        Skill result = new Skill();
        if(key==0) return result;

        try(PreparedStatement pst = conn.prepareStatement(FINDBYID)) {
            pst.setInt(1,key);
            ResultSet res = pst.executeQuery();
            if(res.next()){
                result.setId(res.getInt("id"));
                result.setDescription(res.getString("description"));
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Skill findByName(String name) {
        Skill result = new Skill();
        if (name.equalsIgnoreCase("")) return result;
        try (PreparedStatement pst = conn.prepareStatement(FINDBYNAME)) {
            pst.setString(1, name);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                result.setId(res.getInt("id"));
                result.setDescription(res.getString("description"));
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public List<String> findAll() {
        List<String> result = new ArrayList<>();
        try (PreparedStatement pst = conn.prepareStatement(FINDALL)) {
            try (ResultSet res = pst.executeQuery()) {
                while (res.next()) {
                    result.add(res.getString("description"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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



    @Override
    public void close() throws IOException {

    }

}
