package com.krymymiuk.forum.controller;

import com.krymymiuk.forum.model.User;
import com.krymymiuk.forum.service.ThemeService;
import com.krymymiuk.forum.service.TopicService;
import com.krymymiuk.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("theme/")
public class ThemeController {
    @Autowired
    ThemeService themeService;
    @Autowired
    TopicService topicService;
    @Autowired
    UserService userService;

    @GetMapping("{idTheme}")
    public String getTheme(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("user", user);
        return "theme.html";
    }
}
