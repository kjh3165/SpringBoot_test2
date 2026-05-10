package com.springboot_test2.domain.article.entity;

import com.springboot_test2.domain.user.entity.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Principal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @ManyToOne
    private SiteUser author;

    public Article(String title, String content, SiteUser author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
