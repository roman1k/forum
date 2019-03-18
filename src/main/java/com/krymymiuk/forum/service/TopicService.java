package com.krymymiuk.forum.service;

import com.krymymiuk.forum.model.Theme;
import com.krymymiuk.forum.model.Topic;
import com.krymymiuk.forum.model.User;

public interface TopicService {
    void createTopic(String themeName, User user, String name, String description);

    Topic findByNameTopic(String nameTopic);
}
