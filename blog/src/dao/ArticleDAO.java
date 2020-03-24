package dao;

import bean.Article;

import java.util.List;

public interface ArticleDAO {

    /**
     * 插入数据库
     * @param username 账号
     * @param title 文章标题
     * @param content 文章内容
     * @return
     */
    void insertByTitleAndContent(String username,String title,String content);

    /**
     * 查询个人文章
     * @param username 账号
     * @return
     */
    List<Article> selectArticleByUsername(String username);

    /**
     * 查询所有文章
     * @return
     */
    List<Article> selectArticle();
}
