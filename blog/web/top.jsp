<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setContentType("text/html;charset=utf-8");
%>
<html>
<head>
    <title>Title</title>
    <style>
        body,div,span{
            padding: 0;
            margin: 0;
        }
        body{
            width: 80%;
            margin-left: 10%;
        }
        .top{
            height: 80px;
            background-color: #F9F9FA;
            border-bottom: solid 1px #EAEAEB;
            line-height: 80px;
            font-size: 20px;
        }
        .top .blog{
            display: inline-block;
            margin-left: 3%;
        }
        .top .home{
            display: inline-block;
            margin-left: 2%;
            width: 8%;
            text-align: center;
            text-decoration: none;
            color: black;

        }
        .top .createArticle{
            display: inline-block;
            margin-left: 40%;
            text-decoration: none;
            color: black;
        }
        .top .vip{
            margin-left: 5%;
            display: inline-block;
            height: 80px;
        }
        .top .login{
            text-align: center;
            width: 8%;
            display: inline-block;
            margin-left: 40%;
            color: black;
            text-decoration: none;
        }
        .top .sign{
            text-align: center;
            width: 8%;
            display: inline-block;
            margin-left: 2%;
            color: black;
            text-decoration: none;
        }
        .top .centerList{
            display: none;
        }
        .top .centerList:hover{
            display: block;
            position: absolute;
            height: 60px;
            width: 160px;
            right: 15%;
            top:70px ;
            box-shadow: 0px 2px  36px 0px rgba(0,0,0,0.07);
            z-index: 311;
        }
        .top .vip:hover+ .centerList{
            display: block;
            position: absolute;
            height: 60px;
            width: 160px;
            right: 15%;
            top:70px ;
            box-shadow: 0px 2px  36px 0px rgba(0,0,0,0.07);
            z-index: 311;
        }
        .centerList a{
            display: block;
            color: black;
            height: 30px;
            line-height: 30px;
            text-decoration: none;
            border: solid 1px lightgray;
        }
        </style>
</head>
<body>
<div class="top">
    <span class="blog">Blog</span>
    <a href="index.jsp" class="home">首页</a>

    <%
        String username= (String) session.getAttribute("username");
        if(username==null){
            out.print("<a href=\"login.jsp\" class=\"login\">登录</a>");
            out.print("<a href=\"sign.jsp\" class=\"sign\">注册</a>");
        }else {
            out.print("<a href='createArticle.jsp' class=\"createArticle\">发表文章</a>");
            out.print("<span  class='vip'>欢迎回来：");
            out.print(username);
            out.print("</span>");
            out.print("<div class='centerList'>");
            out.print("<a href='center.jsp'>个人中心</a>");
            out.print("<a href='doExit.jsp'>退出登录</a>");
            out.print("</div>");
        }
    %>
</div>
</body>
</html>
