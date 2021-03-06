package com.krymymiuk.forum.dao;

import com.krymymiuk.forum.model.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThemeDAO extends JpaRepository<Theme, Integer> {
    List <Theme> findAllByOrderByCreateDate();
    Theme  findByNameTheme(String name);
    Theme findById(int id);
}
