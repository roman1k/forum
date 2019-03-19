package com.krymymiuk.forum.controller;

import com.krymymiuk.forum.model.entity.Theme;
import com.krymymiuk.forum.model.entity.User;
import com.krymymiuk.forum.service.ThemeService;
import com.krymymiuk.forum.service.TopicService;
import com.krymymiuk.forum.service.UserService;
import com.krymymiuk.forum.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")

public class UserController {
    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);
    @Autowired
    private UserService userService;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private TopicService topicService;


    @PostMapping("/newUser")
    public String newUser(String username, String password,String email){
        userService.newUser(username, password, email);
        return "redirect:/";

    }

    @GetMapping("/activate/{code}")
    public String activate( @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);;
        return "redirect:/";
    }

    @GetMapping()
    public String addAttribute (Model model, @AuthenticationPrincipal User user) {
        List<Theme> themes = themeService.allThemes();
        model.addAttribute("themes", themes);
        model.addAttribute("user", user);
        return "index.html";
    }
    @PostMapping("/createTopic")
    public String createTopic(@AuthenticationPrincipal User user,
                              Model model,
                              String nameTheme,
                              String nameTopic,
                              String description){
        topicService.createTopic(nameTheme, user, nameTopic, description);
        int id = topicService.findByNameTopic(nameTopic).getId();
        return "redirect:topic/"+id;
    }
}

