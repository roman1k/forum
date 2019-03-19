package com.krymymiuk.forum.dao;

import com.krymymiuk.forum.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDAO  extends JpaRepository<Comment, Integer> {
    int countCommentsBy();

}
