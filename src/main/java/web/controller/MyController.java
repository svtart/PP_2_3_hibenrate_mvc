package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class MyController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String showAllUsers(Model model) {

        List<User> allUsers = userService.index();
        model.addAttribute("allUsers", allUsers);

        return "users";
    }
    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());

        return "new";
    }
    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }
}
