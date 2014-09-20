package com.ccit.servlet.staff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccit.beans.Staff;
import com.ccit.service.StaffService;

/**
 * 开通或关闭账号
 * 2未开通，1开通，0管理员
 * @author skyloon
 * @time 2014、9、17
 */

@WebServlet("/admin/lockAndUnlock")
public class LockUnlockStaff extends ServletBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3397086954422665621L;

	@Override
	public void proc(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String types = this.getString(req, "types");
		int id = this.getInt(req, "id");
		int pageNo = this.getInt(req, "pageNo");

		StaffService ss = (StaffService) this.getServletContext().getAttribute(
				"ss");

		Staff staff = ss.getStaff(id);
		if (types.equals("lock")) {
			staff.setState(2);
		} else if (types.equals("unlock")) {
			staff.setState(1);
		} else if (types.equals("setadmin")) {
			staff.setState(0);
		}

		ss.modifyStaffInfo(staff);
		resp.sendRedirect("staffList?pageNo=" + pageNo);

	}

}
