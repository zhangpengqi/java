<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>createArticle</title>
    <style>
      .top .createArticle{
        background-color: #E8E8E9;
      }
      .content{
        width: 70%;
        margin-top: 50px;
        margin-left: 15%;
      }
      .content .myArticle{
        font-size: 30px;
      }
      .content input{
        display: block;
        height: 30px;
        width: 100%;
        border-radius: 5px;
        outline: none;
        border: 1px solid gray;
        padding-left: 10px;
      }
      .content textarea{
        display: block;
        height: 90px;
        width: 100%;
        border-radius: 5px;
        outline: none;
        border: 1px solid gray;
        padding-left: 10px;
      }
      .content .submit{
        display: block;
        font-size: 15px;
        background-color: #2F75AD;
        color: white;
        border-radius: 3px;
        border: none;
        margin-top: 10px;
        padding: 5px;
      }
    </style>
  </head>
  <body>
  <div>
    <%
      if((String) session.getAttribute("username")==null){
        response.getWriter().append("<h3>还未登录</h3>");
        response.getWriter().append("<a href='login.jsp'>点击登录</a>");
    }%>
    <%@include file="top.jsp"%>
    <div class="content">
      <span class="myArticle">发表文章</span>
      <form action="doCreateArticle.jsp" method="post"/>
        <h4>标题</h4>
        <input type="text" name="title" placeholder="请输入文章标题">
        <h4>内容</h4>
        <textarea type="text" name="content" placeholder="请输入文章内容"></textarea>
        <button class="submit" type="submit">发布</button>
      </form>
    </div>
  </div>
  </body>
</html>
