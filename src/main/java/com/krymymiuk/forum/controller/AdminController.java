package com.krymymiuk.forum.controller;

import com.krymymiuk.forum.model.entity.User;
import com.krymymiuk.forum.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @Autowired
    private ThemeService themeService;

    @PostMapping("/createTheme")
    public String createTheme(String nameTheme, @AuthenticationPrincipal User user){
        themeService.createTheme(nameTheme,user);
        int id = themeService.findByNameTheme(nameTheme).getId();
        return "redirect:/theme/" + id;
    }

}
