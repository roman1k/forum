package com.krymymiuk.forum.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;
    @Column( nullable = false, unique = true)
    private  String nameTopic;
    private  String description;
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<Comment> comments;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "autor_id", nullable = false)
    private User author;

    public Topic() {
    }

    public Topic(Theme theme, String nameTopic, String description, User author) {
        this.theme = theme;
        this.nameTopic = nameTopic;
        this.description = description;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTopic() {
        return nameTopic;
    }

    public void setNameTopic(String nameTopic) {
        this.nameTopic = nameTopic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topic)) return false;
        Topic topic = (Topic) o;
        return getId() == topic.getId() &&
                Objects.equals(theme, topic.theme) &&
                Objects.equals(getNameTopic(), topic.getNameTopic()) &&
                Objects.equals(author, topic.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), theme, getNameTopic(), author);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", theme=" + theme +
                ", nameTopic='" + nameTopic + '\'' +
                ", description='" + description + '\'' +
                ", author=" + author +
                '}';
    }
}
