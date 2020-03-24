<%@ page import="service.UserService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");//解决请求乱码问题

    String username=request.getParameter("username");
    String password=request.getParameter("password");
    String checkPassword=request.getParameter("checkPassword");
    System.out.println("username:"+username+"\npassword:"+password+"\ncheckPassword"+checkPassword);
    if(password.equals(checkPassword)){
        UserService userService=new UserService();
        boolean isSign=userService.Sign(username,password);
        //注册成功
        if(isSign){
            response.getWriter().append("<h3>注册成功</h3>");
            response.getWriter().append("<a href='login.jsp'>点击去登录</a>");
            return;
        }else {
            //账号存在
            response.getWriter().append("<a href='sign.jsp'>账号已存在，点击重新注册</a>");
            return;
        }
    }else{
        //两次密码输入不同
        response.getWriter().append("<a href='sign.jsp'>两次密码输入不同，点击重新注册</a>");
    }
%>