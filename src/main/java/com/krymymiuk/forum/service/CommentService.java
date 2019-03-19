package com.krymymiuk.forum.service;

import com.krymymiuk.forum.model.User;

public interface CommentService {
    void createComment(String nameTopic, String text, User user);
}
