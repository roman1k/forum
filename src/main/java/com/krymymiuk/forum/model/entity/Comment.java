package com.krymymiuk.forum.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @Column(nullable = false)
    private  String text;
    private LocalDate createData;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User author;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "topic_id", nullable = false)
    @JsonBackReference
    private Topic topic;

    public Comment() {
    }

    public Comment(String text, User author, Topic topic) {
        this.text = text;
        this.createData = LocalDate.now();
        this.author = author;
        this.topic = topic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        Comment comment = (Comment) o;
        return getId() == comment.getId() &&
                Objects.equals(getText(), comment.getText()) &&
                Objects.equals(createData, comment.createData) &&
                Objects.equals(getAuthor(), comment.getAuthor()) &&
                Objects.equals(getTopic(), comment.getTopic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getText(), createData, getAuthor(), getTopic());
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                '}';
    }
}
