package com.krymymiuk.forum.service;

import com.krymymiuk.forum.model.entity.Topic;
import com.krymymiuk.forum.model.entity.User;

public interface TopicService {
    void createTopic(String themeName, User user, String name, String description);
    Topic  findById(int id);
    Topic findByNameTopic(String nameTopic);
}
