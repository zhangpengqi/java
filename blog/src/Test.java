import bean.Article;
import service.ArticleService;
import service.UserService;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArticleService articleService = new ArticleService();
        articleService.createArticle("marry","hahaha","是打发是打是打发啥打法上是打发阿斯蒂芬收待发放萨芬的阿斯顿发斯蒂芬啥打法上发地方阿斯顿发达阿斯蒂芬是打发方过后头发规划");
//        List<Article> articleList=articleService.selectArticle("marry");
//        List<Article> articleList=articleService.selectArticle();
//        for(Article article:articleList){
//            System.out.println(article);
//        }
//        articleService.selectArticle("jack");
//        UserService userService=new UserService();
//        userService.Sign("jack","123456");
//        System.out.println(userService.Login("jack","12345"));
//        System.out.println(userService.Login("jack","123456"));
//        System.out.println(userService.Login("ja","12345"));
//        userService.updatePassword("jack","111111");

    }
}
