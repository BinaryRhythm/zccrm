package com.ccit.servlet.staff;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ccit.beans.Staff;
import com.ccit.service.StaffService;
import com.ccit.util.MD5;

@WebServlet("/modifyManager")
public class ModifyManagerServlet extends ServletBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2362145700894098516L;

	@Override
	public void proc(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Staff s = new Staff();
		StaffService ss = (StaffService) this.getServletContext().getAttribute(
				"ss");

		String email = this.getString(req, "email");
		String name = this.getString(req, "name");
		String pwd = this.getString(req, "pwd");
		String tel = this.getString(req, "tel");
		String limits = this.getString(req, "limits");
		Integer areaId = this.getInt(req, "areaId");
		String leaderName = this.getString(req, "leaderName");
		String addr = this.getString(req, "addr");

		s.setId(1);
		s.setAreaID(areaId);
		s.setAddr(addr);
		s.setEmail(email);
		s.setName(name);

		System.out.println(email + " -" + areaId + " -" + addr + " -" + name
				+ " -" + pwd + " -" + tel + "- " + limits + "-leader:"
				+ leaderName + "-");

		try {
			s.setPwd(MD5.md5(pwd));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.setTel(tel);
		s.setLimits(limits);

		Integer LeaderId = ss.getIdByName(leaderName);
		System.out.println(LeaderId);
		s.setLeaderID(LeaderId);
		s.setPwd(pwd);
		s.setState(0);

		String str = "";
		ss.modifyStaffInfo(s);
		if (true)
			str = "修改成功！！";
		else
			str = "修改失败。";

		resp.getWriter().println(
				"<script language='javascript'>alert('" + str + "')</script>");
	}

}
