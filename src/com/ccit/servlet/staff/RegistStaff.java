package com.ccit.servlet.staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccit.beans.Staff;
import com.ccit.service.StaffService;
import com.ccit.util.MD5;

@WebServlet("/RegistStaff")
public class RegistStaff extends ServletBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 561803791655658247L;

	@Override
	public void proc(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		StaffService ss = (StaffService) this.getServletContext().getAttribute(
				"ss");

		String email = this.getString(req, "email");
		String pwd1 = this.getString(req, "pwd1");
		String pwd2 = this.getString(req, "pwd2");
		String name = this.getString(req, "name");
		int areaId = this.getInt(req, "areaId");
		String tel = this.getString(req, "tel");
		String addr = this.getString(req, "addr");
		String comment = this.getString(req, "comment");

		Staff s = new Staff();
		s.setAreaID(areaId);
		s.setAddr(addr);
		s.setName(name);
		s.setEmail(email);
		s.setTel(tel);
		s.setLimits(comment);

		try {
			s.setPwd(MD5.md5(pwd1));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		this.header(resp, "温馨提示");
		PrintWriter out = resp.getWriter();

		if (email != "" && pwd1 != "" && ss.registStaff(s)) {
			out.println("<p align='center'><h3>注册成功!</h3></p>");
			out.println("<a href='login.html'>返回登录</a>");
		} else {
			out.println("<script language='javascript'>alert('注册失败');history.back(-1);</script>");
		}

		this.footer(resp);
		out.close();

	}

}
