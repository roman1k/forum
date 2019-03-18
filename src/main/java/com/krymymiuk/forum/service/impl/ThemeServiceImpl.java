package com.krymymiuk.forum.service.impl;

import com.krymymiuk.forum.dao.ThemeDAO;
import com.krymymiuk.forum.model.Theme;
import com.krymymiuk.forum.model.User;
import com.krymymiuk.forum.service.ThemeService;
import com.krymymiuk.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {
    @Autowired
    ThemeDAO themeDAO;
    @Autowired
    UserService userService;

    @Override
    public void createTheme(String name, User user) {
        User author =userService.findByUsername(user.getUsername());
        Theme theme = new Theme(name,author );
        theme.setCreateDate(LocalDate.now());
        themeDAO.save(theme);
    }

    @Override
    public List<Theme> allThemes() {
        List<Theme> themes = themeDAO.findAllByOrderByCreateDate();

        return  themes;
    }

    @Override
    public Theme findByNameTheme(String name) {
        return themeDAO.findByNameTheme(name);
    }

}
