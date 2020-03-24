<%@ page import="service.ArticleService" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>index</title>
    <style>
        .top .home{
            background-color: #E8E8E9;
        }
        .articleList{
            margin-top: 10px;
            width: 70%;
            margin-left: 15%;
        }
      .articleList .articleTitle{
        padding-left: 15px;
          padding-right: 15px;
        line-height: 30px;
          text-decoration: none;
        height: 30px;
        background-color: #F9F9FA;
        border: solid 1px #DEDFE0;
        border-radius: 3px;
      }
      .articleList .articleContent{
          margin-bottom:15px;
          padding-right: 15px;
        padding-left: 10px;
        line-height: 40px;
        height: 120px;
        border: solid 1px #DEDFE0;
        border-radius: 3px;
      }
      .articleList .myArticle{
          font-size: 30px;
      }
      .articleList .createArticle2{
          background-color: #2F75AD;
          color: white;
          font-size: 15px;
          float: right;
          text-decoration: none;
          padding: 5px 10px 5px 10px;
          border-radius: 3px;
      }
    </style>
  </head>
  <body>
      <div>

    <%@include file="top.jsp" %>
          <div class="articleList">
          <%
              List<Article> articleList;
              ArticleService articleService=new ArticleService();
              if(username==null) {
                  articleList = articleService.selectArticle();
              }else {
                  articleList=articleService.selectArticle(username);
                  out.print("<span class='myArticle'>我的文章</span>");
                 out.print("<a class='createArticle2' href='createArticle.jsp'>发表文章</a>");
              }
              for(Article article:articleList){
                  %>
              <div class="articleTitle">
                  <%out.print(article.getTitle());%>
              </div>
              <div class="articleContent">
                  <%out.print(article.getContent());%>
              </div>
              <%}
          %>
          </div>
      </div>
  </body>
</html>
