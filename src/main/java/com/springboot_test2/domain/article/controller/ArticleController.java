package com.springboot_test2.domain.article.controller;

import com.springboot_test2.domain.article.entity.Article;
import com.springboot_test2.domain.article.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(Model model){
        List<Article> articleList = articleService.getList();
        model.addAttribute("articleList", articleList);
        return "list.html";
    }

    @GetMapping("/create")
    public String create(){
        return "write.html";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Article article = articleService.getArticleById(id);
        if(article == null){
            // 에러 메세지 띄우기
            return "redirect:/article/list";
        }
        model.addAttribute("article", article);
        return "detail.html";
    }

    @GetMapping("/modify/{id}")
    public String modify(Model model, @PathVariable("id") Integer id){
        Article article = articleService.getArticleById(id);
        if(article == null){
            // 에러 메세지 띄우기
            return "redirect:/article/list";
        }
        model.addAttribute("article", article);
        return "modify.html";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        articleService.deleteById(id);
        return "redirect:/article/list";
    }

    @PostMapping("/create")
    public String create(@RequestParam String title, @RequestParam String content) {
        articleService.write(title, content);
        return "redirect:/article/list";
    }

    @PostMapping("/modify/{id}")
    public String modify(@PathVariable("id") Integer id, @RequestParam String title, @RequestParam String content){
        Article article = articleService.getArticleById(id);
        articleService.modify(article, title, content);
        return "redirect:/article/list";
    }
}
