package com.krymymiuk.forum.service;

import com.krymymiuk.forum.model.Theme;
import com.krymymiuk.forum.model.User;

public interface TopicService {
    void createTopic(Theme theme, User user, String name, String description);

}
