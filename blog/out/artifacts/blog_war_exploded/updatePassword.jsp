<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updatePassword</title>
    <style>
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
        <h2><b>修改密码</b></h2>
        <form action="doUpdatePassword.jsp" method="post">
            <h4>原密码</h4>
            <input type="text" name="oldPassword" placeholder="请输入原密码">
            <h4>新密码</h4>
            <input type="password" name="password" placeholder="请输入新密码">
            <h4>重复密码</h4>
            <input type="password" name="checkPassword" placeholder="请重复新密码">
            <button class="submit" type="submit">提交</button>
        </form>
    </div>
</div>
</body>
</html>


