package com.ccit.servlet.staff;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccit.beans.Staff;
import com.ccit.service.StaffService;
import com.ccit.util.MD5;

@WebServlet("/checkLogin")
public class CheckLogin extends ServletBase {

	private static final long serialVersionUID = 7103195188801111699L;

	@Override
	public void proc(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		ServletContext sc = this.getServletContext();
		String email = this.getString(req, "email");
		String pwd = this.getString(req, "pwd");

		StaffService ss = (StaffService) sc.getAttribute("ss");
		Staff staff;
		try {
			staff = ss.checkLogin(email, MD5.md5(pwd));
			if (null != staff && staff.getPwd().equals(MD5.md5(pwd))) {
				req.getSession().setAttribute("staff", staff);
				resp.sendRedirect("main.html");
			} else {
				resp.sendRedirect("login.html");

			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
