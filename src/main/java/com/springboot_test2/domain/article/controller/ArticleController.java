package com.springboot_test2.domain.article.controller;

import com.springboot_test2.domain.article.ArticleForm;
import com.springboot_test2.domain.article.entity.Article;
import com.springboot_test2.domain.article.service.ArticleService;
import com.springboot_test2.domain.user.entity.SiteUser;
import com.springboot_test2.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;
    private final UserService userService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "kw", defaultValue = "") String kw){
        List<Article> articleList = articleService.getList(kw);
        model.addAttribute("articleList", articleList);
        model.addAttribute("kw", kw);
        return "list.html";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String create(ArticleForm articleForm){
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

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String modify(ArticleForm articleForm, Model model, @PathVariable("id") Integer id, Principal principal){
        Article article = articleService.getArticleById(id);
        if(!article.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        model.addAttribute("article", article);
        articleForm.setTitle(article.getTitle());
        articleForm.setContent(article.getContent());
        return "modify.html";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        articleService.deleteById(id);
        return "redirect:/article/list";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String create(@Valid ArticleForm articleForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "write.html";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        articleService.write(articleForm.getTitle(), articleForm.getContent(), siteUser);
        return "redirect:/article/list";
    }

    @PostMapping("/modify/{id}")
    public String modify(@Valid ArticleForm articleForm, BindingResult bindingResult, Model model, @PathVariable("id") Integer id, Principal principal){
        Article article = articleService.getArticleById(id);
        model.addAttribute("article", article);
        if (bindingResult.hasErrors()) {
            return "modify.html";
        }
        if(!article.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        articleService.modify(article, articleForm.getTitle(), articleForm.getContent());
        return "redirect:/article/list";
    }
}
