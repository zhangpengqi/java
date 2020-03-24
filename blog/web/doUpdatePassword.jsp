<%@ page import="service.UserService" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("utf-8");//解决请求乱码问题

    String username= (String) session.getAttribute("username");
    String oldPassword=request.getParameter("oldPassword");
    String password=request.getParameter("password");
    String checkPassword=request.getParameter("checkPassword");
    //两次输入密码相同
    if(password.equals(checkPassword)){
        //修改后的密码和修改前的相同
        if(oldPassword.equals(password)){
            response.getWriter().append("<h3>修改前的密码和修改后的不能相同<h3>");
            response.getWriter().append("<a href='updatePassword.jsp'>点击重新修改</a>");
        }else{
            //修改后的密码和修改前的不相同,进行修改
            UserService userService=new UserService();
            //修改密码
            int isUpdate=userService.updatePassword(username,oldPassword,password);
            //修改成功
            if(isUpdate==1){
                response.getWriter().append("<h3>修改成功</h3>");
                response.getWriter().append("<a href='index.jsp'>点击跳回主页</a>");
            }else{
                //原密码错误，修改失败
                response.getWriter().append("<h3>修改密码失败</h3>");
                response.getWriter().append("<a href='updatePassword.jsp'>点击重新修改</a>");
            }
        }
    }
%>
