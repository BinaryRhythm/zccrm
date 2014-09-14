package com.ccit.servlet.staff;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccit.beans.Area;
import com.ccit.beans.Staff;
import com.ccit.page.PageDiv;
import com.ccit.service.ManagerService;
import com.ccit.service.StaffService;

/**
 * 读取区域列表 读取员工列表，传给jsp，存在分页问题
 * 
 * @author skyloon
 * @time 2014/9/2
 */
@WebServlet("/admin/staffList")
public class ForGetStaffList extends ServletBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3010093881329959610L;

	@Override
	public void proc(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StaffService ss = (StaffService) this.getServletContext().getAttribute(
				"ss");
		ManagerService ms = (ManagerService) this.getServletContext()
				.getAttribute("ms");
		// 取出区域
		List<Area> areaList = ss.getAllArea();

		int pageNo = this.getInt(req, "pageNo");
		if (pageNo == 0)
			pageNo = 1;

		PageDiv<Staff> staffPd = ms.getAllStaff(5, pageNo);

		req.setAttribute("staffPd", staffPd);
		req.setAttribute("areaList", areaList);
		
		req.getRequestDispatcher("stafflist.jsp").forward(req, resp);

	}
}
