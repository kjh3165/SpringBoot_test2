package com.springboot_test2.domain.article.repository;

import com.springboot_test2.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query("select "
            + "distinct a "
            + "from Article a "
            + "where "
            + "   a.title like %:kw% "
            + "   or a.content like %:kw% ")
    List<Article> findAllByKeyword(@Param("kw") String kw);
}
