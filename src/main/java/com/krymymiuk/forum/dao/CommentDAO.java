package com.krymymiuk.forum.dao;

import com.krymymiuk.forum.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDAO  extends JpaRepository<Comment, Integer> {
    int countCommentsBy();

}
