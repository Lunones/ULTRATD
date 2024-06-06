package org.example.model.dao;

import org.example.model.connection.DBconnection;
import org.example.model.entity.Faction;
import org.example.model.entity.Skill;
import org.example.model.entity.Unit;
import org.example.model.entity.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnitDAO implements DAO<Unit, String>{

    private final static String INSERT="INSERT INTO Unit (description,atk,hp,type,id_skill,id_user) VALUES (?,?,?,?,?,?)";
    private final static String UPDATE="UPDATE Unit SET description=?, atk=?, hp=?, type=? WHERE id=?";
    private final static String FINDALL="SELECT a.id, a.description, a.atk, a.hp, a.type, a.id_skill, a.id_user  FROM Unit AS a";
    private final static String FINDALLTABLE = "SELECT id, description, atk, hp, type, id_skill, id_user FROM Unit";
    private final static String FINDBYNAME="SELECT a.id, a.description, a.atk, a.hp, a.type, a.id_skill, a.id_user FROM Unit AS a WHERE a.description=?";
    private final static String FINDBYID="SELECT a.id, a.description, a.atk, a.hp, a.type, a.id_skill, a.id_user FROM Unit AS a WHERE a.id=?";
    private final static String DELETE="DELETE FROM Unit WHERE id=?";
    private Connection conn;

    public UnitDAO(){
        conn = DBconnection.getConnection();
    }
    public static UnitDAO build() {
        return new UnitDAO();
    }


    public Unit update(Unit entity) throws SQLException{
        if (entity == null || entity.getDescription() == null) return entity;
        try (PreparedStatement pst = conn.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS)) {

            pst.setString(1,entity.getDescription());
            pst.setInt(2,entity.getAtk());
            pst.setInt(3,entity.getHp());
            pst.setString(4,entity.getType());
            pst.setInt(5,entity.getId());
            pst.executeUpdate();
        }
        return entity;
    }


    @Override
    public Unit save(Unit entity) {
        Unit result = entity;
        if(entity==null) return result;
            //INSERT
            try(PreparedStatement pst = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                pst.setString(1,entity.getDescription());
                pst.setInt(2,entity.getAtk());
                pst.setInt(3,entity.getHp());
                pst.setString(4,entity.getType());
                pst.setInt(5, entity.getSkill().getId());
                pst.setInt(6, entity.getUser().getId());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return result;
    }

    @Override
    public Unit delete(Unit entity) throws SQLException {
        if (entity == null || entity.getId() == 0) return entity;
        try (PreparedStatement pst = conn.prepareStatement(DELETE)) {
            pst.setInt(1, entity.getId());
            pst.executeUpdate();
        }
        return entity;
    }

    @Override
    public Unit findById(String key) { return null; }

    public Unit findById(int key) {

        Unit result = new Unit();
        if(key==0) return result;

        try(PreparedStatement pst = conn.prepareStatement(FINDBYID)) {
            pst.setInt(1,key);
            ResultSet res = pst.executeQuery();
            if(res.next()){
                result.setId(res.getInt("id"));
                result.setDescription(res.getString("description"));
                result.setAtk(res.getInt("atk"));
                result.setHp(res.getInt("hp"));
                result.setType(res.getString("type"));
                Skill skill = SkillDAO.build().findById(res.getInt("id_skill"));
                User user = UserDAO.build().findById(res.getInt("id_user"));
                result.setSkill(skill);
                result.setUser(user);
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Unit findByname(String n){
        Unit result = null;
        try(PreparedStatement pst = conn.prepareStatement(FINDBYNAME)){
            pst.setString(1,n);
            try(ResultSet res = pst.executeQuery()){
                if(res.next()){
                    Unit b = new Unit();
                    b.setId(res.getInt("id"));
                    b.setDescription(res.getString("description"));
                    b.setAtk(res.getInt("atk"));
                    b.setHp(res.getInt("hp"));
                    b.setType(res.getString("type"));
                    Skill skill = SkillDAO.build().findById(res.getInt("id_skill"));
                    User user = UserDAO.build().findById(res.getInt("id_user"));
                    b.setSkill(skill);
                    b.setUser(user);
                    result=b;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Unit> findAllTable() {
        List<Unit> result = new ArrayList<>();
        try (PreparedStatement pst = conn.prepareStatement(FINDALLTABLE)) {
            try (ResultSet res = pst.executeQuery()) {
                while (res.next()) {
                    Unit un = new Unit();
                    un.setId(res.getInt("id"));
                    un.setDescription(res.getString("description"));
                    un.setAtk(res.getInt("atk"));
                    un.setHp(res.getInt("hp"));
                    un.setType(res.getString("type"));
                    Skill skill = SkillDAO.build().findById(res.getInt("id_skill"));
                    User user = UserDAO.build().findById(res.getInt("id_user"));
                    un.setSkill(skill);
                    un.setUser(user);
                    result.add(un);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<String> findAll() {
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
