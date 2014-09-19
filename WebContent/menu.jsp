<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.ccit.beans.Staff" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>菜单</title>
<link href="css/all.css" rel="stylesheet" type="text/css" />
<style type="text/css">
 #topmenu{
    width:158px;
	height:25px;
	line-height:25px;
	background:url(image/admin_left_1.gif) no-repeat;
 }
 #topmenu ul{list-style:none;}
 #topmenu ul li{float:left;padding-left:5px;}
 #topmenu ul li a{text-decoration:none;color:#333333;}
 #topmenu ul li a:hover{text-decoration:underline;}
 
 #menulist{width:158px;}
 #menulist dl dt{width:158px;height:25px;background:url(image/admin_left_9.gif) no-repeat;margin-top:10px;
 line-height:25px;font-weight:bold;color:#003399; padding-left:3px;cursor:pointer;}
 #menulist dl dd{line-height:25px;font-size:12px;background-color:#D6DFF7;padding-left:15px;}
 #menulist dl dd a{text-decoration:none; color:#333333;}
 #menulist dl dd a:hover{text-decoration:underline;}
 
 #showm{width:158px;height:39px; background:url(image/title.gif) no-repeat;}
 
</style>
<script language="javascript" src="js/jquery-1.5.1.min.js"></script>
<script language="javascript">
$(function(){
	
	$("#menulist dt").toggle(function(){
		$(this).nextUntil('dt').hide();
		},
		function(){
			$(this).nextUntil('dt').show();
		}
		);
	
});
</script>
</head>

<body>
<div id="showm" align="right">
  <p>
     <%
         if(null != session.getAttribute("staff")){
        	 Staff s = (Staff)session.getAttribute("staff");
        	 out.println("欢迎,<font color='red'>"+ s.getName()+"</font>");
         }
     %>
  </p>
</div>
<div id="topmenu">
<ul>
   <li><a href="#">首页</a></li>
   <li><a href="logout" target="_parent" style="border-left:1px #333333 solid; padding-left:5px;">注销登录</a></li>
</ul>
</div>
<div id="menulist">
  <dl>
      <dt style="margin-top:0;">在职干部</dt>
      <dd><a href="logout" target="_parent">注销登录</a></dd>
      <dd><a href="modify_manager.jsp" target="main">修改管理员资料</a></dd>
      <dd><a href="admin/staffList" target="main"><font color="#FF0000">查看员工账号</font></a></dd>
      
      <dt>退休干部</dt>
      <dd><a href="#">查看区域</a></dd>
      
      <dt>职       工</dt>
      <dd><a href="#">潜在客户</a></dd>
      <dd><a href="#">现有客户</a></dd>
      
      <dt>转出干部</dt>
      <dd><a href="#">天数设置</a></dd>
      <dd><a href="#">客户生日提醒</a></dd>
      <dd><a href="#">企业周年提醒</a></dd>
      <dd><a href="#">新年更新状态</a></dd>
      
      <dt>离世干部</dt>
      <dd><a href="#">添加潛在客戶</a></dd>
      <dd><a href="#">查看潛在客戶</a></dd>
      <dd><a href="#">查找潛在客戶</a></dd>
      <dd><a href="#">刪除潛在客戶</a></dd>
      
  </dl>
</div>
</body>
</html>
