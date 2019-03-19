package com.krymymiuk.forum.service;

import com.krymymiuk.forum.model.entity.User;

public interface CommentService {
    void createComment(String nameTopic, String text, User user);
}
