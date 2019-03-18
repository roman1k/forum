package com.krymymiuk.forum.service.impl;

import com.krymymiuk.forum.model.Theme;
import com.krymymiuk.forum.model.Topic;
import com.krymymiuk.forum.model.User;
import com.krymymiuk.forum.service.TopicService;
import org.springframework.stereotype.Service;

@Service
public class TopicServiceImpl implements TopicService {


    @Override
    public void createTopic(Theme theme, User user, String name, String description) {
        Topic topic = new Topic(theme, name, description, user);



    }
}
