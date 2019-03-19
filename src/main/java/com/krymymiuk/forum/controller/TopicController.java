package com.krymymiuk.forum.controller;

import com.krymymiuk.forum.model.entity.Theme;
import com.krymymiuk.forum.model.entity.Topic;
import com.krymymiuk.forum.model.entity.User;
import com.krymymiuk.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topic/")
public class TopicController {
    @Autowired
    private TopicService topicService;


    @GetMapping("{idTopic}")
    public String getTheme(@PathVariable int idTopic, Model model, @AuthenticationPrincipal User user){
        model.addAttribute("user", user);
        Topic topic = topicService.findById(idTopic);
        model.addAttribute("topic", topic);
        Theme theme = topic.getTheme();
        model.addAttribute("theme", theme);
        return "topic.html";
    }

}
