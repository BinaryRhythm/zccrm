package com.ccit.servlet.staff;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccit.beans.Area;
import com.ccit.service.StaffService;

@WebServlet("/forRegistStaff")
public class forRegistStaff extends ServletBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7614934195624886728L;

	@Override
	public void proc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StaffService ss = (StaffService) this.getServletContext().getAttribute(
				"ss");

		List<Area> areaList = ss.getAllArea();

		request.setAttribute("areaList", areaList);
		request.getRequestDispatcher("regist.jsp").forward(request, response);

	}

}
