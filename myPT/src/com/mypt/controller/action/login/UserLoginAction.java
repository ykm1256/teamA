package com.mypt.controller.action.login;

import java.io.PrintWriter;

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
		UserDao dao = new UserDao();
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		int flag = dao.userLogin(email, pw);
		System.out.println(flag);
		if(flag==1) {
		 UserDto user = dao.getUser2(email);		
		 HttpSession session = request.getSession();
		 session.setAttribute("name", user.getName());
		 session.setAttribute("nick", user.getNick());		 
		}
		
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("flag", flag);
		
		
		return "callback";
	}

}
