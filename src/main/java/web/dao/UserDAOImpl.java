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
        users.add(new User(++PEOPLE_COUNT, "Artur", "Svetozaorv", "IT", 300));
        users.add(new User(++PEOPLE_COUNT, "Boris", "Moni", "HR", 300));
        users.add(new User(++PEOPLE_COUNT, "Lela", "Monick", "Sales", 150));
        users.add(new User(++PEOPLE_COUNT, "Bony", "Claid", "IT", 200));
    }

    @Override
    public List<User> index() {
        return users;
    }

    @Override
    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        user.setId(++PEOPLE_COUNT);
        users.add(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToBeUpdated =show(id);
        userToBeUpdated.setName(updatedUser.getName());
    }

    @Override
    public void delete(int id) {
        users.removeIf(u -> u.getId() == id);
    }
}
