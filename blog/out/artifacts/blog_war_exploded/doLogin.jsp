<%@ page import="service.UserService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");//请求乱码

    String username=request.getParameter("username");
    String password=request.getParameter("password");

    UserService userService=new UserService();
    int isLogin=userService.Login(username,password);
    //登录成功
    if(isLogin==1){
        session.setAttribute("username",username);
        response.getWriter().append("<h3>登录成功</h3>");
        response.getWriter().append("<a href='index.jsp'>返回主页</a>");
        return;
    }
    //账号不存在
    if(isLogin==-1||isLogin==0){
        response.getWriter().append("<h3>账号密码错误</h3>");
        response.getWriter().append("<a href='login.jsp'>点击重新登录</a>");
    }
%>