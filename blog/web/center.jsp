<%@ page import="bean.Article" %>
<%@ page import="service.ArticleService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .top .vip{
            background-color: #E8E8E9;
        }
        .userCenter{
            width: 70%;
            margin-left: 15%;
            margin-top: 50px;
        }
        .userCenter div{
            width:100%;
            height: 50px;
            line-height: 40px;
            padding-left: 10px;
            border: 1px solid lightgray;
        }
        .userCenter .title{
            margin-top: 15px;
            background-color: lightgray;
        }
        .userCenter a{
            display: block;
            margin-top: 20px;
            width: 70px;
            padding: 10px;
            height: 20px;
            border-radius: 3px;
            color: white;
            text-decoration: none;
            background-color: #2F75AD;
        }
    </style>
</head>
<body>
<%@include file="top.jsp"%>
<div class="userCenter">
    <h3>个人中心</h3>
    <div  class="title">个人信息</div>
    <div>昵称：<%=(String) session.getAttribute("username")%></div>
    <div class="title">数据统计</div>
    <%
        List<Article> articleList;
        ArticleService articleService=new ArticleService();
        articleList=articleService.selectArticle(username);
    %>
    <div>文章数：<%=articleList.size()%></div>
    <a  href="updatePassword.jsp">修改密码</a>
</div>
</body>
</html>
