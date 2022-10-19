package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDAOImpl implements UserDAO{

    private static int PEOPLE_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User("Artur", "Svetozaorv", "IT", 300));
        users.add(new User("Boris", "Moni", "HR", 300));
        users.add(new User("Lela", "Monick", "Sales", 150));
        users.add(new User("Bony", "Claid", "IT", 200));
    }

    @Override
    public List<User> index() {
        return users;
    }

    public List<User> show(int count) {
        return users.stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public void save(User user) {
        users.add(user);
    }
}
