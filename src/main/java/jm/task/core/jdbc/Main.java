package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl qwe = new UserServiceImpl();

        qwe.createUsersTable();

        qwe.saveUser("Ivan", "Ivanov", (byte) 32);
        qwe.saveUser("Petr", "Petrov", (byte) 23);
        qwe.saveUser("Sidr", "Sidorov", (byte) 16);

        qwe.removeUserById(2);

        qwe.getAllUsers().forEach(q -> System.out.println(q.toString()));

        qwe.cleanUsersTable();

        qwe.dropUsersTable();
    }
}
