<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.ccit.beans.Staff,com.ccit.service.StaffService"%>
<%
	StaffService ss = (StaffService) this.getServletContext()
			.getAttribute("ss");
	Staff staff = ss.getStaff(1);
%>

<div align="center">
	<form action="modifyManager" method="post">
		<h2>管理员信息</h2>

		<ul style="list-style-type: none">
			<li>姓 名：<input type="text" value="<%=staff.getName()%>"
				name="name" /></li>
			<li>邮 箱：<input type="text" value="<%=staff.getEmail()%>"
				name="email" /></li>
			<li>密 码：<input type="text" value="<%=staff.getPwd()%>"
				name="pwd" /></li>
			<li>电 话：<input type="text" value="<%=staff.getTel()%>"
				name="tel" /></li>
			<li>权 限：<input type="text" value="<%=staff.getLimits()%>"
				name="limits" /></li>
			<li>地 址：<input type="text" value="<%=staff.getAddr()%>"
				name="addr" /></li>

			<li>领 导：<input type="text"
				value="<%=staff.getLeaderName(staff.getLeaderID())%>"
				name="leaderID" /></li>
			<li>地 域：<input type="text"
				value="<%=staff.getAreaName(staff.getAreaID())%>" name="areaID" /></li>
			<li style="display: none"><input type="text"
				value="<%=staff.getId()%>" name="areaID" /></li>
		</ul>
		<input type="submit" value="提 交" />
	</form>
</div>
