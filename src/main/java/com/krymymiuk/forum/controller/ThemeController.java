package com.krymymiuk.forum.controller;

import com.krymymiuk.forum.model.entity.Theme;
import com.krymymiuk.forum.model.entity.Topic;
import com.krymymiuk.forum.model.entity.User;
import com.krymymiuk.forum.service.ThemeService;
import com.krymymiuk.forum.service.TopicService;
import com.krymymiuk.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;


@Controller
@RequestMapping("theme/")
public class ThemeController {
    @Autowired
    private ThemeService themeService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private UserService userService;

    @GetMapping("{idTheme}")
    public String getTheme(@PathVariable int idTheme,Model model, @AuthenticationPrincipal User user){
        model.addAttribute("user", user);
        Theme theme = themeService.findById(idTheme);
        model.addAttribute("theme", theme);
        Set<Topic> topics = theme.getTopic();
        model.addAttribute("topics", topics);
        return "theme.html";
    }
}
