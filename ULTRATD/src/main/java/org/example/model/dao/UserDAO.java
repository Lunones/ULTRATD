package org.example.model.dao;

import org.example.model.connection.DBconnection;
import org.example.model.entity.Faction;
import org.example.model.entity.Unit;
import org.example.model.entity.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User, String>{

    private final static String INSERT="INSERT INTO User (name,password,lvl,id_faction) VALUES (?,?,?,?)";
    private final static String UPDATE="UPDATE User SET name=?, password=?, lvl=? WHERE id=?";
    private final static String FINDALL="SELECT name FROM User";
    private final static String FINDALLTABLE = "SELECT id, name, password, lvl, id_faction FROM User";
    private final static String FINDBYID="SELECT a.id,a.name,a.password, a.lvl, a.id_faction FROM User AS a WHERE a.id=?";
    private final static String FINDBYNAME="SELECT a.id, a.name, a.password, a.lvl, a.id_faction  FROM User AS a WHERE a.name=?";
    private final static String DELETE="DELETE FROM User WHERE id=?";

    private Connection conn;
    public UserDAO(){
        conn = DBconnection.getConnection();
    }

    @Override
    public User save(User entity) {
        User result = entity;
        //Faction fa = entity.getFaction();
        if(entity==null) return result;
            //INSERT
            try(PreparedStatement pst = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                pst.setString(1,entity.getName());
                pst.setString(2,entity.getPassword());
                pst.setInt(3,entity.getLvl());
                pst.setInt(4,entity.getFaction().getId());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return result;
    }



    //@Override
    public User findById(int key) {
        User result = new UserLazy();
        if(key==0) return result;

        try(PreparedStatement pst = conn.prepareStatement(FINDBYID)) {
            pst.setInt(1,key);
            ResultSet res = pst.executeQuery();
            if(res.next()){
                result.setId(res.getInt("id"));
                result.setName(res.getString("name"));
                result.setPassword(res.getString("password"));
                result.setLvl(res.getInt("lvl"));
                //Eager
                Faction faction = FactionDAO.build().findById(res.getInt("id_faction"));
                result.setFaction(faction);
                //result.setId_faction(res.getInt("id_faction"));
                //Lazy
                //BookDAO bDAO = new BookDAO();
                //result.setBooks(bDAO.findByAuthor(result));
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public User findByname(String n){
        User result = null;
        try(PreparedStatement pst = conn.prepareStatement(FINDBYNAME)){
            pst.setString(1,n);
            try(ResultSet res = pst.executeQuery()){
                if(res.next()){
                    User b = new User();
                    b.setId(res.getInt("id"));
                    b.setName(res.getString("name"));
                    b.setPassword(res.getString("password"));
                    b.setLvl(res.getInt("lvl"));
                    Faction faction = FactionDAO.build().findById(res.getInt("id_faction"));
                    b.setFaction(faction);
                    //Eager
                    /*b.setAuthor(AuthorDAO.build().findById(res.getString("id_author")));
                    b.setTitle(res.getString("title"));*/
                    result=b;
                }
            }
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
                    result.add(res.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<User> findAllTable() {
        List<User> result = new ArrayList<>();
        try (PreparedStatement pst = conn.prepareStatement(FINDALLTABLE)) {
            try (ResultSet res = pst.executeQuery()) {
                while (res.next()) {
                    User us = new User();
                    us.setId(res.getInt("id"));
                    us.setName(res.getString("Name"));
                    us.setPassword(res.getString("Password"));
                    us.setLvl(res.getInt("LVL"));
                    Faction faction = FactionDAO.build().findById(res.getInt("id_faction"));
                    us.setFaction(faction);
                    result.add(us);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static UserDAO build(){
        return new UserDAO();
    }


    @Override
    public void close() throws IOException {

    }
        @Override
    public User delete(User entity) throws SQLException {
            if (entity == null || entity.getName() == null) return entity;
            try (PreparedStatement pst = conn.prepareStatement(DELETE)) {
                pst.setInt(1, entity.getId());
                pst.executeUpdate();
            }
            return entity;
    }
    public User update(User entity) throws SQLException{
        if (entity == null || entity.getName() == null) return entity;
        try (PreparedStatement pst = conn.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS)) {
            pst.setString(1, entity.getName());
            pst.setString(2, entity.getPassword());
            pst.setInt(3, entity.getLvl());
            pst.setInt(4, entity.getId());

            pst.executeUpdate();
        }
        return entity;
    }

    @Override
    public User findById(String key) {
        return null;
    }

}
class UserLazy extends User {
    public List<Unit> getBooks(){
        if(super.getUnits()==null){
            setUnits(UnitDAO.build().findByUser(this));
        }
        return super.getUnits();
    }
}