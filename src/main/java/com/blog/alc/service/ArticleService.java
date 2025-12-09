package com.blog.alc.service;

import com.blog.alc.model.Article;
import com.blog.alc.repository.ArticleRepository;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.stereotype.Service;

import java.lang.ScopedValue;
import java.util.ArrayList;
import java.util.List;

@Service
    public class ArticleService {
    private final ArticleRepository articleRepository;
    private List<Article> listArticle = new ArrayList<>();


    public ArticleService(ArticleRepository articleRepository)
    {
        this.articleRepository = articleRepository;

        listArticle.add(new Article(12L,"Top 10","Franc",  "les dix meilleurs livres"));
        listArticle.add(new Article(34L,"TNews","Marie",  "les nouvelles "));
        listArticle.add(new Article(56L,"EcoSystem","Patric",  "Presentation des ecosytemes"));
    }

    public List<Article> getArticle() {
        return articleRepository.findAll();
    }

    public Article getListArticleById(Long id)
    { for (Article a : listArticle) {
        if (a.getId() == id)
            return a;
    }return null;
    }


    public Article getArticleByID(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(
                        ()-> new IllegalArgumentException("software Engineer " +id+" not found")
                );
    }

    public void createANewArticle(Article article) {
        articleRepository.save(article);
    }

    public void modifyArticle(Article update) {
        getArticleByID(update.getId());
       articleRepository.save(update);
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);

    }
    public List<Article> getArticleByAuthor(String auteur) {
        return articleRepository.findByAuteur(auteur);
    }


}
