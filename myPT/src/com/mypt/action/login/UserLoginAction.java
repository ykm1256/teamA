package com.mypt.action.login;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mypt.controller.Action;
import com.mypt.dao.UserDao;
import com.mypt.dto.UserDto;

public class UserLoginAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		UserDao dao = UserDao.getInstance();
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		int flag = dao.userLogin(email, pw);
		System.out.println(flag);
		if(flag==1) {
		 UserDto user = dao.getUserByEmail(email);		
		 HttpSession session = request.getSession();
		 session.setAttribute("id", user.getId());
		 session.setAttribute("name", user.getName());
		 session.setAttribute("nick", user.getNick());		
		 session.setAttribute("email", user.getEmail());
		 session.setAttribute("grade", 2);
		}
		
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("result", flag);
		
		
		return "callback";
	}

}
