package com.krymymiuk.forum.service;

import com.krymymiuk.forum.model.User;

import java.util.List;

public interface ThemeService {
    void createTheme(String name, User user);
    List allThemes();
}
