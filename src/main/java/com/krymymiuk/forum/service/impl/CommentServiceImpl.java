package com.krymymiuk.forum.service.impl;

import com.krymymiuk.forum.dao.CommentDAO;
import com.krymymiuk.forum.model.Comment;
import com.krymymiuk.forum.model.Topic;
import com.krymymiuk.forum.model.User;
import com.krymymiuk.forum.service.CommentService;
import com.krymymiuk.forum.service.TopicService;
import com.krymymiuk.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    UserService userService;
    @Autowired
    TopicService topicService;
    @Autowired
    CommentDAO commentDAO;

    @Override
    public void createComment(String nameTopic, String text, User user) {
        User author = userService.findByUsername(user.getUsername());
        Topic topic = topicService.findByNameTopic(nameTopic);
        Comment comment = new Comment(text, author, topic);
        commentDAO.save(comment);
    }
}
