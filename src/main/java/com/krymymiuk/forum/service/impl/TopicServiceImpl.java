package com.krymymiuk.forum.service.impl;

import com.krymymiuk.forum.dao.TopicDAO;
import com.krymymiuk.forum.model.entity.Theme;
import com.krymymiuk.forum.model.entity.Topic;
import com.krymymiuk.forum.model.entity.User;
import com.krymymiuk.forum.service.ThemeService;
import com.krymymiuk.forum.service.TopicService;
import com.krymymiuk.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicDAO topicDAO;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private UserService userService;

    @Override
    public void createTopic(String themeName, User user, String name, String description) {
        Theme theme = themeService.findByNameTheme(themeName);
        User author =userService.findByUsername(user.getUsername());
        Topic topic = new Topic(theme, name, description, author);
        topicDAO.save(topic);
    }

    @Override
    public Topic findById(int id) {
        return topicDAO.findById(id);
    }

    @Override
    public Topic findByNameTopic(String nameTopic) {
        return  topicDAO.findByNameTopic(nameTopic);
    }
}
