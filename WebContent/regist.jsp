<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List,com.ccit.beans.Area"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>注册页面</title>
<link href="css/all.css" type="text/css">
<style type="text/css">
.
* {
	padding: 0;
	margin: 0;
}

.body {
	font-size: 14px;
	font-family: "宋体"
}

.myinput {
	padding: 0px;
	margin: 0px;
}

img {
	border: 0px;
}

#backgroud {
	position: absolute;
	left: 649px;
	top: 24px;
	height: 627px;
	width: 395px;
}

#blank {
	position: absolute;
	left: 352px;
	top: 34px;
	width: 391px;
	height: 472px;
}

.style1 {
	font-size: 16px
}

.style3 {
	color: #FFFF00
}

.style11 {
	color: #000000
}

.style12 {
	color: #0000FF
}

.style13 {
	color: #FF0000
}
</style>
</head>

<body background="image/welcome.gif">
	<div id="blank">
		<form action="RegistStaff" method="post" class="mystyle">
			<table width="393" border="0">
				<tr>
					<td height="27" colspan="4">&nbsp;</td>
				</tr>
				<tr bordercolor="#FFFF00">
					<td height="39" colspan="4"><div align="center" class="style1">
							<h1 class="style3">员工注册</h1>
						</div></td>
				</tr>
				<tr>
					<td height="15" colspan="4">&nbsp;</td>
				</tr>
				<tr>
					<td height="27"><span class="style3">账 号(Email) ：</span></td>
					<td height="27" colspan="3"><input type="text" name="email">
						<span class="style13">** </span></td>
				</tr>
				<tr>
					<td height="25"><span class="style3">密 码 ：</span></td>
					<td height="25" colspan="3"><input type="password" name="pwd1">
						<span class="style13">** </span></td>
				</tr>
				<tr bordercolor="#FFE43B">
					<td height="23"><div align="center" class="style3">确认密码：

						</div></td>
					<td height="23" colspan="3"><input type="password" name="pwd2">
						<span class="style13">**</span></td>
				</tr>
				<tr>
					<td height="25"><span class="style3">姓 名 ：</span></td>
					<td height="25" colspan="3"><input type="text" name="name">
						<span class="style13">**</span></td>
				</tr>
				<tr>
					<td height="27"><span class="style3">所属区域：</span></td>
					<td height="27" colspan="3">
					<select name="areaId">
							<option value="" selected>--请选择--</option>
							<%
								List<Area> list = (List<Area>) request.getAttribute("areaList");
								for (Area item : list) {
							%>

							<option value="<%=item.getId()%>">
								<%=item.getName()%>
							</option>

							<%
								}
							%>
					</select> <span class="style13">**</span></td>
				</tr>
				<tr>
					<td height="30"><span class="style3">联系电话：</span></td>
					<td height="30" colspan="3"><input type="text" name="tel">
					</td>
				</tr>

				<tr>
					<td height="26"><span class="style11"> <span
							class="style3">联系地址：</span>
					</span></td>
					<td height="26" colspan="3"><input type="text" name="addr">
					</td>
				</tr>
				<tr>
					<td height="44"><span class="style3">角 色 ：</span></td>
					<td height="44" colspan="3"><input type="text" name="comment">
					</td>
				</tr>
				<tr>
					<td width="78">&nbsp;</td>

					<td width="115"><input type="image" src="image/reg_button.gif"
						value="确认注册" /></td>

					<td width="80"><a href="forRegistStaff"><img
							src="image/login_again.gif" width="63" height="26"> </a></td>

					<td width="92">&nbsp;</td>
				</tr>
				<tr>
					<td height="33" colspan="4">::<a href="login.html"
						class="style12">员工登录 </a>::
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>