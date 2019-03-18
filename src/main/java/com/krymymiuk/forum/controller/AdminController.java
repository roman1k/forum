package com.krymymiuk.forum.controller;

import com.krymymiuk.forum.model.Theme;
import com.krymymiuk.forum.model.User;
import com.krymymiuk.forum.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    ThemeService themeService;
    @PostMapping("/createTheme")
    public String createTheme(String nameTheme, @AuthenticationPrincipal User user){
        themeService.createTheme(nameTheme,user);
        return "redirect:/";

    }


}
