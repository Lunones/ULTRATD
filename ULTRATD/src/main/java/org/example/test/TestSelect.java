package org.example.test;

import org.example.model.dao.UserDAO;
import org.example.model.entity.User;

public class TestSelect {
    public static void main(String[] args) {
        UserDAO aDAO = new UserDAO();
        User a = aDAO.findById(1);
        System.out.println(a);

        User b= UserDAO.build().findById(1);


    }
}
