package org.example.model.dao;

import org.example.model.connection.DBconnection;
import org.example.model.entity.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User, String>{

    private final static String INSERT="INSERT INTO User (id,name,password,lvl,id_faction) VALUES (?,?,?,?,?)";
    private final static String UPDATE="UPDATE User SET name=?, password=?, lvl=? WHERE id=?";
    private final static String FINDALL="SELECT name FROM User";
    private final static String FINDBYID="SELECT a.id,a.name,a.password, a.lvl, a.id_faction FROM User AS a WHERE a.id=?";
    private final static String FINDBYNAME="SELECT a.id, a.name, a.password, a.lvl, a.id_faction  FROM User AS a WHERE a.name=?";
    private final static String DELETE="DELETE FROM User WHERE id=?";
    private final static String ULID="SELECT MAX(id)+1 FROM User";

    private Connection conn;
    private int ul = 0;
    public UserDAO(){
        conn = DBconnection.getConnection();
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
    public User save(User entity) {
        User result = entity;
        if(entity==null || entity.getId()==0) return result;
        User a = findById(entity.getId());  //si no está devuelve un usuario por defecto
        if(a.getId()==0){
            //INSERT
            try(PreparedStatement pst = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
                pst.setInt(1,entity.getId());
                pst.setString(2,entity.getName());
                pst.setString(3,entity.getPassword());
                pst.setInt(4,entity.getLvl());
                pst.setInt(5,entity.getId_faction());
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
                result.setId_faction(res.getInt("id_faction"));
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
                    b.setId_faction(res.getInt("id_faction"));
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

    public static UserDAO build(){
        return new UserDAO();
    }


    @Override
    public void close() throws IOException {

    }

    class UserLazy extends User{
        /*@Override
        public Faction getFaction(){
            if(super.getId_faction()==-1){
                setId_faction(BookDAO.build().findByAuthor(this));
            }
            return super.getBooks();*/
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
