package com.krymymiuk.forum.controller;

import com.krymymiuk.forum.dao.TopicDAO;
import com.krymymiuk.forum.service.CommentService;
import com.krymymiuk.forum.service.ThemeService;
import com.krymymiuk.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GeneralController {
    @Autowired
    private UserService userService;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private TopicDAO topicDAO;
    @Autowired
    private CommentService commentService;

    @GetMapping("/getStatistics")
    public void getStatistics(Model model){
    }

    @PostMapping("/successURL")
    private String successURL() {
        return "redirect:/";
    }

    @GetMapping("/login")
    private String login() {
        return "redirect:/";
    }
    @GetMapping("/login?error")
    private String error() {
        return "redirect:/";
    }

}
