package com.blog.alc.controller;

import com.blog.alc.model.Article;
import com.blog.alc.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {
    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("listArticle", articleService.getArticles());
        return "index";
    }

    @GetMapping("/nouveau")
    public String getForm(Model model) {  //on ceer un objet vide pour que cet objet reçoie les données du formulaire
        model.addAttribute("article", new Article());
        return "formulaire";
    }

    @GetMapping("/detail/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("article", articleService.getArticleByID(id));
        return "detail";
    }

    @PostMapping("/nouveau")
    public String addArcticle(@ModelAttribute Article article, Model model) {
        articleService.createANewArticale(article);
        return "redirect:/";
    }

    @GetMapping("/recherche")
    public String getArticleByAuthor(String auteur, Model model) {
        model.addAttribute("listArticle", articleService.getArticleByAuthor(auteur));
        return "auteur";
    }


    @GetMapping("/{id}/modifier")
    public String modifier(@PathVariable Long id, Model model) {
        Article article = articleService.getArticleByID(id);
        if (article != null) {
            model.addAttribute("article", article);
            return "formulaire";
        }
        return "redirect:/";

    }

    @PostMapping("/{id}/modifier")
    public String modifierArticle(@ModelAttribute Article article) {
        articleService.modifyArticle(article);
        return "redirect:/";
    }


    @GetMapping("/{id}/delete")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "redirect:/";
    }

}
