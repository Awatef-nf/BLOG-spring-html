package com.blog.alc.controller;

import com.blog.alc.model.Article;
import com.blog.alc.service.ArticleService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ArticleController {
    private ArticleService articleService;
    private Article article;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("id", article.getId());
        model.addAttribute("titre", article.getTitre());
        model.addAttribute("auteur", article.getAuteur());
        model.addAttribute("contenu", article.getContenu());
        return "index";
    }

    @GetMapping("/nouveau")
    public String getForm()
    {
        return "form";
    }

    @GetMapping("/detail/{id}")
    public  String getDetail(Model model, @PathVariable Long id)
    {
        model.addAttribute("article",articleService.getListArticleById(id));
        return "detail";
    }



}
