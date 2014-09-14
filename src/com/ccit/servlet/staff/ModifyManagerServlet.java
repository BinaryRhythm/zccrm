package com.ccit.servlet.staff;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/modifyManager")
public class ModifyManagerServlet extends ServletBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2362145700894098516L;

//	s.setId(4);
//	s.setAreaID(4);
//	s.setAddr("山东烟台");
//	s.setEmail("1504537@qq.com");
//	s.setName("林涵");
//	s.setPwd("123446");
//	s.setTel("13865808808");
//	s.setLimits("测试人员1");
//	s.setLeaderID(1);
	
	@Override
	public void proc(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		String email = this.getString(req, "email"); 
		String name = this.getString(req, "email");
		String pwd = this.getString(req, "email");
		String tel = this.getString(req, "email");
		String limits = this.getString(req, "email");
		String areaId = this.getString(req, "email");
		String LeaderId = this.getString(req, "email");
		String addr = this.getString(req, "email");
		
		System.out.println(email);
		
		
		req.getRequestDispatcher("modify_manager.jsp").forward(req, resp);
		
		resp.getWriter().println("<script language='javascript'>alert('更新成功！')</script>");
		
	}

	
	
}
