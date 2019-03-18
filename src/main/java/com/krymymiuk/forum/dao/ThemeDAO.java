package com.krymymiuk.forum.dao;

import com.krymymiuk.forum.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ThemeDAO extends JpaRepository<Theme, Integer> {
    List <Theme> findAllByOrderByCreateDate();
    Theme  findByNameTheme(String name);
    Theme findById(int id);
    int countThemesBy();
}
