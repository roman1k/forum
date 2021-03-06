package com.krymymiuk.forum.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "themes")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  int id;
    @Column(nullable = false, unique = true)
    private  String nameTheme;
    private LocalDate createDate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User author;
    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL, orphanRemoval = true )
    @JsonManagedReference
    private Set<Topic> topic;

    public Theme() {
    }

    public Theme(String nameTheme, User author) {
        this.nameTheme = nameTheme;
        this.author = author;
        this.createDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTheme() {
        return nameTheme;
    }

    public void setNameTheme(String nameThema) {
        this.nameTheme = nameThema;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<Topic> getTopic() {
        return topic;
    }

    public void setTopic(Set<Topic> topic) {
        this.topic = topic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Theme)) return false;
        Theme theme = (Theme) o;
        return getId() == theme.getId() &&
                Objects.equals(getNameTheme(), theme.getNameTheme()) &&
                Objects.equals(getCreateDate(), theme.getCreateDate()) &&
                Objects.equals(getAuthor(), theme.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameTheme(), getCreateDate(), getAuthor());
    }

    @Override
    public String toString() {
        return "Theme{" +
                "nameTheme='" + nameTheme + '\'' +
                ", createDate=" + createDate +
                ", author=" + author.getUsername() +
                '}';
    }
}
