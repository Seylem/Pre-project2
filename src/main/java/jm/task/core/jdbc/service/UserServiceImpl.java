package main.java.jm.task.core.jdbc.service;

import main.java.jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import main.java.jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBC.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDaoJDBC.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userDaoJDBC.getAllUsers());
    }

    public void cleanUsersTable() {
        userDaoJDBC.cleanUsersTable();
    }
}
