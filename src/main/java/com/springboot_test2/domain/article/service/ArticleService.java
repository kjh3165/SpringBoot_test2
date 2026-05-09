package com.springboot_test2.domain.article.service;

import com.springboot_test2.domain.article.entity.Article;
import com.springboot_test2.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.time.LocalDateTime.now;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public void write(String title, String content) {
        Article article = new Article(title, content);
        article.setCreatedDate(now());
        article.setModifiedDate(article.getCreatedDate());
        articleRepository.save(article);
    }

    public Article getArticleById(int id) {
        Optional<Article> article = articleRepository.findById(id);
        if(article.isPresent()) {
            return article.get();
        }
        else{
            return null;
        }
    }

    public void modify(Article article, String title, String content){
        article.setTitle(title);
        article.setContent(content);
        article.setModifiedDate(now());
        articleRepository.save(article);
    }

    public void deleteById(int id) {
        articleRepository.deleteById(id);
    }
}
