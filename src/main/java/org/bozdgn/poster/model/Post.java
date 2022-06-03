package org.bozdgn.poster.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String author;
    private String title;
    private LocalDate createdAt;
    private String createdBy;
    private LocalDate updatedAt;
    private String updatedBy;
    @Column(columnDefinition = "TEXT")
    private String text;

    // NOTE(bora): This is to register `Category` enum as an entity
    // and hold a list of categories as a field in post.
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "category", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
    private final List<Category> categories = new ArrayList<>();

    // NOTE(bora): A no-arg constructor so JPA stops complaining about not being able to initialize.
    private Post() {
    }

    public Post(
            String author,
            String title,
            LocalDate createdAt,
            String createdBy,
            LocalDate updatedAt,
            String updatedBy,
            String text,
            List<Category> categories) {
        this.author = author;
        this.title = title;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.text = text;
        this.categories.addAll(categories);
    }


    public Long getID() {
        return id;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
