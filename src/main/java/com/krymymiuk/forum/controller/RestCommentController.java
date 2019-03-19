package com.krymymiuk.forum.controller;


import com.krymymiuk.forum.model.Comment;
import com.krymymiuk.forum.model.Topic;
import com.krymymiuk.forum.model.User;
import com.krymymiuk.forum.service.CommentService;
import com.krymymiuk.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;


@RestController
public class RestCommentController {
    @Autowired
    private TopicService topicService;
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/newComment", method = RequestMethod.POST)
     public @ResponseBody
     List<Comment> newComment(@RequestParam String nameTopic,
                             @RequestParam String textComment,
                             @AuthenticationPrincipal User user){
        commentService.createComment(nameTopic, textComment, user);
        Topic topic = topicService.findByNameTopic(nameTopic);
        List<Comment> response = topic.getComments();
         return response;
     }

    @RequestMapping(value = "/showComments/")
    public @ResponseBody
    List<Comment> newComment(@RequestParam String nameTopic) {
        Topic topic = topicService.findByNameTopic(nameTopic);
        List<Comment> response = topic.getComments();
        return response;
    }
}