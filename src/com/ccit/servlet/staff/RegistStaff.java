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

		// System.out.println(email);
		// System.out.println(pwd1);
		// System.out.println(pwd2);
		// System.out.println(name);
		// System.out.println(areaId);
		// System.out.println(tel);
		// System.out.println(addr);
		// System.out.println(comment);

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (ss.registStaff(s)) {
			// this.header(req, resp, "注册成功！");
			// this.footer(req, resp);

			PrintWriter out = resp.getWriter();
			out.println("<script language='javascript'>alert('');<script>");

		} else {

		}

	}

}
