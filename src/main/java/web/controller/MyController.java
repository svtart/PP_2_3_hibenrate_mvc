package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.dao.UserDAO;
import web.model.User;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/")
    public String showAllUsers(Model model) {

        List<User> allUsers = userDAO.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "all-users";
    }
}
