package com.krymymiuk.forum.dao;

import com.krymymiuk.forum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicDAO  extends JpaRepository<Topic, Integer> {
    List<Topic> findAllByNameTopicContaining(String search);
    int countTopicsBy();
    Topic findByNameTopic(String nameTopic);
    Topic findById(int id);
}