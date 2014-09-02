<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List,com.ccit.beans.Area,com.ccit.beans.Staff,com.ccit.page.PageDiv"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>员工列表</title>
<link href="css/all.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#container_staff {
	width: 800px;
	margin: 10px auto;
}

a.l1:link, a.l1:visited, a.l1:active {
	text-decoration: none;
	color: #FF0;
	font-weight: bold;
}

a.l1:hover {
	text-decoration: underline;
	color: #FF0;
	font-weight: bold;
}

a.l2:link, a.l2:visited, a.l2:active {
	text-decoration: none;
	color: #0CF;
	font-weight: bold;
}

a.l2:hover {
	text-decoration: underline;
	color: #000;
	font-weight: bold;
}

a.l3:link, a.l3:visited, a.l3:active {
	text-decoration: none;
	color: #F00;
	font-weight: bold;
}

a.l3:hover {
	text-decoration: underline;
	color: #000;
	font-weight: bold;
}

a.l4:link, a.l4:visited, a.l4:active {
	text-decoration: none;
	color: #000;
	font-weight: bold;
}

a.l4:hover {
	text-decoration: underline;
	color: #000;
	font-weight: bold;
}

#arealist {
	list-style: none;
	text-decoration: none;
}

#arealist li {
	float: left;
}

#arealist li a {
	color: #FFF;
	text-decoration: none;
	margin-left: 15px;
	font-size: 12px;
}

#arealist li a:hover {
	text-decoration: underline;
}
</style>
</head>

<body>
	<div id="container_staff">
		<table width="800" border="0" align="left" cellpadding="0"
			cellspacing="1" bordercolor="#FFFFFF">
			<tr>
				<td height="24" bgcolor="#003399" class="whitefont">.::现有员工账号&nbsp;
					&nbsp; <a href="#" class="l1">全部</a>&nbsp; &nbsp; <a href="#"
					class="l1">需要验证的员工</a>&nbsp; &nbsp; <a href="#" class="l1">已验证的员工</a>
				</td>
			</tr>
			<tr>
				<td height="24" bgcolor="#003399">
					<ul id="arealist">
						<%
							List<Area> areaList = (List<Area>) request.getAttribute("areaList");
							for (Area area : areaList) {
						%>
						<li><a href="#"><%=area.getName()%></a></li> &nbsp; &nbsp;
						<%
							}
						%>
					</ul>
				</td>
			</tr>
		</table>
		<p>
			<!-- list --->
		</p>
		<table width="800" border="0" cellspacing="1" bgcolor="#799ae1">
			<tr>
				<td align="center" valign="middle" bgcolor="#00CCCC">员工登录账号</td>
				<td width="74" height="24" align="center" valign="middle"
					bgcolor="#00CCCC">员工姓名</td>
				<td width="80" height="24" align="center" valign="middle"
					bgcolor="#00CCCC">潜在客户</td>
				<td width="66" height="24" align="center" valign="middle"
					bgcolor="#00CCCC">现有客户</td>
				<td height="24" colspan="2" align="center" valign="middle"
					bgcolor="#00CCCC">操作方式</td>
			</tr>

			<%
				PageDiv<Staff> staffPd = (PageDiv<Staff>) request
						.getAttribute("staffPd");
				List<Staff> list = staffPd.getList();
				for(Staff s : list) {
			%>
			<tr>
				<td height="24" width="103" align="center" valign="middle"
					bgcolor="#CCCCCC"><%=s.getEmail()%></td>
				<td height="24" width="74" align="center" valign="middle"
					bgcolor="#CCCCCC"><%=s.getName()%></td>
				<td height="24" width="80" align="center" valign="middle"
					bgcolor="#CCCCCC"><a href="#" class="l2">查看</a></td>
				<td width="66" height="24" align="center" valign="middle"
					bgcolor="#CCCCCC" class="l2"><a href="#" class="l2">查看</a></td>
				<td width="327" height="24" align="center" valign="middle"
					bgcolor="#CCCCCC"><span class="l2"><a href="#"
						class="l2">查看、修改员工资料</a></span>&nbsp; <a href="#" class="l3">删除员工</a></td>
				<td height="24" width="232" align="center" valign="middle"
					bgcolor="#CCCCCC"><a href="#" class="l4">该账号已开通，点击封闭</a></td>
			</tr>
			<%
				}
			%>

		</table>


	</div>

</body>
</html>
