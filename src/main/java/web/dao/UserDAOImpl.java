package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> allUsers = session.createQuery("from User", User.class)
                .getResultList();

        return allUsers;
    }
}
