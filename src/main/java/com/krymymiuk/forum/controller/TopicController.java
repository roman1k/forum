package com.krymymiuk.forum.controller;

import com.krymymiuk.forum.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topic/")
public class TopicController {

    @GetMapping("{idTopic}")
    public String getTheme(@PathVariable int idTopic, Model model, @AuthenticationPrincipal User user){
        model.addAttribute("user", user);
        return "topic.html";
    }

}
