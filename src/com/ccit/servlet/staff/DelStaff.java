package com.ccit.servlet.staff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccit.service.ManagerService;

@WebServlet("/admin/delStaff")
public class DelStaff extends ServletBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1027055410744322896L;

	@Override
	public void proc(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int id = this.getInt(req, "id");
		int pageNo = this.getInt(req, "pageNo");
		ManagerService ms = (ManagerService) this.getServletContext()
				.getAttribute("ms");
		ms.deleteStaff(id);
        resp.sendRedirect("staffList?pageNo="+pageNo);
	}

}
