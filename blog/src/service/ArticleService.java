package service;

import bean.Article;
import impl.ArticleDAOImpl;

import java.util.List;

public class ArticleService {
    ArticleDAOImpl articleDAOImpl =new ArticleDAOImpl();

    /**
     * 查询所有文章
     * @return
     */
    public List<Article> selectArticle(){
        return articleDAOImpl.selectArticle();
    }

    /**
     * 查询个人文章
     * @param username 账号
     * @return
     */
    public List<Article> selectArticle(String username){
        return articleDAOImpl.selectArticleByUsername(username);
    }

    /**
     * 发表文章
     * @param username 账号
     * @param title 文章标题
     * @param content 文章内容
     */
    public void createArticle(String username,String title,String content){
        articleDAOImpl.insertByTitleAndContent(username,title,content);
    }

}
