<%@ page import="service.ArticleService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");//请求乱码
    String username= (String) session.getAttribute("username");
    String title=request.getParameter("title");
    String content=request.getParameter("content");

    System.out.println(title);
    System.out.println(content);
    ArticleService articleService=new ArticleService();
    articleService.createArticle(username,title,content);
    response.getWriter().append("<h3>文章发表成功</h3>");
    response.getWriter().append("<a href='createArticle.jsp'>继续发表文章</a><br/>");
    response.getWriter().append("<a href='index.jsp'>返回主页</a>");
%>