package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static jm.task.core.jdbc.util.Util.*;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        Session session = createSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS users " +
                "(id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR (30) NOT NULL, " +
                "lastName VARCHAR (30) NOT NULL, " +
                "age int NOT NULL" +
                ") ENGINE=InnoDB;").executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = createSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = createSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(new User(name, lastName, age));
        transaction.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {
        Session session = createSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM users WHERE id = :id")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = createSessionFactory().openSession();
        List<User> list = session.createQuery("From " + User.class.getSimpleName()).list();
        session.close();
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Session session = createSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM users")
                .executeUpdate();
        transaction.commit();
        session.close();
    }
}
