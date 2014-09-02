package com.ccit.servlet.staff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends ServletBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7110488295108323207L;

	@Override
	public void proc(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getSession().invalidate();
		resp.sendRedirect("index.jsp");
	}

}
