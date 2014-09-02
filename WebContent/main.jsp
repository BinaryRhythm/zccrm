<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.ccit.beans.Staff" %>

<%
   if(null == session.getAttribute("staff")){
	   response.sendRedirect("login.html");
	   return;
   }
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>401客户管理系统</title>


</head>
<frameset cols="185,*" framespacing="0" frameborder="no" border="0">
  <frame src="menu.jsp">
  <frame src="welcome.html" name="main">
</frameset><noframes></noframes>
<noframes>

<body>
</body>
</html>
