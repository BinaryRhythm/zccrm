<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page
	import="com.ccit.beans.Staff,com.ccit.service.StaffService,com.ccit.beans.Area,java.util.List"%>
<%
	// 获取管理员
	StaffService ss = (StaffService) this.getServletContext()
			.getAttribute("ss");
	Staff staff = ss.getStaff(1);

	// 获取地域
	List<Area> areaList = ss.getAllArea();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>修改管理员信息</title>
<link href="css/all.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<div align="center">
		<form action="modifyManager" method="post">
			<h2>管理员信息</h2>

			<ul style="list-style-type: none">
				<li>姓 名：<input type="text" value="<%=staff.getName()%>"
					name="name" /></li>
				<li>邮 箱：<input type="text" value="<%=staff.getEmail()%>"
					name="email" /></li>
				<li>密 码：<input type="text" value="" name="pwd" /></li>
				<li>电 话：<input type="text" value="<%=staff.getTel()%>"
					name="tel" /></li>
				<li>权 限：<input type="text" value="<%=staff.getLimits()%>"
					name="limits" /></li>
				<li>地 址：<input type="text" value="<%=staff.getAddr()%>"
					name="addr" /></li>

				<li>领 导：<input type="text"
					value="<%=staff.getLeaderID()%>"
					name="leaderName" /></li>

				<li>地 域：<select name="areaId">
						<%
							for (Area area : areaList) {
								if (staff.getAreaID() == area.getId()) {
						%>
						<option value="<%=area.getId()%>" selected><%=area.getName()%></option>
						<%
							} else {
						%>
						<option value="<%=area.getId()%>"><%=area.getName()%></option>
						<%
							}
							}
						%>
				</select>
			</ul>
			<input type="submit" value="提 交" />
		</form>
	</div>
</body>
</html>