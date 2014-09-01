package com.ccit.servlet.staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletBase extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1162612726893642880L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.proc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.proc(req, resp);
	}

	public void proc(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// super.doPost(req, resp);
	}

	public String getString(HttpServletRequest req, String param) {
		String str = "";
		if (null != req.getParameter(param)
				&& !"".equals(req.getParameter(param))) {
			str = this.toUTF8(req.getParameter(param));
		}
		return str;
	}

	public int getInt(HttpServletRequest req, String param) {
		int res = 0;

		if (null != req.getParameter(param)
				&& !"".equals(req.getParameter(param))) {
			String str = req.getParameter(param);
			if (str.matches("\\d+")) {
				res = Integer.parseInt(str);
			}
		} else {

		}
		return res;
	}

	/**
	 * 防止乱码，进行转码工作
	 * 
	 * @param orgstr
	 * @return
	 */
	public String toUTF8(String orgstr) {
		String res = null;
		if (null != orgstr && !"".equals(orgstr)) {
			try {
				res = new String(orgstr.getBytes("iso-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			res = "";
		}
		return res;
	}

	public void header(HttpServletRequest req, HttpServletResponse resp,
			String title) throws IOException {
		resp.setContentType("text/html;charaset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>" + title + "</title></head><body>");
		out.close();
	}

	public void footer(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.println("</body></html>");
		out.close();
	}

}
