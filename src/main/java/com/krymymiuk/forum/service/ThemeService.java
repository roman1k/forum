package com.krymymiuk.forum.service;

import com.krymymiuk.forum.model.entity.Theme;
import com.krymymiuk.forum.model.entity.User;

import java.util.List;

public interface ThemeService {
    void createTheme(String name, User user);
    List allThemes();
    Theme findByNameTheme(String name);
    Theme findById(int id);
}
