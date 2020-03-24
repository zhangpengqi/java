<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>sign</title>
    <style>
        .top .sign{
            background-color: #E8E8E9;
        }
        .content{
            width: 70%;
            margin-left: 15%;
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
        .content .submit{
            display: block;
            font-size: 20px;
            background-color: #2F75AD;
            color: white;
            border-radius: 3px;
            border: none;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div>
    <%@include file="top.jsp"%>
    <div class="content">
        <h2><b>注册</b></h2>
        <form action="doSign.jsp" method="post">
            <h4>用户名</h4>
            <input type="text" name="username" placeholder="请输入用户名">
            <h4>密码</h4>
            <input type="password" name="password" placeholder="请输入密码">
            <h4>重复密码</h4>
            <input type="password" name="checkPassword" placeholder="请重复密码">
            <button class="submit" type="submit">提交</button>
        </form>
    </div>
</div>
</body>
</html>
